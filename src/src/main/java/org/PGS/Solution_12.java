package org.PGS;

import java.util.*;

// 징검다리 건너기
class Solution_12 {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();

        // i-k번째 돌부터 i번째 돌까지의 윈도우의 최댓값을 젤 앞에 놓음
        for (int i = 0; i < stones.length; i++) {
            // 현재 윈도우에 속하지 않는, 이전 윈도우의 최댓값 돌 제거
            if (!dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();
            // 새로 들어올 돌에 비해 적은 수의 돌이 있으면 전부 제거
            while (!dq.isEmpty() && stones[dq.peekLast()] <= stones[i]) dq.pollLast();

            dq.offerLast(i);
            // 윈도우 처음 완성된 이후부터 매번 최솟값 갱신
            if (i >= k-1) answer = Math.min(answer, stones[dq.peekFirst()]);
        }
        return answer;
    }
}
