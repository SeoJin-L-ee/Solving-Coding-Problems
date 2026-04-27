package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// S1
public class Main_2468 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int maxheight = 0;
	static int currCnt, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxheight = Math.max(maxheight, map[i][j]);
			}
		}
		for (int i = 0; i < maxheight; i++) {
			currCnt = 0;
			visited = new boolean[N][N];
			// maxheight보다 낮거나 같은 곳은 visited true
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] <= i) {
						visited[j][k] = true;
					}
				}
			}
			// 전체 배열에 대해서 visited false인 곳 기준으로 
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[j][k]) {
						// 해당 지점과 인접한 모든 지역을 true
						dfs(j, k);
						currCnt++;
					}
				}
			}
			answer = Math.max(answer, currCnt);
		}
		System.out.print(answer);
	}

	static void dfs(int row, int col) {
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			// 경계 내에 있고 방문한 적 없으면
			if (nr > -1 && nr < N && nc > -1 & nc < N && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}
}
