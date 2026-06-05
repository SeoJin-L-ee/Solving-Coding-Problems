package org.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3431 {
	static class Wood implements Comparable<Wood> {
		int id;
		int x1, x2, y;
		public Wood(int id, int x1, int x2, int y) {
			this.id = id;
			this.x1 = x1;
			this.x2 = x2;
			this.y = y;
		}
		@Override
		public int compareTo(Wood w) {
			return Integer.compare(this.x1, w.x1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		Wood[] woods = new Wood[N];
		int[] cnctInfo = new int[N+1];
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            woods[i] = new Wood(i+1, x1, x2, y);
		}
		
		Arrays.sort(woods);
		
		int cnctIdx = 0, maxX2 = 0;
		for (Wood wood : woods) {
			if (maxX2 < wood.x1) {
				// 새 덩어리
				cnctIdx++;
				maxX2 = wood.x2;
			}
			else {
				// 덩어리 이어짐
				maxX2 = Math.max(maxX2, wood.x2);
			}
			cnctInfo[wood.id] = cnctIdx;
		}
		
		// 통나무 예시 받아서 연결되는지 출력
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (cnctInfo[a] == cnctInfo[b]) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
}
