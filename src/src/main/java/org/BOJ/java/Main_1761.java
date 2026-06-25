package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            tree[a].add(new int[] {b, d});
            tree[b].add(new int[] {a, d});
        }
        // 노드마다 depth 정보랑 부모 정보 채우기
        int[] depth = new int[N+1];
        int[] parents = new int[N+1];
        // 루트부터 해당 노드까지의 거리
        int[] dist = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] child : tree[cur]) {
                int c = child[0]; int d = child[1];
                if (!visited[c]) {
                    visited[c] = true;
                    parents[c] = cur;
                    depth[c] = depth[cur] + 1;
                    dist[c] = dist[cur] + d;
                    q.offer(c);
                }
            }
        }
        // 입력 받아와서 LCA 계산
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tempA = a; int tempB = b;

            while (depth[tempA] > depth[tempB]) tempA = parents[tempA];
            while (depth[tempA] < depth[tempB]) tempB = parents[tempB];
            // a랑 b의 depth 가 맞춰진 후, a랑 b가 다르면 동시에 거슬러 올라가기
            while (tempA != tempB) {
                tempA = parents[tempA];
                tempB = parents[tempB];
            }
            sb.append(dist[a]-dist[tempA] + dist[b]-dist[tempA]).append("\n");
        }
        System.out.println(sb);
    }
}