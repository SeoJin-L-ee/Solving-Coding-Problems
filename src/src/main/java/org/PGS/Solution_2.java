package org.PGS;

import java.util.HashMap;

// 프로그래머스 - 의상
class Solution_2 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> category = new HashMap<>();

        // 해시맵에 값 추가 (옷 종류별로 분류)
        for (String[] cloth : clothes) {
            if (category.get(cloth[1]) != null) {
                // 해당 카테고리의 옷이 추가된 적 있으면, 카운트++
                int temp = category.get(cloth[1]);
                category.put(cloth[1], temp+1);
            } else {
                // 추가된 적 없으면, 카운트=1로 set
                category.put(cloth[1], 1);
            }
        }
        for (String key : category.keySet()){
            // (해당 종류 옷을 입는 경우(개수 카운트만큼) + 아무것도 안 입는 경우(1)) 만큼 정답 곱해주기
            answer *= category.get(key) + 1;
        }
        // 최소 한 개의 의상은 입는다니깐, 아무것도 안 입는 상황은 제외하고 출력
        return answer-1;
    }
}
