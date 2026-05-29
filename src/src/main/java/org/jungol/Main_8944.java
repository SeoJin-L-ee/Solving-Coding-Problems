package org.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_8944 {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] weight = new int[N*15];
        int[] cost = new int[N*15];
        int[] backpack = new int[M+1];
        
        int idx = 0;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int W = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	// (1, 2, 4, .... , 남는수) 이런 식으로 분할해서, 각 수를 W랑 C에 곱해서 배열에 넣기
        	int temp = 1;
        	while (K > 0) {
        		int eachCnt = Math.min(temp, K);
        		weight[idx] = eachCnt * W;
        		cost[idx] = eachCnt * C;
        		idx++;
        		temp *= 2;
        		K -= eachCnt;
        	}
		}
        
        // 0/1 knapsack
        for (int i = 0; i < idx; i++) {
            for (int j = M; j >= weight[i]; j--) {
                backpack[j] = Math.max(backpack[j], backpack[j-weight[i]] + cost[i]);
            }
        }
        System.out.println(backpack[M]);
    }
}
