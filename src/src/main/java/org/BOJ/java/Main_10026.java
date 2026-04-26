package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_10026 {
	static int N;
	static char[][] grid;
	static boolean[][] visited;
	static ArrayDeque<int[]> q;
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	static int nr, nc;
	static int area = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		
		// 일반인 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					area++;
					bfs(i, j, grid[i][j]);
				}
			}
		}
		System.out.print(area + " ");
		
		// 색약 카운트를 위해 초기화
		visited = new boolean[N][N];
		area = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 초록색이면, 색약 카운트를 위해 R로 수정
				if (grid[i][j] == 'G') {
					grid[i][j] = 'R';
				}
			}
		}
		
		// 적록색약 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					area++;
					bfs(i, j, grid[i][j]);
				}
			}
		}
		System.out.print(area);
	}
	
	static void bfs(int row, int col, char color) {
		q = new ArrayDeque<>();
		q.add(new int[] {row, col});
		visited[row][col] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int i = 0; i < 4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				// 경계 내에 있으면서, 현재 체크하는 영역 색과 동일한 색이고 방문한 적이 없으면 add
				if (nr > -1 && nr < N && nc > -1 && nc < N && grid[nr][nc] == color && !visited[nr][nc]) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
