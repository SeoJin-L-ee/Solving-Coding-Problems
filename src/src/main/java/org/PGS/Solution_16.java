package org.PGS;

import java.util.*;

// 주차 요금 계산
class Solution_16 {
    public Object[] solution(int[] fees, String[] records) {
        Map<String, String> in = new HashMap<>();
        Map<String, Integer> totalFee = new HashMap<>();

        for (String record : records) {
            String[] splited = record.split(" ");
            String time = splited[0], carNum = splited[1];

            if (splited[2].equals("IN")) {
                in.put(carNum, time);
            } else {
                int term = calcTerm(in.remove(carNum), time);
                totalFee.put(carNum, totalFee.getOrDefault(carNum, 0) + term);
            }
        }
        // 출차 내역 없었으면 23:59에 출차한 걸로 침
        in.forEach((carNum, time) -> {
            int term = calcTerm(time, "23:59");
            totalFee.put(carNum, totalFee.getOrDefault(carNum, 0) + term);
        });
        // 요금 계산
        return totalFee.keySet().stream()
                .sorted()
                .map(carNum -> {
                    int t = totalFee.get(carNum);
                    return t<=fees[0] ? fees[1] : fees[1] + Math.ceil((double)(t-fees[0])/fees[2]) * fees[3];
                }).toArray();
    }

    // 시간차 계산
    static int calcTerm(String a, String b) {
        String[] tempA = a.split(":");
        String[] tempB = b.split(":");
        return ((Integer.parseInt(tempB[0]) * 60) + Integer.parseInt(tempB[1]))
                - ((Integer.parseInt(tempA[0]) * 60) + Integer.parseInt(tempA[1]));
    }
}