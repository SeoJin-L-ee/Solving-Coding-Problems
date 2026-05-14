package org.PGS;

// 프로그래머스 - 타겟 넘버
class Solution_5 {
    int[] numbers;
    int target;
    int answer;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        answer = 0;

        dfs(0, 0);
        return answer;
    }

    public void dfs(int depth, int curSum) {
        if (depth == numbers.length) {
            // 모든 숫자를 합해주었으면 타겟 넘버인지 확인
            if (curSum == target) answer++;
            return;
        }
        // 각 위치 숫자를 더하는/빼는 경우에 대해 재귀호출
        dfs(depth+1, curSum + numbers[depth]);
        dfs(depth+1, curSum - numbers[depth]);
    }
}
