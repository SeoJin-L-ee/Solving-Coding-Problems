package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화 부분
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c;
		int[] dp = new int[k+1];
		
		// 초기값 설정
		dp[0] = 1;

		/*
		 * 1, 2, 5에 대해 합이 10이 되도록 구하려면
		 * dp[10] = dp[10-1] + dp[10-2] + dp[10-5]
		 * 
		 * 특정 동전의 값어치보다 적은 합을 만들 때는, 특정 동전이 반영되지 않게 해야하므로
		 * 각 동전에 대해서, 각 동전 값어치부터 합까지의 범위동안, dp[i] += dp[i - c]
		 * -> 순서만 다른 같은 조합에 대해서 구분하지 않게 됨
		 */
		for (int i = 0; i < n; i++) {
			c = Integer.parseInt(br.readLine().trim());
			for (int j = c; j <= k; j++) {
				dp[j] += dp[j-c];
			}
		}
		System.out.println(dp[k]);
	}
}
