package org.BOJ.java;

import java.util.Scanner;

public class Main_3040 {
	static int[] dwarfNums = new int[10];
	static int[] realDwarfNum = new int [10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			dwarfNums[i] = sc.nextInt();
		}
		combi(0, 0, 0);
	}
	
	static void combi(int depth, int start, int sum) {
		if (depth == 7) {
			// 고른 수의 합이 100인 경우에만 출력
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(realDwarfNum[i]);
				}
				// 합이 100인 경우 발견하면 그냥 exit
				System.exit(0);
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			realDwarfNum[depth] = dwarfNums[i];
			combi(depth+1, i+1, sum + dwarfNums[i]);
		}
	}
}
