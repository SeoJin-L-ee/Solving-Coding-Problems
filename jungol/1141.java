package com.ureca.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class 1141 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
        int n = Integer.parseInt(line.trim());
        
        Stack<Integer> stack = new Stack<>();
        long visibleCnt = 0;

        for (int i = 0; i < n; i++) {
        	String input = in.readLine();
            if (input == null) break;
            int currHeight = Integer.parseInt(input.trim());

            // 현재 소한테 가려지는 소들은 제거
            while (!stack.isEmpty() && stack.peek() <= currHeight) {
                stack.pop();
            }
            // 스택에 남은 소들은 현재 소를 볼 수 있음
            visibleCnt += stack.size();
            stack.push(currHeight);
        }
        System.out.println(visibleCnt);
	}
}
