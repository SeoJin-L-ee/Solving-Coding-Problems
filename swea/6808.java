package com.ureca.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 6808 {
	private static int[] kyu = new int[9]; // 규영이 카드덱
	private static int[] iny = new int[9]; // 인영이 카드덱
	
	private static boolean[] selectedByKyu; // 전체 카드 18장 중 규영이가 선택한 카드 마킹
	private static boolean[] visitied; // 인영이 카드 순서 결정 시, 골라진 카드인지 여부
	
	private static int depth; // 인영이가 낼 카드순서조합 중 결정된 카드 수
	private static int win, lose; // 인영이 승리/패배 횟수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			win = 0;
			lose = 0;
			visitied = new boolean[9];
			selectedByKyu = new boolean[18];
			
			// 규영이 카드 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int input = Integer.parseInt(st.nextToken()); 
				kyu[j] = input;
				selectedByKyu[input - 1] = true; // 규영이가 뽑은 카드 마킹
			}
			// 규영이가 뽑지 않은 카드 기준으로 인영이 카드 뽑기
			int inyCardCnt = 0; // 인영이가 현재까지 뽑은 카드 수
			for (int j = 0; j < 18; j++) {
				if (!selectedByKyu[j]) {
					iny[inyCardCnt++] = j + 1;
				}
			}
			// 인영이 카드에 대해 경우의 수 돌리는 재귀함수 호출
			permutation(0, 0, 0);
			
			System.out.println("#" + (i+1) + " " + win + " " + lose);
		}
	}
	
	private static void permutation(int depth, int kyuScore, int inyScore) {
		
		// 인영이 카드순서조합 다 뽑았으면 점수 계산
		if (depth == 9) {
			if (kyuScore > inyScore) {
				win++;
				return;
			} else if (inyScore > kyuScore) {
				lose++;
				return;
			}
		}
		// 인영이 카드순열 결정하는 재귀함수
		for (int i = 0; i < 9; i++) {
			if (!visitied[i]) {
				visitied[i] = true;
				// 규영이와 인영이의 카드 비교 후 점수에 합산
				// 합산된 점수를 가지고 다음 permutation() 호출
				if (iny[i] > kyu[depth]) {
					permutation(depth+1, kyuScore, inyScore + iny[i] + kyu[depth]);
				} else if (kyu[depth] > iny[i]) {
					permutation(depth+1, kyuScore + iny[i] + kyu[depth], inyScore);
				}
				visitied[i] = false;
			}
		}
	}
}
