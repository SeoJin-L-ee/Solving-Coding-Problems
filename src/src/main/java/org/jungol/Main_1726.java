package org.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] tree = new int[2*N];

        for (int i = 0; i < N; i++) tree[N+i] = Integer.parseInt(br.readLine());
        for (int i = N-1; i >= 1; i--) tree[i] = Math.max(tree[2*i], tree[2*i+1]);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1 + N;
            int b = Integer.parseInt(st.nextToken())-1 + N;
            int max = 0;

            while (a <= b) {
                // 왼쪽에서 오는 a는 짝수여야 묶일 수 있음
                if (a%2 == 1) max = Math.max(max, tree[a++]);
                // 오른쪽에서 오는 b는 홀수여야 묶일 수 있음
                if (b%2 == 0) max = Math.max(max, tree[b--]);
                // 안 묶이는 경우와 묶이는 경우 모두 부모 노드로 이동
                a /= 2;
                b /= 2;
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
