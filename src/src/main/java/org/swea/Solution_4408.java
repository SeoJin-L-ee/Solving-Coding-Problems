package org.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4408 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		int N;
		int[] hall;
		int answer;

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			hall = new int[201];
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				// 복도 구간 인덱스로 변환
				from = (from+1)/2;
				to = (to+1)/2;

				// from보다 to가 항상 큰 값이도록 swap
				if (from > to) {
					int temp = from;
					from = to;
					to = temp;
				}
				// 학생들이 이동한 복도 구간만 카운트++
				for (int j = from; j <= to; j++) {
					hall[j]++;
				}
			}
			// 가장 많이 겹친 복도 구간의 동선 수 카운트
			for (int i = 1; i < 201; i++) {
				if (hall[i] > answer) answer = hall[i];
			}
			sb.append("#" + t + " " + answer).append("\n");
		}
		System.out.println(sb);
	}
}
