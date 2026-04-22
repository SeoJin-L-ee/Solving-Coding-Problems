#include <stdio.h>

// 전역 변수 선언
int N, M, next_x, next_y, max = 0;
int map[10][10] = {0}, map_copy[10][10] = {0}, move_dir[2][4] = {{1, -1, 0, 0}, {0, 0, 1, -1}};

// 좌표를 나타내는 구조체 선언
struct node {
    int x, y;
};

// BFS 함수 정의
void BFS() {
    // 큐를 이용한 BFS 알고리즘
    struct node queue[100];
    int front = 0, rear = 1, count = 0;

    // 지도를 복사하여 BFS 수행 (원본 지도 손상 방지)
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            map_copy[i][j] = map[i][j];
            if (map_copy[i][j] == 2) {
                queue[rear].x = j;
                queue[rear++].y = i;
            }
        }
    }

    // BFS 탐색
    while (++front < rear) {
        for (int i = 0; i < 4; i++) {
            next_x = queue[front].x + move_dir[0][i];
            next_y = queue[front].y + move_dir[1][i];

            // 범위 내에 있고 빈 공간이면 큐에 추가
            if (next_x >= 1 && next_x <= M && next_y >= 1 && next_y <= N && !map_copy[next_y][next_x]) {
                map_copy[next_y][next_x] = 2;
                queue[rear].x = next_x;
                queue[rear++].y = next_y;
            }
        }
    }

    // BFS 후의 상태를 기반으로 작업 수행 (예: 빈 공간 카운트)
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            if (!map_copy[i][j]) {
                count++;
            }
        }
    }

    // 최대값 갱신
    if (count > max) {
        max = count;
    }
}

// 벽 선택 함수 정의
void wall_select(int wall_count) {
    if (wall_count == 3) {
        // 벽을 3개 선택한 경우 BFS 호출
        BFS();
        return;
    }

    // 빈 공간에 벽을 세우고 재귀 호출
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            if (!map[i][j]) {
                map[i][j] = 1;
                wall_select(wall_count + 1);
                map[i][j] = 0; // 원복
            }
        }
    }
}

// 메인 함수
int main() {
    // 입력 받기
    scanf("%d %d", &N, &M);
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            scanf("%d", &map[i][j]);
        }
    }

    // 벽 선택 함수 호출
    wall_select(0);

    // 결과 출력
    printf("%d", max);

    return 0;
}
