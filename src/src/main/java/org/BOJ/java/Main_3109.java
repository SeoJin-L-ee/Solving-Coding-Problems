package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109 {
	static int R, C;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static int pipeCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j) == 'x'; // 막혀있으면 1
			}
		}
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			if (dfs(i, 0)) {
				// true를 return받으면 총 연결된 파이프 수++
				pipeCnt++;
			}
		}
		System.out.print(pipeCnt);
	}

	static boolean dfs(int row, int col) {
		if (col == C-1) { // 마지막 열에 도달하면
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			// 경계값 체크, 건물(x)이 아닌지, 방문하지 않았는지 확인
			if (nr > -1 && nr < R && nc > -1 && nc < C && !map[nr][nc] && !visited[nr][nc]) {
				visited[nr][nc] = true; // 방문표시
				// true 반환받았다면
				if (dfs(nr, nc)) {
					//해당 경로를 확정시키고 종료
					return true;
				}
			}
		}
		// 이 부분까지 내려온 경우, 이후의 길들은 연결될 수 없는 길이라는 뜻
		return false;
	}
}
