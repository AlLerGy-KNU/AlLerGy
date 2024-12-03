#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, m; cin >> n >> m;
    vector<int> a(n);
    for(int i=0;i<n;i++) cin >> a[i];
    for(int i=0;i<n;i++) {
        if(a[i]%7 != 0 || a[i]%49 == 0) {
            cout << "-1\n";
            return;
        }
        a[i] /= 7;
    }
    // maximum = 1428571 < 1200 * 1200
    // 1200 보다 작은 소수로 나눠지던가 아니면 소수이던지
    // 그리고 1200 보다 큰 소수라면? 최대 1승이다.

    vector<int> prime;
    vector<bool> visited(1200, false);
    for(int i=2;i<1200;i++) {
        if(visited[i]) continue;
        prime.push_back(i);
        for(int j=i+i;j<1200;j+=i) visited[j] = true;
    }
    // prime.size() == 196
    int ans = 0;
    for(auto p:prime) {
        vector<int> t(n, 0);
        int cur = 0;
        for(int i=0;i<n;i++) {
            if(a[i]%p == 0) {
                int cnt = 0;
                while(a[i]%p == 0) {
                    a[i] /= p;
                    cnt++;
                }
                if(cnt > cur) {
                    ans += cnt-cur;
                    if(i+m-1 < n) t[i+m-1] = cnt-cur;
                    cur = cnt;
                }
            }
            cur -= t[i];
        }
    }
    map<int, vector<int>> mp;
    for(int i=0;i<n;i++) {
        if(a[i] == 1) continue;
        mp[a[i]].push_back(i);
    }
    for(auto it=mp.begin();it!=mp.end();it++) {
        int cur = -1; // 처리가 가능한 최댓값
        for(auto e:it->second) {
            if(e > cur) {
                ans++;
                cur = e+m-1;
            }
        }
    }
    cout << ans << '\n';
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int t; t=1;
	while(t--) solve();
}
