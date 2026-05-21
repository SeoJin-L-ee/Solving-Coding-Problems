package org.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 동현이와 한결이는 아이돌
public class Solution_8676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		long[] memo;
		String samsung = "SAMSUNG";
		long mod = 1000000007L;
		
		for (int t = 1; t <= T; t++) {
			String S  = br.readLine();
			memo = new long[8];
			memo[0] = 1; // 초기값
			
			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < 7; j++) {
					if (S.charAt(i) == samsung.charAt(j)) {
						// memo[7] -> 현재까지 읽은 문자열로 SAMSUNG 만드는 횟수 == 현재까지 읽은 문자열로 SAMSUN 만들었던 횟수 + 그 이후 G가 등장한 횟수
						memo[j+1] = (memo[j+1] + memo[j]) % mod;
					}
				}
			}
			sb.append("#" + t + " " + memo[7]).append("\n");
		}
		System.out.println(sb);
	}
}
