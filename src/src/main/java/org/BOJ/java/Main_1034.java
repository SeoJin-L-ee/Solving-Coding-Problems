package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1034 {
    public static void main(String[] S) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int max = 0;
        String[] rows = new String[N];
        for (int i = 0; i < N; i++) rows[i] = br.readLine();
        int K = Integer.parseInt(br.readLine());

        for (String r : rows) {
            // 현재 행에 0(꺼진 거) 개수 카운트
            int zeroCnt = 0;
            for (int i = 0; i < M; i++) {
                if (r.charAt(i) == '0') zeroCnt++;
            }
            // K번 처리했을 때 전부 켤 수 있는 행이면
            if (zeroCnt <= K && (K-zeroCnt)%2 == 0) {
                int same = 0;
                for (int i = 0; i < N; i++) {
                    if (r.equals(rows[i])) same++;
                }
                max = Math.max(max, same);
            }
        }
        System.out.println(max);
    }
}