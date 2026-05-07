package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
		int[] dc = {0, 1, 0, -1};
		
		int answerCnt = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		// 로봇청소기 작동 시작
		while (true) {
			// 현재 위치 청소되지 않은 경우
			if (room[row][col] == 0) {
				room[row][col] = 2;
				answerCnt++;
			}
			int check, nr, nc;
			for (check = 0; check < 4; check++) {
				dir = (dir+3)%4;
				nr = row + dr[dir];
				nc = col + dc[dir];
				// 앞쪽 칸이 청소되지 않았으면
				if (room[nr][nc] == 0) {
					row = nr;
					col = nc;
					break;
				}
			}
			// 네방향 모두 청소할 수 없으면 (break를 만난 적이 없으면)
			if (check == 4) {
				nr = row + dr[(dir+2)%4];
				nc = col + dc[(dir+2)%4];
				// 후진 방향이 벽이면
				if (room[nr][nc] == 1) {
					System.out.println(answerCnt);
					return;
				}
				// 후진 방향이 벽이 아니면 후진
				row = nr;
				col = nc;
			}
		}
	}
}
