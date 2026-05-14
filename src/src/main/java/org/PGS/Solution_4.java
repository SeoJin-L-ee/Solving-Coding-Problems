package org.PGS;

import java.util.Stack;

// 프로그래머스 - 올바른 괄호
class Solution_4 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                // 여는 괄호는 스택에 푸시
                st.push(cur);
            } else if (cur == ')'){
                // 닫는 괄호를 만난 경우
                if (!st.isEmpty()) {
                    if (st.peek() == '(') {
                        // 스택이 비어 있지 않으면서, 가장 위 값이 여는 괄호면
                        // 짝지어졌으므로 팝
                        st.pop();
                        continue;
                    }
                }
                // 정상적으로 짝지어지지 않은 모든 경우에 대해 false 처리
                answer = false;
                break;
            }
        }
        // 각 문자에 대해 전부 처리했는데 스택이 비지 않았으면, 전부 짝지어지진 않은 것
        if (!st.isEmpty()) answer = false;
        return answer;
    }
}
