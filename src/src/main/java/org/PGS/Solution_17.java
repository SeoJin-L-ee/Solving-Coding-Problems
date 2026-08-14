package org.PGS;

import java.util.*;

// 단속카메라
class Solution_17 {
    public int solution(int[][] routes) {
        int cnt = 0;
        int last = -30001;

        Arrays.sort(routes, (a, b) -> a[1]-b[1]);
        for (int[] route : routes) {
            if (route[0] > last) {
                cnt++;
                last = route[1];
            }
        }
        return cnt;
    }
}