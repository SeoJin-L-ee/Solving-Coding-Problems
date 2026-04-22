package org.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_BitMasking {
	private static int[] kyu = new int[9]; // 규영이 카드덱
	private static int[] iny = new int[9]; // 인영이 카드덱
	
	private static int selectedByKyu; // 전체 카드 18장 중 규영이가 선택한 카드를 비트마스킹으로 표현
	private static int win, lose; // 인영이 승리/패배 횟수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			win = 0;
			lose = 0;
			selectedByKyu = 0;
			
			// 규영이 카드 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int input = Integer.parseInt(st.nextToken()); 
				kyu[j] = input;
				selectedByKyu |= 1 << (input-1);
			}
			// 규영이가 뽑지 않은 카드 기준으로 인영이 카드 뽑기
			int inyCardCnt = 0;
			for (int j = 0; j < 18; j++) {
				if ((selectedByKyu & 1<<j) == 0) {
					iny[inyCardCnt++] = j+1;
				}
			}
			// 인영이 카드에 대해 경우의 수 돌리는 재귀함수 호출
			permutation(0, 0, 0, 0);
			
			System.out.println("#" + (i+1) + " " + win + " " + lose);
		}
	}
	
	private static void permutation(int depth, int kyuScore, int inyScore, int visited) {
		
		// 인영이 카드순서조합 다 뽑았으면 점수 계산
		if (depth == 9) {
			if (kyuScore > inyScore) win++;
			else if (inyScore > kyuScore) lose++;
			return;
		}
		// 인영이 카드순열 결정하는 재귀함수
		for (int i = 0; i < 9; i++) {
			if ((visited & 1<<i) == 0) {
				
				// 규영이와 인영이의 카드 비교 후 점수에 합산
				// 합산된 점수를 가지고 다음 permutation() 호출
				if (iny[i] > kyu[depth]) {
					permutation(depth+1, kyuScore, inyScore + iny[i] + kyu[depth], visited | 1<<i);
				} else {
					permutation(depth+1, kyuScore + iny[i] + kyu[depth], inyScore, visited | 1<<i);
				}
			}
		}
	}
}
