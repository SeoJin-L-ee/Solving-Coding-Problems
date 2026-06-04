package org.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1824 {
	static int[][] sudoku;
	static ArrayList<int[]> zeros;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sudoku = new int[9][9];
		zeros = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int temp = Integer.parseInt(st.nextToken());
				sudoku[i][j] = temp;
				// 0 위치 기록해 놓기
				if (temp == 0) zeros.add(new int[] {i, j});
			}
		}
		dfs(0);
	}
	
	static void dfs(int zeroNum) {
		if (zeroNum == zeros.size()) {
			// 모든 빈칸을 다 채웠으면 출력
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		int zeroRow = zeros.get(zeroNum)[0];
		int zeroCol = zeros.get(zeroNum)[1];
		
		// 현재 빈칸에 1~9까지 수를 넣을 수 있는지 체크
		for (int i = 1; i < 10; i++) {
			if (canWrite(i, zeroRow, zeroCol)) {
				// 적을 수 있으면 값 채워 넣고, 다음 0에 대해 진행
				sudoku[zeroRow][zeroCol] = i;
				dfs(zeroNum+1);
				// 새로 호출된 dfs()의 모든 canWrite()가 false였던 경우, 실패니까 값 복구
				sudoku[zeroRow][zeroCol] = 0;
			}
		}
	}
	
	// 연산 횟수가 늘어나면 배열로 체크해도 될듯
	static boolean canWrite(int num, int zeroRow, int zeroCol) {
		// 가로 줄에 겹치는 수 있는지
		boolean colOk = true;
		for (int i = 0; i < 9; i++) {
			if (sudoku[zeroRow][i] == num) {
				colOk = false;
			}
		}
		// 세로 줄에 겹치는 수 있는지
		boolean rowOk = true;
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][zeroCol] == num) {
				rowOk = false;
			}
		}
		// 네모 안에 겹치는 수 있는지
		boolean sqrOk = true;
		int sqrStrRow = (zeroRow/3)*3;
		int sqrStrCol = (zeroCol/3)*3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudoku[sqrStrRow+i][sqrStrCol+j] == num) {
					sqrOk = false;
				}
			}
		}
		// 하나라도 안 되면 false 반환
		return colOk && rowOk && sqrOk;
	}
}
