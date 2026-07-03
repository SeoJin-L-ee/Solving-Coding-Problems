package org.PGS;

import java.util.*;

// 110 옮기기
class Solution_13 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            StringBuilder tempSb = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            String cur = s[i];
            int cnt = 0;

            for (char c : cur.toCharArray()) {
                stack.push(c);
                if (stack.size() >= 3) {
                    char c1 = stack.pop();
                    char c2 = stack.pop();
                    char c3 = stack.pop();
                    if (c1 == '0' && c2 == '1' && c3 == '1') {
                        cnt++;
                    } else {
                        stack.push(c3);
                        stack.push(c2);
                        stack.push(c1);
                    }
                }
            }
            int last = 0;
            for (char c : stack) {
                tempSb.append(c);
                if (c == '0') last = tempSb.length();
            }
            sb.append(tempSb, 0, last);
            for (int j = 0; j < cnt; j++) sb.append("110");
            sb.append(tempSb, last, tempSb.length());
            answer[i] = sb.toString();
        }
        return answer;
    }
}
