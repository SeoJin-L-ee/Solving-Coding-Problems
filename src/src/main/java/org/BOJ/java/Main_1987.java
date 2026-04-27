package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {
	static int R, C;
	static char[][] board;
	static boolean[] checked;
	static int maxCnt = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		checked = new boolean[26];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		dfs(0, 0, board[0][0] - 'A', 1);
		System.out.print(maxCnt);
	}
	
	static void dfs(int row, int col, int alphNum, int cnt) {
		checked[alphNum] = true;
		maxCnt = Math.max(maxCnt, cnt);
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			// 경계 내에 있고
			if (nr > -1 && nr < R && nc > -1 & nc < C) {
				// 방문한 적 없는 알파벳이면
				if (!checked[board[nr][nc] - 'A']) {
					dfs(nr, nc, board[nr][nc] - 'A', cnt+1);
				}
			}
		}
		checked[alphNum] = false;
	}
}
