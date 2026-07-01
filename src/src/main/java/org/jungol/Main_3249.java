package org.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3249 {
    static boolean[][] answer;
    static char[] chars;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        answer = new boolean[N][N];
        chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) chars[i] = str.charAt(i);

        rec(0, 0, N);

        sb.append(N).append("\n");
        for (boolean[] temp : answer) {
            for (boolean temp2 : temp) sb.append(temp2 ? "1 " : "0 ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rec(int stR, int stC, int len) {
        char cur = chars[idx++];
        if (cur == '0') return;
        if (cur == '1') {
            for (int i = stR; i < stR + len; i++) {
                for (int j = stC; j < stC + len; j++) {
                    answer[i][j] = true;
                }
            }
            return;
        }
        if (cur == 'X') {
            rec(stR, stC, len/2);
            rec(stR, stC+len/2, len/2);
            rec(stR+len/2, stC, len/2);
            rec(stR+len/2, stC+len/2, len/2);
        }
    }
}
