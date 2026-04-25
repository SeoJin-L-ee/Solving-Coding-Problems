package org.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
 * visited 사용하지 않고 maze를 int[][] 로 선언한 후,
 * 0으로 되어 있는 길을 지나가면, 0이 아니라 다른 값(현재 경로에서 걸린 시간)을 넣어줄 경우
 * 경계값 체크해줄 때 같이 0인지 체크만 해주면, 방문하지 않은 길임을 알 수 있음!
 */
public class Main_1661 {
	public static void main(String[] args) throws IOException {
		boolean[][] maze;
		boolean[][] visited;
		int X, Y; // 배열 크기 (col, row)
		int sX, sY, eX, eY; // 시작점과 끝점의 x, y 좌표
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		maze = new boolean[Y][X];
		visited = new boolean[Y][X];
		st = new StringTokenizer(br.readLine());
		sX = Integer.parseInt(st.nextToken());
		sY = Integer.parseInt(st.nextToken());
		eX = Integer.parseInt(st.nextToken());
		eY = Integer.parseInt(st.nextToken());
		
		// 길 위치 매핑
		for (int i = 0; i < Y; i++) {
			String line = br.readLine();
			for (int j = 0; j < X; j++) {
				maze[i][j] = line.charAt(j) == '1';
			}
		}
		
		// 첫번째 위치 큐에 넣고 방문처리
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sY-1, sX-1, 0});
		visited[sY-1][sX-1] = true;
		
		while (!q.isEmpty()) {
			// 큐에서 노드 추출
			int[] curr = q.poll();
			int currR = curr[0];
			int currC = curr[1];
			int currT = curr[2];
			// 추출한 위치가 도착 위치면 걸린 시간 출력
			if ((currR == eY-1) && (currC == eX-1)) {
				System.out.println(currT);
				return;
			}
			// 도착 위치가 아닌 경우 상하좌우 방향 탐색
			for (int i = 0; i < 4; i++) {
				int nr = currR + dr[i];
				int nc = currC + dc[i];
				// 경계를 벗어나지 않고, 길이면서, 방문하지 않은 방향이 있을 시
				if (nr > -1 && nr < Y && nc > -1 && nc < X && !maze[nr][nc] && !visited[nr][nc]) {
					// 해당 위치 큐에 넣고 방문처리
					q.offer(new int[] {nr, nc, currT+1});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
