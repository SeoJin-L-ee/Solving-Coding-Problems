package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N+1]; // 입력받은 비교 저장
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		int[] inDgree = new int[N+1];
		Queue<Integer> q = new ArrayDeque<>(); // 진입차수가 0인 학생을 넣는 큐
		ArrayList<Integer> result = new ArrayList<Integer>(); // 위상정렬된 결과를 저장
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			inDgree[b]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (inDgree[i] == 0) {
				q.add(i);
			}
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			result.add(cur);
			
			for (Integer next : list[cur]) {
				if (--inDgree[next] == 0) {
					q.add(next);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + " ");
		}
		System.out.println(sb);
	}
}
