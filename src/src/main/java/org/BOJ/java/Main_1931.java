package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1931{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxCnt = 0; int now = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] >= now) maxCnt++; now = cur[1];
        }
        System.out.println(maxCnt);
    }
}
