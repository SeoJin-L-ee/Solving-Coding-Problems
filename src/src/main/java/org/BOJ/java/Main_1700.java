package org.BOJ.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1700 {
    static int N, K;
    static int[] seq;
    static int[] plugged;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stto = new StringTokenizer(br.readLine());

        int answer = 0;
        N = Integer.parseInt(stto.nextToken());
        K = Integer.parseInt(stto.nextToken());
        seq = new int[K];
        plugged = new int[N];
        stto = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) seq[i] = Integer.parseInt(stto.nextToken());

        int pluggedCnt = 0;
        for (int i = 0; i < K; i++) {
            if (inTab(seq[i])) continue;
            if (pluggedCnt < N) {
                plugged[pluggedCnt++] = seq[i];
                continue;
            }
            // 여기서부턴 콘센트 꽉 찼을때
            int maxNextCnt = -2;
            int maxPluggedIdx = 0;

            for (int a = 0; a < N; a++) {
                int idx = whenNext(plugged[a], i);
                if (idx == -1) {
                    maxPluggedIdx = a;
                    break;
                } else if (idx > maxNextCnt) {
                    maxNextCnt = idx;
                    maxPluggedIdx = a;
                }
            }
            plugged[maxPluggedIdx] = seq[i];
            answer++;
        }
        System.out.println(answer);
    }

    // num 제품이 멀티탭에 꽂혀있나
    static boolean inTab(int num) {
        for (int temp : plugged) {
            if (temp == num) return true;
        }
        return false;
    }

    // 현재 꽂혀있는 num 제품의 다음 사용예정이 언제인지 인덱스 반환 (다시 안쓰이면 -1)
    static int whenNext(int num, int from) {
        for (int j = from+1; j < K; j++) {
            if (seq[j] == num) return j;
        }
        return -1;
    }
}
