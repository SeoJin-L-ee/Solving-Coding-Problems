#include<stdio.h>

// 좌표를 나타내는 구조체 정의
struct node {
    int x, y;
};

// 큐와 토마토 상태, 경과 일수를 저장할 배열 선언
struct node queue[1000005];
int tomato[1005][1005] = {0, }, day[1005][1005] = {0, }, var[2][4] = {{1, -1, 0, 0}, {0, 0, 1, -1}};
int M, N, count = 0, front = 0, rear = 1;

// BFS 함수 정의
int BFS() {
    int popX, popY;

    // 큐가 비어있을 때까지 반복
    while (++front < rear) {
        for (int i = 0; i < 4; i++) {
            // 상하좌우 이동
            popX = queue[front].x + var[0][i];
            popY = queue[front].y + var[1][i];

            // 이동한 위치가 유효하고 익지 않은 토마토인 경우
            if (popX >= 1 && popX <= M && popY >= 1 && popY <= N && tomato[popY][popX] == 0) {
                // 토마토를 익은 상태로 변경
                tomato[popY][popX] = 1;

                // 경과 일수를 갱신
                day[popY][popX] = day[queue[front].y][queue[front].x] + 1;

                // 큐에 새로운 위치 추가
                queue[rear].x = popX;
                queue[rear++].y = popY;

                // 남은 익지 않은 토마토의 개수 감소
                count--;
            }
        }
    }

    // 모든 토마토가 익은 경우 경과 일수 반환, 그렇지 않은 경우 -1 반환
    if (!count) {
        return day[queue[rear - 1].y][queue[rear - 1].x];
    } else {
        return -1;
    }
}

// 메인 함수
int main() {
    // 가로, 세로 크기 입력
    scanf("%d %d", &M, &N);

    // 토마토 상태 입력 및 초기화
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            scanf("%d", &tomato[i][j]);

            // 익은 토마토의 위치를 큐에 추가
            if (tomato[i][j] == 1) {
                queue[rear].x = j;
                queue[rear++].y = i;
            }
            // 익지 않은 토마토 개수 세기
            else if (tomato[i][j] == 0) {
                count++;
            }
        }
    }

    // BFS 함수 호출 및 결과 출력
    printf("%d", BFS());

    return 0;
}
