package org.PGS;

import java.util.Arrays;

// 프로그래머스 - 구명보트
class Solution_3 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int curWeight = 0;
        Arrays.sort(people);

        // 구명보트 최대한 적게 사용하려면 최대한 남는 공간 없이 꽉꽉 채워서 보내야함.
        // 투포인터 느낌으로, 무거운 사람에 가벼운 사람 끼워팔기
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[right] + people[left] <= limit) {
                // 현재 가장 무거운 사람과 가벼운 사람이 한번에 탈 수 있으면, 가벼운 사람도 태우기
                left++;
            }
            // 무거운 사람 태우고 배 보내기
            right--;
            answer++;
        }
        return answer;
    }
}
