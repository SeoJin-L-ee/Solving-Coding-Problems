package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        // bfs 로 노드마다 depth 정보랑 부모 정보 채우기
        int[] depth = new int[N+1];
        int[] parents = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int child : tree[cur]) {
                if (!visited[child]) {
                    visited[child] = true;
                    parents[child] = cur;
                    depth[child] = depth[cur] + 1;
                    q.offer(child);
                }
            }
        }
        // 입력 받아와서 LCA 계산
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while (depth[a] > depth[b]) a = parents[a];
            while (depth[a] < depth[b]) b = parents[b];
            // a랑 b의 depth 가 맞춰진 후, a랑 b가 다르면 동시에 거슬러 올라가기
            while (a != b) {
                a = parents[a];
                b = parents[b];
            }
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}
