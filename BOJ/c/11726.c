#include <stdio.h>

int main() {

    int n;
    int cnt = 0;
    int arr[1005];
    scanf("%d", &n);

    //세로길이가 1일 때와 2일 때는 점화식으로 계산할 수 없음
    arr[0] = 1;
    arr[1] = 2;

    //3부터는 아래의 for문을 사용하여 계산
    for(int i=2; i<n; i++){
        arr[i] = (arr[i-1] + arr[i-2])%10007;
    }

    printf("%d", arr[n-1]);

}