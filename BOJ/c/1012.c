#include <stdio.h>

int farm[50][50] = {0,};
int M, N;

void search(int x, int y){
    farm[x][y] = 0;

    if(x+1<M && farm[x+1][y] == 1){search(x+1, y);}
    if(y+1<N && farm[x][y+1] == 1){search(x, y+1);}
    if(x-1 >= 0 && farm[x-1][y] == 1){search(x-1, y);}
    if(y-1 >= 0 && farm[x][y-1] == 1){search(x, y-1);}

}

int main(){

    int warm_num;
    int repeat, K;
    scanf("%d", &repeat);

    for(int i=0; i<repeat; i++){

        warm_num = 0;
        scanf("%d %d %d", &M, &N, &K);

        for(int i=0; i<K; i++){
            int i,j;
            scanf("%d %d", &i, &j);
            farm[i][j] = 1;
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(farm[i][j] == 1){
                    search(i, j);
                    warm_num++;
                }
            }
        }

        printf("%d\n", warm_num);

    }
    return 0;
}