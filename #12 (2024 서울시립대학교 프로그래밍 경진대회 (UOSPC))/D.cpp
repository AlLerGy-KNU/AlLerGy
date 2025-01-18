#include<iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

/*
 2024 ����ø����б� ���α׷��� ������ȸ(UOSPC)
 D-������� (32932)
 �з� : ����
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
	�������� -500 ~ 500 ������ ��ǥ���� ���´� �Ͽ�����
	�� ������ rescaling �Ͽ� 0 ~ 1000������ ������ ǥ���� �� �ֽ��ϴ�.
	*/
	int x = 500, y = 500;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		arr[y + 500][x + 500] = true;
	}
	x = 500;
	y = 500;
	/*
	0,0 ��� 500,500���� ������ �ϸ�
	�������� ������ ��� ��ɾ ���� ��ǥ�� �̵������ָ� �˴ϴ�.
	�� �� ��ֹ��� �����ų� �� �̻� ������ �� ���� ��쿣 ��ǥ�� ������Ʈ ���� �ʽ��ϴ�.(�Ǵ� �̵����� �ʽ��ϴ�.)
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