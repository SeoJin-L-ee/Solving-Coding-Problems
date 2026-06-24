package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                // 걷거나 순간이동 위치
                int[] nexts = new int[] {cur-1, cur+1, cur*2};
                for (int n : nexts) {
                    // 최단시간
                    if (n == K) {
                        System.out.println(answer);
                        return;
                    }
                    if (n >= 0 && n <= 100000 && !visited[n]) {
                        visited[n] = true;
                        q.offer(n);
                    }
                }
            }
        }
    }
}
