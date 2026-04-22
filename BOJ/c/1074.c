#include <stdio.h>

int N, r, c; // 총 행렬의 사이즈 값과, 순서 구할 칸의 행&열 값
int ans = 0; // 최종 방문 순서, 중간 위치

//i와 j는 중간 위치를 나타내는 행&열 좌표로써, 항상 현재 행렬에서의 4사분면 첫 값을 가리킴 / ans 값을 수정하기 위하여 포인터로 전달
void visit(int N, int i, int j, int *ans){

    //함수 호출하여 행렬의 크기 4등분 하기를 N번 했으면, 즉 현재 칸의 크기가 1칸이면 그냥 return
    if(N == 0){return;}

    //현재 탐색할 범위에 대한 '한변의 길이'와 '중간 위치' (함수 호출할 때마다 바뀌기에 var)
    int var_len = 1 << N;
    int var_mid = var_len/2;

    //찾고자 하는 값이 현재 행렬의 1사분면에 존재함
    if(i > r && j > c){
        visit(N-1, i - var_mid/2, j - var_mid/2, ans);
    }
    //값이 2사분면에 존재함
    else if(i > r && j <= c){
        *ans += var_mid*var_mid;
        visit(N-1, i - var_mid/2, j + var_mid/2, ans);
    }
    //값이 3사분면에 존재함
    else if(i <= r && j > c){
        *ans += 2*(var_mid*var_mid);
        visit(N-1, i + var_mid/2, j - var_mid/2, ans);
    }
    //값이 4사분면에 존재함
    else if(i <= r && j <= c){
        *ans += 3*(var_mid*var_mid);
        visit(N-1, i + var_mid/2, j + var_mid/2, ans);
    }
    return;
}

int main(){

    //입력받고, 받은 N으로 한변의 길이(1 << N) 구한 후 사분면 판단할 때 쓰일 첫 중간값인 mid 계산
    scanf("%d %d %d", &N, &r, &c);
    int first_mid = (1 << N)/2;

    //함수 호출 후 return된 특정 행&열의 방문 순서를 visit_num에 담아 printf
    visit(N, first_mid, first_mid, &ans);
    printf("%d\n", ans);

    return 0;

}


//정답처리 조건의 시간제한을 확인하지 않고 짠 코드. 시간초과로 오답처리 됨.

/* 
int order = 0; // 각 칸의 방문 순서
int found = 0; // 원하는 위치의 순서를 찾았는지 나타내는 변수

void visit(int size, int i, int j){

    if(found == 1){return;} //다른 재귀함수에서 원하는 결과값을 찾았을 경우 그냥 return

    //한 변의 길이가 2이상이면, 4등분 한 각 분면에 대하여 재귀호출
    if(size > 1){
        visit(size/2, i, j);
        visit(size/2, i, j + size/2);
        visit(size/2, i + size/2, j);
        visit(size/2, i + size/2, j + size/2);
        return;

    }
    //한 변의 길이가 1이면, 즉 한칸짜리 행렬이면 visit 순서매김
    else{
        if(i == r && j == c){
            found = 1;
            return;
        }else{
            //(현재 칸의 방문 순서 변수 order의 증가는, 직전에 방문된 칸에 대해 호출된 visit에서 증가됨)
            order++;
            return;
        }
    }

}

int main(){

    scanf("%d %d %d", &N, &r, &c);

    //한 변의 길이가 2^N인 행렬에 대하여 visit 함수 호출
    visit(1 << N, 0, 0);

    //r행 c열의 방문 순서인 result 출력
    printf("%d\n", order);
    return 0;
}
*/