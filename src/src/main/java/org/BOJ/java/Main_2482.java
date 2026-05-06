package org.BOJ.java;

import java.util.Scanner;

public class Main_2482 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		long NUM = 1000000003L;
		long[][] memo = new long[N+1][K+1];
		
		// 인덱스에러 안 나게 값 초기화
		memo[0][0] = 1;
		memo[1][0] = 1;
		memo[1][1] = 1;

		for (int i = 2; i <= N; i++) {
			memo[i][0] = 1; // 0개를 선택하는 경우의 수 초기화
			for (int j = 1; j <= K; j++) {
				// 선택안함 + 선택함
				memo[i][j] = (memo[i-1][j] + memo[i-2][j-1]) % NUM;
			}
		}
		// 첫번째 색 선택/비선택 경우의 수를 합해서, 최종 경우의 수 출력
		System.out.println((memo[N-3][K-1] + memo[N-1][K]) % NUM);
	}
}
