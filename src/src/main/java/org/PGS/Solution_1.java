package org.PGS;

import java.util.Arrays;
import java.util.PriorityQueue;

// 프로그래머스 - 배달
class Solution_1 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] dists = new int[N+1][N+1];
        int[] minCost = new int[N+1];

        // 인접행렬 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dists[i], 500001);
        }
        for (int[] r : road) {
            // 두 마을 사이 도로가 여러 개일 수 있으므로, 최단 거리로 초기화
            if (dists[r[0]][r[1]] > r[2]) {
                dists[r[0]][r[1]] = r[2];
                dists[r[1]][r[0]] = r[2];
            }
        }
        // pq 초기화 및 초기값 설정
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[] {1, 0});
        Arrays.fill(minCost, 500001);
        minCost[1]= 0;

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int v = cur[0];
            int w = cur[1];

            if (w > minCost[v]) {
                // 큐에 있는 사이에 최단 시간이 갱신돼서 의미 없어졌으면
                continue;
            }
            for (int i = 1; i <= N; i++) {
                if (dists[v][i] != 500001) {
                    // 현재마을이랑 i번 마을이 연결되어 있고
                    if (minCost[i] > minCost[v] + dists[v][i]) {
                        // 현재까지의 1->i 최단 시간보다 현재 지점을 거쳐서 i번 마을에 가는 시간이 더 짧으면
                        minCost[i] = minCost[v] + dists[v][i];
                        pq.offer(new int[] {i, minCost[i]});
                    }
                }
            }
        }
        // 1번 마을에서 각 마을까지 걸리는 최단 시간이 K 이하인 마을 개수 카운트
        for (int time : minCost) {
            if (time <= K) answer++;
        }
        return answer;
    }
}
