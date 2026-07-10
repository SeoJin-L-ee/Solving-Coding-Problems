package org.PGS;

// 표현 가능한 이진트리
class Solution_14 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long curNum = numbers[i];
            String binary = Long.toBinaryString(curNum);
            int binLen = binary.length();

            int fullLen = 1;
            while (fullLen < binLen) fullLen = fullLen*2 + 1;

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < fullLen-binLen; j++) sb.append('0');
            String fullBin = sb.append(binary).toString();

            boolean pos = true;
            for (int j = 1; j <= fullLen; j++) {
                // 루트는 부모 없음
                if (j == (fullLen+1) / 2) continue;

                if (fullBin.charAt(j-1) == '1') {
                    // 부모 값 구하기
                    int lowbit = j & (-j);
                    int parent = ((j / (lowbit*2)) % 2 == 0) ? j+lowbit : j-lowbit;

                    if (fullBin.charAt(parent-1) == '0') {
                        pos = false;
                        break;
                    }
                }
            }
            answer[i] = pos?1:0;
        }
        return answer;
    }
}
