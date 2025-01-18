#include<iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

/*
 2024 서울시립대학교 프로그래밍 경진대회(UOSPC)
 D-드론조작 (32932)
 분류 : 구현
*/

bool arr[1001][1001] = { false };
int main(int argc, char** argv)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, k;
	cin >> n >> k;
	char t;

	/*
	문제에는 -500 ~ 500 사이의 좌표값을 갖는다 하였으나
	이 범위를 rescaling 하여 0 ~ 1000사이의 값으로 표현할 수 있습니다.
	*/
	int x = 500, y = 500;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		arr[y + 500][x + 500] = true;
	}
	x = 500;
	y = 500;
	/*
	0,0 대신 500,500에서 시작을 하며
	문제에서 제시한 대로 명령어에 따라 좌표를 이동시켜주면 됩니다.
	이 때 장애물을 만나거나 더 이상 진행할 수 없는 경우엔 좌표를 업데이트 하지 않습니다.(또는 이동하지 않습니다.)
	*/
	for (int i = 0; i < k; i++) {
		cin >> t;
		switch (t) {
		case 'L':
			if (x > 0 && !arr[y][x - 1])
				x--;
			break;
		case 'D':
			if (y > 0 && !arr[y - 1][x])
				y--;
			break;
		case 'R':
			if (x < 1000 && !arr[y][x + 1])
				x++;
			break;
		case 'U':
			if (y < 1000 && !arr[y + 1][x])
				y++;
			break;
		}
	}
	cout << x - 500 << ' ' << y - 500;

	return 0;

}