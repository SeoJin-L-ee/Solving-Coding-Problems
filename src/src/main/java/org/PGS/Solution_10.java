package org.PGS;

import java.util.*;

// 징검다리
public class Solution_10 {
    public int solution(int distance, int[] rocks, int n) {
        int l = 1;
        int r = distance;
        int answer = 0;

        Arrays.sort(rocks);

        while (l <= r) {
            int mid = (l + r) / 2;
            if (canAchieve(rocks, distance, n, mid)) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }

    // 최솟값이 mid 이상이 되려면 몇개 제거해야 하는지 확인
    private boolean canAchieve(int[] rocks, int distance, int n, int mid) {
        int remove = 0, prev = 0;
        for (int rock : rocks) {
            if (rock-prev < mid) {
                remove++;
                // 제거할 바위가 n개를 초과하면 바로 실패
                if (remove > n) return false;
            } else {
                prev = rock;
            }
        }
        // 마지막 바위와 도착점 사이의 거리 확인
        if (distance-prev < mid) remove++;
        return remove <= n;
    }
}
