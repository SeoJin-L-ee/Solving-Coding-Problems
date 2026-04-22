#include <stdio.h>
#include <stdlib.h>

int comparison(const void *a, const void *b);

//회의 시작시간과 끝나는 시간을 한번에 저장하는 구조체 선언
typedef struct{
    int x;
    int y;
} meeting;

int main(){

    //전체 회의의 수 N
    int N;
    scanf("%d", &N);

    //구조체를 저장할 수 있는 배열 선언
    meeting arr[100001];
    
    //회의 수만큼 시작/끝 시간을 입력받고, 각각 배열 속 구조체의 x,y값에 저장
    for(int i=0; i<N; i++){
        scanf("%d %d", &arr[i].x, &arr[i].y);
    }

    //입력이 정렬되어 있다는 조건이 없으므로, quick sort를 이용하여 정렬. (comparison함수 확인)
    qsort(arr, N, sizeof(meeting), comparison);

    //i: 가장 최근에 진행된(count된) 회의 / j: 비교하기 위해 1씩 증가하며 최대 N번째 구조체까지 확인할 수 있게 함
    //meet_cnt: 총 진행된 회의 개수
    int i = 0;
    int j = 1;
    int meet_cnt = 1;

    while(N > j){

        //마지막 진행된 회의의 종료시간보다 시작시간이 빠른 회의들은 skip하고, 같거나 이후인 회의가 있으면 count
        if(arr[i].y <= arr[j].x){
            i = j;
            meet_cnt++;
        }
        j++;
    }

    printf("%d\n", meet_cnt);

    return 0;    

}

//y에 대하여 오름차순으로 정렬하고, y가 같은 경우가 있다면 x에 대하여 정렬
int comparison(const void *a, const void *b)
{

    meeting A = *(meeting *)a;
    meeting B = *(meeting *)b;

    if(A.y > B.y){return 1;}
    else if(A.y == B.y){
        if(A.x > B.x){return 1;}
        else{return -1;}
    }
    else{return -1;}

}