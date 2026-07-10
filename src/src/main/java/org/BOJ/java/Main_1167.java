package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1167 {
    static ArrayList<int[]>[] tree;
    static boolean[] visited;
    static int maxDist = 0; static int deepNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];
        for (int i = 1; i < V+1; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            while (true) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                tree[cur].add(new int[] {temp, dist});
            }
        }
        bfs(1, V);
        maxDist = 0;
        bfs(deepNode, V);

        System.out.println(maxDist);
    }

    static void bfs(int start, int V) {
        visited = new boolean[V + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curDist > maxDist) {
                maxDist = curDist;
                deepNode = curNode;
            }
            for (int[] next : tree[curNode]) {
                int nextNode = next[0];
                int nextDist = next[1];

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(new int[] {nextNode, curDist+nextDist});
                }
            }
        }
    }
}
