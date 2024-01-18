#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

typedef struct lec { // 시작시간과 종료시간
	long long int start;
	long long int end;
}lec;

int compare(const void* a, const void* b)
{
	lec* n1, * n2;
	n1 = (lec*)a;
	n2 = (lec*)b;

	if (n1->end != n2->end) {
		if (n1->end < n2->end) {
			return -1;
		}
		else if (n1->end == n2->end) {
			return 0;
		}
		else {
			return 1;
		}
	}
	else {
		if (n1->start < n2->start) {
			return -1;
		}
		else if (n1->start == n2->start) {
			return 0;
		}
		else {
			return 1;
		}
	}
}

int main() {
	int N;

	// 회의의 개수 만큼 동적할당
	scanf("%d", &N);
	lec* L = (lec *)malloc(N * sizeof(lec));
	if (L == NULL)
		return -1;

	// 시작시간, 종료시간
	for (int i = 0; i < N; i++) {
		scanf("%lld %lld", &L[i].start, &L[i].end);
	}

	//퀵정렬
	qsort(L, N, sizeof(lec), compare);

	long long int cnt = 0,end=0; // 1번은 필수로 들어가기 위함
	for (int i = 0; i < N; i++) {
		if (end <= L[i].start) { // 시작시간이 종료시간보다 같거나 크면 회의
			cnt++;
			end = L[i].end; // 회의의 종료시간을 기준점으로 변경
		}
	}
	printf("%lld\n", cnt);
	free(L);
}