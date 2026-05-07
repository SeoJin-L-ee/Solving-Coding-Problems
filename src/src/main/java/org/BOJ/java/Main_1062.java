package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062 {
	static int N, K;
	static int answerCnt = 0;
	static int[] bitList;
	static int NEED = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bitList = new int[N];
		
		// 예외처리 (필수 알파벳은 꼭 알아야 함)
		if (K < 5) {
		    System.out.println(0);
		    return;
		}
		// 필수 알파벳 비트 미리 켜 놓기
		char[] needList = new char[] {'a', 'n', 't', 'i', 'c'};
		for (char need : needList) {
			NEED |= 1<<(need - 'a');
		}
		// 각 단어에 들어간 알파벳을 비트로 변환
		for (int i = 0; i < N; i++) {
			int tempBit = 0;
			String word = br.readLine().trim();
			for (int j = 0; j < word.length(); j++) {
				// 단어들의 각 글자에 대해서, 비트변수 |= 현재 글자를 비트로 표현
				tempBit |= 1 << (word.charAt(j) - 'a');
			}
			// 비트변수를 리스트에 추가
			bitList[i] = tempBit;
		}
		// 조합 생성 및 각 조합으로 읽을 수 있는 단어 수 세기
		combi(0, 0, NEED);
		System.out.println(answerCnt);
	}

	static void combi(int depth, int start, int currCombi) {
		// 조합 완성 시, 해당 조합으로 읽을 수 있는 단어 세기
		if (depth == K-5) {
			int tempCnt = 0;
			for (int bit : bitList) {
				// & 연산 수행했을 때 기존 비트변수와 동일하면 tempCnt++
				if ((bit & currCombi) == bit) tempCnt++;
			}
			answerCnt = Math.max(answerCnt, tempCnt);
			return;
		}
		for (int i = start; i < 26; i++) {
			// 필수 글자는 이미 넣어 놨으니 스킵
			if ((NEED & 1<<i) != 0) continue;
			// 현재 알파벳 비트를 조합비트에 추가
			combi(depth+1, i+1, currCombi | 1<<i);
		}
	}
}
