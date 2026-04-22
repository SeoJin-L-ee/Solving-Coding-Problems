#include <stdio.h>

int main(){

    //N: 가지고 있는 동전의 종류, K: 만들고자 하는 가치
    int N, K;

    //총 필요할 동전 개수
    int coin = 0;

    //동전 종류를 저장할 배열
    int arr[10];

    scanf("%d %d", &N, &K);

    //현재 위치한 인덱스 저장하는 변수(가장 큰 가치의 동전부터 greedy하게)
    int poss = N-1;

    //배열에 동전 종류 삽입
    for(int i=0; i<N; i++){
        scanf("%d", &arr[i]);
    }

    while(K > 0){

        //현재 위치해있는 인덱스의 값이 K보다 작거나 같을 때까지 이동
        for(int i=poss; i>=0; i--){
            if(arr[i] <= K){break;}
            poss--;
        }

        //K값이 멈춘 인덱스 위치의 동전 가치보다 작아질 때까지, 그 값을 K에서 빼고 coin개수 ++
        while(arr[poss] <= K){
            coin++;
            K -= arr[poss];
        }
    }

    printf("%d", coin);

    return 0;
}