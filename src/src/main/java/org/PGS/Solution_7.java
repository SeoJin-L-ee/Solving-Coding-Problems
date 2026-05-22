package org.PGS;

import java.util.ArrayList;

// 프로그래머스 - 등대
class Solution_7 {
    // [temp][0] -> temp 번째 등대를 껐을 때, temp를 포함한 자식 전부를 모두 밝히는 최소 등대 수
    int[][] memo;
    ArrayList<Integer>[] edge;

    public int solution(int n, int[][] lighthouse) {
        // 초기화 부분
        int answer = 0;
        memo = new int[n+1][2];
        edge = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }
        // 인접리스트에 간선정보 추가
        for (int i = 0; i < lighthouse.length; i++) {
            edge[lighthouse[i][0]].add(lighthouse[i][1]);
            edge[lighthouse[i][1]].add(lighthouse[i][0]);
        }
        dfs(1, 0);
        // 1번 등대 불 껐을 때와 켰을 때 중, 더 덜 켜는 경우 반환
        return Math.min(memo[1][0], memo[1][1]);
    }

    void dfs(int cur, int par) {
        // cur 등대 껐을 때와 켰을 때 기본값 초기화
        memo[cur][0] = 0;
        memo[cur][1] = 1;

        for (int child : edge[cur]) {
            // 일단 자식 노드 타고 쭉 내려가기만 하기
            if (child == par) continue;
            dfs(child, cur);

            // 여기서부턴 자식 노드가 없어서(리프라서) 기본값만 설정한 이후에 올라오고 있는 상황
            // cur를 껐을 때 자식을 모두 밝히는 최소 등대 수 (자식은 꼭 켜야 함)
            memo[cur][0] += memo[child][1];
            // cur를 켰을 때
            memo[cur][1] += Math.min(memo[child][0], memo[child][1]);
        }
    }
}
