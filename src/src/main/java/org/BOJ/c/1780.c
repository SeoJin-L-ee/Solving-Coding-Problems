#include <stdio.h>
#include <string.h>

//전체 종이 속 수가 저장될 arr
//같은 수로 이루어진 종이들의 각 개수가 저장될 sum
int arr[2188][2188];
int sum[3] = {0,};

void paper(int size, int i, int j){

    //현재 종이에서 각 수들을 대조하기 위한 비교대상
    int comp = arr[i][j];

    //현재 종이 속 수들을 하나하나 comp와 비교하여, 하나라도 다르면 현재 종이를 9등분하여 paper 재귀실행
    for(int k = i; k<i+size; k++){
        for(int m = j; m<j+size; m++){
            if(comp != arr[k][m]){

                paper(size/3, i, j);
                paper(size/3, i, j + size/3);
                paper(size/3, i, j + 2*(size/3));
                paper(size/3, i + size/3, j);
                paper(size/3, i + size/3, j + size/3);
                paper(size/3, i + size/3, j + 2*(size/3));
                paper(size/3, i + 2*(size/3), j);
                paper(size/3, i + 2*(size/3), j + size/3);
                paper(size/3, i + 2*(size/3), j + 2*(size/3));
                return;

            }
        }
    }

    //이중 for문을 통과하였으므로, 현재 종이 속 모든 수는 같음.
    sum[comp+1]++;

}

int main(){

    //입력받을 줄 수를 나타내는 N값 받아오기
    int N;
    scanf("%d", &N);

    //2차원 배열에 값 저장
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            scanf("%d", &arr[i][j]);
        }
    }

    //전체 크기의 종이에 대해서 함수 호출
    paper(N, 0, 0);

    //같은 수로 이루어진 종이들의 각 개수 출력
    for(int i=0; i<3; i++){printf("%d\n", sum[i]);}

    return 0;
}