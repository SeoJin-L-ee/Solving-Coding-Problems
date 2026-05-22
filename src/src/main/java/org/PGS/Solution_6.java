package org.PGS;

// 프로그래머스 - 도둑질
class Solution_6 {
    public int solution(int[] money) {
        int answer = 0;
        int[] memo = new int[money.length];

        // 첫 번째 집을 털기로 했을 때
        memo[0] = money[0];
        memo[1] = money[0];
        for (int i = 2; i < money.length - 1; i++) {
            memo[i] = Math.max(memo[i-1], memo[i-2] + money[i]);
        }
        int tempMax = memo[money.length - 2];

        // 두 번째 집을 털기로 했을 때
        memo = new int[money.length];
        memo[0] = 0;
        memo[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            memo[i] = Math.max(memo[i-1], memo[i-2] + money[i]);
        }
        answer = Math.max(tempMax, memo[money.length - 1]);
        return answer;
    }
}
