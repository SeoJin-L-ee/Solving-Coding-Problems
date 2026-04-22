#include <stdio.h>

// 전역 변수 선언
int B, check = 0;

// 재귀 함수 정의
void recursion(int num, int count) {
    // 목표 값인 B에 도달했을 때
    if (num == B) {
        printf("%d", count + 1); // 결과 출력
        check = 1; // 체크 플래그 설정
    }

    // num을 2배로 만들어 재귀 호출 (조건: num이 500,000,000 이하)
    if (num <= 500000000) {
        recursion(num * 2, count + 1);
    }

    // num 뒤에 1을 추가하고 10배로 만들어 재귀 호출 (조건: num이 100,000,000 이하)
    if (num <= 100000000) {
        recursion(num * 10 + 1, count + 1);
    }
}

// 메인 함수
int main() {
    int A;

    // 입력 받기
    scanf("%d %d", &A, &B);

    // 재귀 함수 호출
    recursion(A, 0);

    // 목표 값에 도달하지 못한 경우 -1 출력
    if (!check) {
        printf("-1");
    }

    return 0;
}
