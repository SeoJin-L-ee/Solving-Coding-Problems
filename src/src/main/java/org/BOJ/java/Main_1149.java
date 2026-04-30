package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 {
	static int[][] cost;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 초기화 부분
		int N = Integer.parseInt(br.readLine().trim());
		cost = new int[N+1][3];
		result = new int[N+1][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기값 설정
		result[0][0] = cost[0][0];
		result[0][1] = cost[0][1];
		result[0][2] = cost[0][2];
		
		for (int i = 1; i <= N; i++) {
			result[i][0] = cost[i][0] + Math.min(result[i-1][1], result[i-1][2]);
			result[i][1] = cost[i][1] + Math.min(result[i-1][0], result[i-1][2]);
			result[i][2] = cost[i][2] + Math.min(result[i-1][0], result[i-1][1]);
		}
		System.out.println(Math.min(result[N][0], Math.min(result[N][1], result[N][2])));
	}
}
