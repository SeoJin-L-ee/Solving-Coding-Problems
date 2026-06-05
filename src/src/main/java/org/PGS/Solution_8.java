package org.PGS;

// 프로그래머스 - 금과 은 운반하기
class Solution_8 {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long st = 0;
        long ed = (long) (a+b)*100000*2;

        while (st+1 < ed) {
            long mid = (st+ed) / 2;
            // 가능하면 ed를 더 타이트하게 잡기
            if (canDeliver(mid, a, b, g, s, w, t)) ed = mid;
                // 불가능하면 st를 더 늘리기
            else st = mid;
        }
        return ed;
    }

    boolean canDeliver(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long tot = 0, totG = 0, totS = 0;
        for (int i = 0; i < g.length; i++) {

            long cnt = time / (t[i]*2);
            // 나머지시간으로 편도 가능하면 룃수++
            if (t[i] <= time % (t[i]*2)) cnt++;
            long maxKg = cnt * w[i];

            tot += Math.min(g[i] + s[i], maxKg);
            totG += Math.min(g[i], maxKg);
            totS += Math.min(s[i], maxKg);
        }
        return tot >= a+b && totG >= a && totS >= b;
    }
}
