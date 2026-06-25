package org.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3546 {
    static int R, C;
    static boolean[][] walls;
    static boolean[][] boxes;
    static boolean[][] goals;
    static int[] player;
    static char[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        walls = new boolean[R][C]; // 벽 위치는 변하지 않음
        boxes = new boolean[R][C];
        goals = new boolean[R][C]; // 목표 위치도 변하지 않음
        answer = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char cur = line.charAt(j);
                if (cur == '#') walls[i][j] = true;
                if (cur == 'b' || cur == 'B') boxes[i][j] = true;
                if (cur == 'w' || cur == 'W') player = new int[] {i, j};
                if (cur == '+' || cur == 'B' || cur == 'W') goals[i][j] = true;
            }
        }
        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            char cur = line.charAt(i);
            int r = player[0]; int c = player[1];

            if (cur == 'U') move(r-1, c, r-2, c);
            else if (cur == 'D') move(r+1, c, r+2, c);
            else if (cur == 'L') move(r, c-1, r, c-2);
            else if (cur == 'R') move(r, c+1, r, c+2);

            if (isComplete()) {
                System.out.println("complete");
                print();
                System.exit(0);
            }
        }
        System.out.println("incomplete");
        print();
    }

    static void move(int a, int b, int c, int d) {
        // a, b 위치가 벽이면
        if (walls[a][b]) return;
        if (boxes[a][b]) {
            if (walls[c][d] || boxes[c][d]) return;
            // 이동할 위치가 박스인데, 그 다음 위치가 박스나 벽이 아니면 (박스 밀고 이동할 수 있으면)
            boxes[a][b] = false;
            boxes[c][d] = true;
        }
        player[0] = a; player[1] = b;
    }

    // 박스가 전부 목표 위치에 들어가 있는지
    static boolean isComplete() {
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (goals[i][j] && !boxes[i][j]) return false;
        return true;
    }

    // 하나의 맵 정보로 합쳐서 출력
    static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (walls[i][j]) answer[i][j] = '#';
                else if (boxes[i][j] && goals[i][j]) answer[i][j] = 'B';
                else if (boxes[i][j]) answer[i][j] = 'b';
                else if (player[0] == i && player[1] == j && goals[i][j]) answer[i][j] = 'W';
                else if (player[0] == i && player[1] == j) answer[i][j] = 'w';
                else if (goals[i][j]) answer[i][j] = '+';
                else answer[i][j] = '.';
            }
            System.out.println(answer[i]);
        }
    }
}
