package com.ureca.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 5215 {
	static int N, L; // 재료의 수, 제한 칼로리
    static int[] scores; // 맛 점수 배열
    static int[] calories; // 칼로리 배열
    static int maxScore; // 최종 결과값

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T =Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
        	String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken().trim());
            L = Integer.parseInt(st.nextToken().trim());
            scores = new int[N];
            calories = new int[N];
            maxScore = 0;

            for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				scores[i] = Integer.parseInt(st.nextToken().trim());
				calories[i]=Integer.parseInt(st.nextToken().trim());
            }
            subset(0, 0, 0);
            System.out.println("#" + t + " " + maxScore);
        }
    }

    static void subset(int cnt, int currScore, int currCalorie) {
    	// 제한칼로리를 넘으면 종료
        if (currCalorie > L) {
            return;
        }
        if (cnt == N) {
            if (currScore > maxScore) {
                maxScore = currScore;
            }
            return;
        }
        // 현재 재료 선택하기 (점수와 칼로리에 현재값을 더해서 subset 호출)
        subset(cnt + 1, currScore + scores[cnt], currCalorie + calories[cnt]);
        // 현재 재료 선택하지 않기 (현재 점수와 현재 칼로리 그대로 subset 호출)
        subset(cnt + 1, currScore, currCalorie);
    }
}
