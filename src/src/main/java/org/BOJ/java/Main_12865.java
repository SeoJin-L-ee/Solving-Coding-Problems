package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weight = new int[N];
		int[] value = new int[N];
		int[][] knapsack = new int[N+1][K+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
		        if (j < weight[i-1]) {
		        	// 현재 물건 무게가 배낭의 남은 허용 무게보다 무거우면, 이전 단계 가치를 그대로 (넣지 않기)
		            knapsack[i][j] = knapsack[i-1][j];
		        } else {
		        	// 현재 물건을 선택했을 때와 선택하지 않았을 때를 비교
		            int now = knapsack[i-1][j - weight[i-1]] + value[i-1];
		            int pre = knapsack[i-1][j];
		            knapsack[i][j] = now>=pre ? now:pre;
		        }
		    }
		}
		System.out.println(knapsack[weight.length-1][K]);
	}
}
