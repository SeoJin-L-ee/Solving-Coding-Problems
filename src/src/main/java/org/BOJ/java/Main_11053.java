package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 초기화 부분
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] memo = new int[N];
        
        for (int i = 0; i < N; i++) {
        	memo[i] = 1;
        	for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					// i보다 이전 인덱스의 수들 중, 현재 수보다 작은 수가 있으면(부분 수열 이루기 가능한 경우)
					// j 번째 수의 최장길이 부분수열에 i 번째 수도 추가한 길이와, i 번째 수의 현재까지의 최장길이를 비교해서 더 긴 값 저장
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}
        int answer = 0;
        for (int i = 0; i < N; i++) {
			answer = Math.max(answer, memo[i]);
		}
        System.out.println(answer);
    }
}
