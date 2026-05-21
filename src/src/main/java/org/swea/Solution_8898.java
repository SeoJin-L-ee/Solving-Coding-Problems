package org.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3차원 농부
public class Solution_8898 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int minDist, minCnt, finalMinDist;
		int N, M;
		int c1, c2;
		int[] cowZ, horZ;
		
		for (int t = 1; t <= T; t++) {
			// 초기화 부분
			minDist = Integer.MAX_VALUE;
			minCnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			cowZ = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cowZ[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			horZ = new int[M];
			for (int i = 0; i < M; i++) {
				horZ[i] = Integer.parseInt(st.nextToken());
			}
			
			// 특정 소와 가장 가까운 말의 위치를 이진탐색으로 찾기 위해서 정렬
			Arrays.sort(horZ);
			
			// 각 소에 대해 가장 가까운 말과의 거리를 재고, 최단거리 및 카운트 갱신
			for (int i = 0; i < N; i++) {
				int curCow = cowZ[i];
				int closestHor = Arrays.binarySearch(horZ, curCow);
				// 동일한 값 없으면 음수 인덱스 반환하니까 도로 바꿔주기
				if (closestHor < 0) closestHor = -(closestHor+1);
				
				// closestHor 위치 말과의 거리 측정 (소 위치보다 이후에 있는 말)
				int tempDist;
				if (closestHor < M) { // 근데 당연히 최대 말 인덱스보다 작아야 함
					tempDist = horZ[closestHor] - curCow;
					if (tempDist < minDist) {
						// 최단거리 및 카운트 갱신
						minDist = tempDist;
						minCnt = 1;
					} else if (tempDist == minDist) {
						// 동일 최단거리인 소&말 또 존재
						minCnt++;
					}
				}
				// closestHor-1 위치 말과의 거리 측정 (소 위치보다 이전에 있는 말)
				if (closestHor > 0) {
					tempDist = curCow - horZ[closestHor-1];
					if (tempDist < minDist) {
						// 최단거리 및 카운트 갱신
						minDist = tempDist;
						minCnt = 1;
					} else if (tempDist == minDist) {
						// 동일 최단거리인 소&말 또 존재
						minCnt++;
					}
				}
			}
			finalMinDist = Math.abs(c2 - c1) + minDist;
			sb.append("#" + t + " " + finalMinDist + " " + minCnt).append("\n");
		}
		System.out.println(sb);
	}
}
