#include <stdio.h>

int main(){
    //총 배달해야 할 설탕 kg수
    int totbag;
    //남은 설탕량이 5kg 미만일 때까지 5kg 봉지에 나누어 담은 후, 남은 kg수가 0 또는 3일 때의 bag 수
    int bagnum = 0;
    //위의 경우를 제외하고, 5kg 봉지 n개와 3kg봉지 '여러개'로 담은 경우의 bag 수
    //최대량인 5000kg일 때 모두 3kg로 나누어 담아도 총 봉지 수가 1800을 넘지 않음. -1출력을 제외한 그 어떤 경우에도 봉지 수는 1800이상일 수 없음
    int bestnum = 1800;

    //(bestnum으로 봤을 떄 3kg 봉지를 여러개 써야하는 경우, bagnum으로 계산하면 
    //11과 같이 5kg이 1개, 3kg이 2개로 이루어진 수는 만들 수 없다고 판단할 것임)


    scanf("%d", &totbag);


    while(1){

        //(현재까지 남아 있 는 설탕이 3으로 나누어지는가) && (bestnum을 갱신가능한가) 판단 후 bestnum 갱신 
        if(((totbag%3) == 0) && (bestnum > (bagnum + totbag/3))){
            bestnum = bagnum + totbag/3;
        }

        //5, 3과 남은 총 설탕량 비교 후 bagnum 갱신
        if(totbag >= 5){

            totbag -= 5;
            bagnum++;
        }
        else if(totbag >= 3){

            totbag -= 3;
            bagnum++;
        }
        else{

            //두번째 if문에서 5를 뺐더니 남은 수가 3보다 작으면, 5를 빼기 전 저장해둔 bestnum 출력
            if(totbag != 0){

                // (bestnum < 1800) -> bestnum이 갱신된 적 있으면
                if(bestnum < 1800){printf("%d", bestnum);}
                else{printf("-1");}

            }
            //무난한 case대로 잘 끝날 경우
            else{printf("%d", bagnum);}

            break;
        }
    }

    return 0;
}