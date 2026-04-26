package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 인접행렬로 구현 시, 친구가 아닌 노드도 일일이 탐색하게 돼서인지 시간초과 남.
// 인접리스트로 바꿔서 구현 후 통과
public class Main_13023 {
	static int N, M;
	static ArrayList<Integer>[] rel;
	static int answer = 0;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rel = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			rel[i] = new ArrayList<>();
		}
		
		// 친구관계 매핑
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rel[a].add(b);
			rel[b].add(a);
		}

		// dfs
		for (int i = 0; i < N; i++) {
			dfs(i, 0);
			if (answer == 1) {
				System.out.print(answer);
				return;
			}
		}
		System.out.print(answer);
	}
	
	static void dfs(int curr, int cnt) {
		visited[curr] = true;
		// 연결된 친구관계가 5명이면 answer는 1
		if (cnt == 4) {
			answer = 1;
			return;
		}
		for (int friend : rel[curr]) {
			// curr와 친구 중, 방문하지 않은 친구가 있으면
			if (!visited[friend]) {
				dfs(friend, cnt+1);
			}
		}
		visited[curr] = false;
	}
}
