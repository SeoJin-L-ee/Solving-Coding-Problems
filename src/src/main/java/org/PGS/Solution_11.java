package org.PGS;

import java.util.*;

// 카운트 다운
class Solution_11 {
    public int[] solution(int target) {
        // dp[i][0] = i점 얻기 위해 던져야 하는 최소 다트 수, dp[i][1] = 그때의 싱글/불 수
        int[][] dp = new int[target+1][2];
        for (int i = 1; i <= target; i++) {
            dp[i][0] = 100001;
        }
        // 한번 던져서 얻을 수 있는 점수와 싱글/불 여부
        List<int[]> scores = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            scores.add(new int[]{i, 1}); // 싱글
            scores.add(new int[]{i * 2, 0}); // 더블
            scores.add(new int[]{i * 3, 0}); // 트리플
        }
        scores.add(new int[]{50, 1}); // 불

        for (int i = 1; i <= target; i++) {
            for (int[] score : scores) {
                if (i-score[0] >= 0) {
                    dp[i] = better(dp[i], new int[] {dp[i-score[0]][0]+1, dp[i-score[0]][1]+score[1]});
                }
            }
        }
        return new int[] {dp[target][0], dp[target][1]};
    }

    // 누가 이기는지
    public int[] better(int[] a, int[] b) {
        if (a[0] < b[0]) return a;
        if (a[0] > b[0]) return b;
        return a[1] > b[1] ? a : b;
    }
}
