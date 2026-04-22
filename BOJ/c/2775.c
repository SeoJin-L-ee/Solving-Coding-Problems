#include <stdio.h>
#include <string.h>

int main() {

    int T, k, n, sum;

    scanf("%d", &T);

    for(int a=0; a<T; a++){

        int ho1[15] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int ho2[15] = {0,};

        scanf("%d", &k);
        scanf("%d", &n);

        //1층부터 k층까지의 호수들 계산
        for(int b=0; b<k; b++){
            //각 층의 1호부터 n호까지 계산
            for(int c=0; c<n; c++){
                //각 층의 c호는 그 아래층의 1호~c호 주민 수 합
                for(int d=0; d<=c; d++){
                   sum += ho1[d];
                }
                ho2[c] = sum;
                sum = 0;
            }
            memcpy(ho1, ho2, sizeof(int)*15);
        }
        printf("%d\n", ho2[n-1]);
    }

    return 0;

}