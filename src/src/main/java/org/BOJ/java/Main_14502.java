package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        ArrayList<int[]> zeros = new ArrayList<>();
        ArrayList<int[]> virus = new ArrayList<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 빈칸 위치랑 바이러스 위치 각각 기록
                if (map[i][j] == 0) zeros.add(new int[] {i, j});
                else if (map[i][j] == 2) virus.add(new int[] {i, j});
            }
        }
        for (int i = 0; i < zeros.size()-2; i++) {
            for (int j = i+1; j < zeros.size()-1; j++) {
                for (int k = j+1; k < zeros.size(); k++) {
                    int[][] copy = new int[N][M];
                    for (int a = 0; a < N; a++) copy[a] = map[a].clone();

                    // 현재 빈칸 3개에 벽 설치
                    copy[zeros.get(i)[0]][zeros.get(i)[1]] = 1;
                    copy[zeros.get(j)[0]][zeros.get(j)[1]] = 1;
                    copy[zeros.get(k)[0]][zeros.get(k)[1]] = 1;

                    Queue<int[]> q = new LinkedList<>();
                    for (int[] v : virus) q.add(v);

                    // bfs
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int a = 0; a < 4; a++) {
                            int nr = cur[0] + dr[a];
                            int nc = cur[1] + dc[a];
                            if (nr > -1 && nr < N && nc > -1 && nc < M) {
                                if (copy[nr][nc] == 0) {
                                    copy[nr][nc] = 2;
                                    q.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                    // 안전영역 크기 계산 및 정답 갱신
                    int safe = 0;
                    for (int[] rows : copy) {
                        for (int a : rows) {
                            if (a == 0) safe++;
                        }
                    }
                    answer = Math.max(answer, safe);
                }
            }
        }
        System.out.println(answer);
    }
}
