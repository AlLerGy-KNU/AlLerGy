#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N,M,L;
int X,Y;

int board[1002][1002];
int dist[1002][1002];

int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};

bool OOP(int x, int y){
    return ( x < 0 || x>=N || y < 0 || y>=M );
}

int mx;
int mx_L;
queue<pair<int,int>> Q;

vector<int> rs;

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M >> L;
    cin >> X>> Y;

    for(int i = 0; i<N; i++){
        for(int j = 0; j<M; j++){
            cin >> board[i][j];
        }
    }

    Q.push({X-1,Y-1});
    dist[X-1][Y-1] = 1;


    int mx = board[X-1][Y-1];
    rs.push_back({mx});

    while(!Q.empty()){
        auto cur = Q.front(); Q.pop();

        int cur_level = dist[cur.first][cur.second];

        for(int dir = 0 ; dir<4; dir++){
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];

            if( OOP(nx,ny) || board[nx][ny] == -1  ) continue;
            if( dist[nx][ny] > 0  ) continue;
            Q.push({nx,ny});
            dist[nx][ny] = dist[cur.first][cur.second] + 1;

            mx += board[nx][ny];

        }

        rs.push_back(mx-cur_level*L); 

    }

    int result = *max_element(rs.begin(),rs.end());
    if(result > 0 ){
        cout << result;
    }else{
        cout << 0;
    }
}

/*

BFS를 진행하며

각 L 세기에서의 얻을 수 있는 이윤을 기록 후

최대 이윤을 출력합니다.

*/

