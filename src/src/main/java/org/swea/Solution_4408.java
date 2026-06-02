package org.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int N;
        int[][] moveInfo;
        int[] hall;
        int answer;
        
        for (int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());
        	moveInfo = new int[N][2];
        	hall = new int[N];
        	answer = 0;
        	for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				moveInfo[i][0] = Integer.parseInt(st.nextToken());
				moveInfo[i][1] = Integer.parseInt(st.nextToken());
			}
	        // 학생들 동선 표시
        	for (int[] to : moveInfo) {
        		// 학생들이 이동한 구간의 복도만 카
        	}
        	// 가장 많이 겹친 복도 구간의 동선 수 카운트
        	for (int i = 0; i < N; i++) {
				if (hall[i] > answer) answer = hall[i];
			}
        	sb.append("#" + t + " " + answer).append("\n");
		}
        System.out.println(sb);
    }
}
