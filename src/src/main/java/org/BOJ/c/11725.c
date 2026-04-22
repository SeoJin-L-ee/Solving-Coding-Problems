//Not my code
#include <stdio.h>
#include <stdlib.h>

int brray[100001];

int Queue[100000] = { 1 };
int entrance = 1;

typedef struct node
{
	int data;
	struct node* next;
}Node;

Node* array[100001];// array에는 각 숫자의 마지막으로 연결된 정점의 주소를 저장
Node* Array[100001];

Node arr[100001];

void Find(int n)//찾아갈 숫자
{
	int i;
	Node* cur;

	cur = Array[n];

	while(cur->next != NULL)//cur->next == NULL인 순간 종료
	{
		cur = cur->next;
		if (brray[cur->data] == 0)//brray에 저장된게 없으면 처음 만난게 부모 노드
		{
			brray[cur->data] = n;//array[n][i]의 부모노드로 n을 추가
			Queue[entrance++] = cur->data;
		}
	}

	return;
}

int main()
{

	int i, j, N;
	int x, y;
	int count = 0;
	Node* cur;

	scanf("%d", &N);

	for (i = 1; i <= N; i++)//대입연산자 여러개 한줄에 써도 된다.
	{
		array[i] = Array[i] = arr + i;//arr + i를 하면 자동으로 arr[i]의 주소를 가져온다.
		Array[i]->next = NULL;
	}

	for (i = 0; i < N - 1; i++)
	{
		scanf("%d %d", &x, &y);

		cur = array[x];
		array[x] = cur->next = (Node*)malloc(sizeof(Node));
		cur->next->data = y;
		cur->next->next = NULL;

		
		cur = array[y];
		array[y] = cur->next = (Node*)malloc(sizeof(Node));
		cur->next->data = x;
		cur->next->next = NULL;
	}

	for (i = 0; i < N; i++)//큐에 들어올 데이터의 개수를 알기에 할 수 있는 연산, 원래는 비교연산을 통해 큐가 비었는지 확인해야 한다.
	{
		Find(Queue[i]);
	}

	for (i = 2; i <= N; i++)
	{
		printf("%d\n", brray[i]);
	}


	return 0;
}