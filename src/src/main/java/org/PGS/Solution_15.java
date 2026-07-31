package org.PGS;

import java.util.*;

// 기능개발
class Solution_15 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        int answerIdx = 0, cur = 0, tempCnt;

        while (cur < progresses.length) {
            tempCnt = 0;
            // 하루치 작업 진행
            for (int i = cur; i < progresses.length; i++) progresses[i] += speeds[i];
            // 배포 가능하면 배포
            while (cur < progresses.length && progresses[cur] >= 100) {
                cur++;
                tempCnt++;
            }
            if (tempCnt != 0) answer[answerIdx++] = tempCnt;
        }
        return Arrays.copyOf(answer, answerIdx);
    }
}
