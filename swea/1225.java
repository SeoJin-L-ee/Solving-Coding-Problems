package com.ureca.solved;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class 1225 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int decreaseNum;
		
		for (int i = 0; i < 10; i++) {
			decreaseNum = 1;
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			int testNum = sc.nextInt();
			
			// 큐에 8개 값 넣기
			for (int j = 0; j < 8; j++) {
				dq.addLast(sc.nextInt());
			}
			while (true) {
				int currNum = dq.poll();
				// 큐의 맨 앞 숫자 - 감소숫자 계산
				if ((currNum - decreaseNum) <= 0) {
					// 0보다 작거나 같으면 큐 맨 뒤에 0 넣고 종료
					dq.addLast(0);
					break;
				}
				dq.addLast(currNum - decreaseNum);
				// 감소숫자를 1~5 순환시킴
				decreaseNum++;
				if (decreaseNum >= 6) {
					decreaseNum = 1;
				}
			}
			// 결과 출력
			System.out.print("#" + testNum + " ");
			while (!dq.isEmpty()) {
				System.out.print(dq.poll() + " ");
			}
			System.out.println();
		}
	}
}
