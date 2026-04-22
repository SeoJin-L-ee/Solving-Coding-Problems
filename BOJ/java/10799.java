package com.ureca.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class 10799 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		int pieceCnt = 0;
		String line = in.readLine();
		
		// 읽어온 String 길이만큼 반복
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '(') {
				// i번째 괄호가 여는 괄호면
				// 스택에 저장
				stack.push('(');
			} else if (line.charAt(i) == ')') {
				// i번째 괄호가 닫는 괄호면
				// 현재 스택에서 pop 한번 수행 후, 이전 괄호 종류에 따라 pieceCnt 증가
				stack.pop();
				if(line.charAt(i - 1) == '(') {
					pieceCnt += stack.size();
				} else {
					pieceCnt++;
				}
			}
		}
		System.out.println(pieceCnt);
	}
}
