package org.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012 {
	static int N;
	static int[][] synergy;
	static boolean[] isFood1; // true면 음식1, false면 음식2
	static int minScoreGap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			isFood1 = new boolean[N];
			minScoreGap = Integer.MAX_VALUE;
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					synergy[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			subset(0, 0);
			sb.append("#" + (i+1) + " " + minScoreGap);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void subset(int depth, int cnt) { // depth: 현재까지 확인한 재료의 수, cnt: 현재까지 음식1의 재료로 선택한 수
		if (depth >= N) {
			return;
		}
		if (cnt == N/2) {
			calculate();
			return;
		}
		// 현재 재료를 선택 (음식1의 재료)
		isFood1[depth] = true;
		subset(depth+1, cnt+1);
		// 현재 재료를 미선택 (음식2의 재료)
		isFood1[depth] = false;
		subset(depth+1, cnt);
	}
	
	static void calculate() {
		int food1Score = 0;
		int food2Score = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isFood1[i] && isFood1[j]) {
					// i번째 재료와 j번째 재료가 모두 음식1의 재료일 경우
					food1Score += synergy[i][j];
				} else if (!isFood1[i] && !isFood1[j]) {
					// i번째 재료와 j번째 재료가 모두 음식2의 재료일 경우
					food2Score += synergy[i][j];
				}
			}
		}
		minScoreGap = Math.min(minScoreGap, Math.abs(food1Score - food2Score));
	}
}
