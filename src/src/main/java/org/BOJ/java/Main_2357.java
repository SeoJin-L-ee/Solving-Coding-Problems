package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] minTree = new int[2 * N];
        int[] maxTree = new int[2 * N];

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            minTree[N+i] = temp;
            maxTree[N+i] = temp;
        }
        for (int i = N-1; i >= 1; i--) {
            minTree[i] = Math.min(minTree[2*i], minTree[2*i+1]);
            maxTree[i] = Math.max(maxTree[2*i], maxTree[2*i+1]);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1 + N;
            int b = Integer.parseInt(st.nextToken())-1 + N;
            int min = Integer.MAX_VALUE;
            int max = 0;

            while (a <= b) {
                if (a%2 == 1) {
                    min = Math.min(min, minTree[a]);
                    max = Math.max(max, maxTree[a]);
                    a++;
                }
                if (b%2 == 0) {
                    min = Math.min(min, minTree[b]);
                    max = Math.max(max, maxTree[b]);
                    b--;
                }
                a /= 2;
                b /= 2;
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
