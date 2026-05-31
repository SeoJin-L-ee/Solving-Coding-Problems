package org.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int N;
        int[] scores;
        boolean[] isPossible;
        int answer;
        
        for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			scores = new int[N];
        	isPossible = new boolean[N*100];
        	isPossible[0] = true; // 0점 만드는 건 항상 가능 (초깃값)
        	answer = 0;
        		
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
        		scores[i] = Integer.parseInt(st.nextToken());
        	}
        	int curNum, curMax = 0;
        	for (int i = 0; i < N; i++) {
        		curNum = scores[i];
        		curMax += curNum;
        		for (int j = curMax; j >= curNum; j--) {
        			// 이전 단계에서 j-curNum라는 수를 만들 수 있었으면, 이번 단계에서는 j를 만들 수 있음
					if (isPossible[j-curNum]) isPossible[j] = true;
				}
			}
        	// 만들 수 있는 수가 몇 개인지 경우의 수를 체크
        	for (int i = 0; i < isPossible.length; i++) {
        		if (isPossible[i]) answer++;
			}
        	sb.append("#" + t + " " + answer).append("\n");
		}
        System.out.println(sb);
    }
}
