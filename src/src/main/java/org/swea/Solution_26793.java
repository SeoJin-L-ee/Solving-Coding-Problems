package org.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 게으름뱅이
public class Solution_26793 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int[][] TDs;
		long minVideo;
		
		for (int t = 1; t <= T; t++) {
			// 초기화 부분
			minVideo = Long.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			TDs = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				TDs[i][0] = Integer.parseInt(st.nextToken());
				TDs[i][1] = Integer.parseInt(st.nextToken());
			}
			// Ti 기준으로 오름차순 정렬
			Arrays.sort(TDs, (a, b) -> Integer.compare(a[1], b[1]));
			
			// 배열의 과제들에 대해서, (현재 과제의 Ti - 여태까지의 Di 합)을 계산한 후 해당 값의 min을 갱신하면서 진행
			long diSum = 0;
			for (int i = 0; i < N; i++) {
				diSum += TDs[i][0];
				minVideo = Math.min(minVideo, TDs[i][1] - diSum);
			}
			sb.append(minVideo).append("\n");
		}
		System.out.println(sb);
	}
}
