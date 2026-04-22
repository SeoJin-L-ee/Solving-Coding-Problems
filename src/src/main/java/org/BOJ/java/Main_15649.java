package org.BOJ.java;

import java.util.Scanner;

public class Main_15649 {
	private static int[] input = new int[9]; // 1부터 N까지의 수
	private static int[] selected = new int[9]; // 선택된 순서조합
	private static boolean[] visited = new boolean[9]; // 선택 여부를 나타내는 boolean 배열
	private static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 전체 원소 수
		M = sc.nextInt(); // 뽑을 숫자의 수
		
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		permutation(0);
	}
	
	private static void permutation(int depth) {
		if (depth == M) {
			for (int j = 0; j < M; j++) {
				System.out.print(selected[j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = input[i];
				permutation(depth+1);
				visited[i] = false;
			}
		}
	}
}
