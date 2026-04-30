package org.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251 {
	static class Node implements Comparable<Node>{
    	int v; 
    	double w;
    	
		public Node(int no, double weight) {
			super();
			this.v = no;
			this.w = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.w, o.w);
		}
    }
	
	static int[] xs;
	static int[] ys;
	static int N;
	static double E;
	static ArrayList<Node>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			// 초기화 부분
			N = Integer.parseInt(br.readLine());
			xs = new int[N];
			ys = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i  < N; i ++) {
				xs[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				ys[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			graph = new ArrayList[N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			// i에서 j로 가는 환경부담금(cost) 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 비용 계산
					long tempX = xs[i] - xs[j];
					long tempY = ys[i] - ys[j];
					double cost = E * (tempX*tempX + tempY*tempY);
					
					graph[i].add(new Node(j, cost));
				}
			}
			double answer = prim(0);
			// 소수점 첫번째자리에서 반올림하여 출력
			sb.append("#" + t + " " + Math.round(answer)).append("\n");
		}
		System.out.println(sb);
	}
	
	static double prim(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(st, 0));
		
		double totalCost = 0;
		int cnt = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.v]) continue;
			
			visited[curr.v] = true;
			totalCost += curr.w;
			if (++cnt == N) break;
			
			for (Node node : graph[curr.v]) {
				if (!visited[node.v]) {
					pq.offer(node);
				}
			}
		}
		return totalCost;
	}
}
