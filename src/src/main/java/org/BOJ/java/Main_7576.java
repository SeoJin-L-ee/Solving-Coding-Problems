package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_7576 {
	public static void main(String[] args) throws IOException {
		int[][] storage;
		ArrayDeque<int[]> ripeTmt = new ArrayDeque<>();
		int zeroCnt = 0;
		int maxDay = 0;
		int[] dr = new int[] {-1, 1, 0, 0};
		int[] dc = new int[] {0, 0, -1, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		storage = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				storage[i][j] = temp;
				if (temp == 1) {
					// 모든 1의 위치를 저장
					ripeTmt.add(new int[] {i, j, 0});
				} else if (temp == 0) {
					// 모든 0의 수를 카운트
					zeroCnt++;
				}
			}
		}
		// 만약 0 개수 카운트가 0개이면(== 안 익은 토마토가 없으면 == 전부 익은 토마토면), 0 출력하고 종료
		if (zeroCnt == 0) {
			System.out.println(0);
			return;
		}
		// 저장한 1 위치들에 대해서 BFS 진행
		while (!ripeTmt.isEmpty()) {
			int[] curr = ripeTmt.poll();
			int row = curr[0];
			int col = curr[1];
			int depth = curr[2];
			
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				// 경계값 내의 0 위치 발견하면
				if (nr < N && nr > -1 && nc < M && nc > -1 && storage[nr][nc] == 0) {
					// 몇번만에 도착했는지 depth 저장(depth -> 큐의 세번째 인자, 걸린 일 수를 의미)하고 익은 토마토로 처리
					storage[nr][nc] = depth+1;
					ripeTmt.add(new int[] {nr, nc, depth+1});
					zeroCnt--;
				}
			}
		}
		// 만약 아직 0인(안 익은) 토마토가 남아 있다면, -1 반환
		if (zeroCnt > 0) {
			System.out.println(-1);
			return;
		}
		// 창고를 전부 탐색했을 때의 가장 큰 수가, 토마토가 익는데 걸리는 최소 날짜
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maxDay = Math.max(maxDay, storage[i][j]);
			}
		}
		System.out.println(maxDay);
	}
}
