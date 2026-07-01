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
            st = new StringTokenizer(br.read
}
