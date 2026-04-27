package org.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234 {
	static int N;
	static int[] weights;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			weights = new int[N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				 weights[j] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			
			backtracking(0, 0, 0);
			System.out.println("#" + (i+1) + " " + answer);
		}
	}

	static void backtracking(int cnt, int leftSum, int rightSum) {
	    if (cnt == N) { // 카운트가 N이 되면 (모든 추를 올렸으면)
	    	answer++;
	    	return;
	    }
	    for (int i = 0; i < N; i++) {
	    	if (!visited[i]) {
	    		visited[i] = true;
	    		int weight = weights[i];

		    	// 왼쪽에 올리기
		    	backtracking(cnt+1, leftSum + weight, rightSum);

		    	// 오른쪽에 올리기
		    	if (rightSum + weight <= leftSum) { // 가지치기
		    		backtracking(cnt+1, leftSum, rightSum + weight);
		    	}
		    	
		    	visited[i] = false;
	    	}
	    }
	}
}
