package org.PGS;

import java.util.*;

// N으로 표현
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());

        for (int i = 1; i <= 8; i++) {
            // 사칙연산을 통해 만들어낸 수들 넣기
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        if (b != 0) dp.get(i).add(a/b);
                    }
                }
            }
            // N을 i번만큼 이어붙인 하나의 수 넣기
            String temp = String.valueOf(N);
            for (int j = 1; j < i; j++) temp+=N;
            dp.get(i).add(Integer.parseInt(temp));

            if (dp.get(i).contains(number)) return i;
        }
        // 8번 안에 최솟값을 만들지 못 했으면
        return -1;
    }
}
