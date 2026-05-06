package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17143 {
	
	static class Shark {
		int index;
		int row;
		int col;
		int speed;
		int direct;
		int size;
		
		public Shark(int index, int row, int col, int speed, int direct, int size) {
			this.index = index;
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.direct = direct;
			this.size = size;
		}

		void move() {
			int moveDist;
			// 세로 방향으로 움직이는 상어의 경우
			if (direct == 1 || direct == 2) {
				// 주기로 나머지연산 수행해서 이동 수 감소
				moveDist = speed % rowPeriod;
				// moveDist만큼 이동
				for (int i = 0; i < moveDist; i++) {
				    row += dr[direct];
				    // 경계값 넘으면, 방향 바꾼 후 반대로 이동
				    if (row < 1 || row > R) {
				        direct = direct==1 ? 2:1; // 위/아래 방향 전환
				        row += dr[direct] * 2;
				    }
				}
			}
			// 가로 방향으로 움직이는 상어의 경우
			if (direct == 3 || direct == 4) {
				moveDist = speed % colPeriod;
				for (int i = 0; i < moveDist; i++) {
				    col += dc[direct];
				    if (col < 1 || col > C) {
				        direct = (direct == 3) ? 4 : 3; // 좌/우 방향 전환
				        col += dc[direct] * 2;
				    }
				}
			}
			// 만약 이동 후의 위치 grid가 null이 아니면, 크기 비교 후 작은 상어 제거
			if (grid[row][col] != null) {
				Shark preShark = sharks.get(grid[row][col]);
				if (preShark.size > this.size) {
					removeList.add(this.index);
					return;
				} else {
					removeList.add(preShark.index);
					grid[row][col] = this.index;
				}
			}
			// 이동 후의 위치를 grid에 기록
			grid[row][col] = this.index;
		}
	}
	
	static int R;
	static int C;
	static int M; // 상어 수
	static HashMap<Integer, Shark> sharks;
	static Integer[][] grid; // 바다 격자
	static List<Integer> removeList; // 순회 중인 컬렉션을 수정할 수가 없어서 따로 관리
	static int rowPeriod, colPeriod; // 다시 자기 자리로 돌아오기까지의 주기
	static int[] dr = {0, -1, 1, 0, 0}; // 문제 조건에 따라 {상,하,우,좌}
	static int[] dc = {0, 0, 0, 1, -1};
	static int totalSize = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화 부분
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharks = new HashMap<Integer, Shark>();
		grid = new Integer[R+1][C+1];
		removeList = new ArrayList<>();
		
		int r, c, s, d, z;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			// Shark 객체 생성해서 리스트에 추가
			sharks.put(i, new Shark(i, r, c, s, d, z));
			// 그리드에 초기 상어 위치 기록
			grid[r][c] = i;
		}
		rowPeriod = (R-1)*2;
		colPeriod = (C-1)*2;
		
		// 낚시하기 시작
		for (int i = 1; i <= C; i++) {
			// 수면과 가장 가까운 상어 잡기 (해당 열에서 grid[row][col] != null인 첫번째 칸)
			for (int j = 1; j <= R; j++) {
				// 해당 열에 상어가 있어서 잡았으면
				if (grid[j][i] != null) {
					totalSize += sharks.get(grid[j][i]).size;
					// 잡은 상어를 리스트와 grid에서 제거
					sharks.remove(grid[j][i]);
					grid[j][i] = null;
					break;
				}
			}
			// grid에서 상어 위치 null로 변경 (초기화)
			for (Shark shark : sharks.values()) {
				grid[shark.row][shark.col] = null;
			}
			// 모든 상어들(리스트로 관리)에 대해 move();
			for (Shark shark : sharks.values()) {
				shark.move();
			}
			// 먹힌 상어들에 대해 한번에 remove
			for (int index : removeList) {
				sharks.remove(index);
			}
		}
		System.out.println(totalSize);
	}
}
