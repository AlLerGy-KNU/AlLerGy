#include <bits/stdc++.h>
using namespace std;

int s, n, k, l;

int func(int a) {
    int d = abs(a-s);
    if(d > 2*k) {
        return (d-2*k)*l;
    }
    else if(d <= 2*k) {
        return 2*k-d;
    }
}
void solve() {
    cin >> s >> n;
    vector<int> a(n);
    for(int i=0;i<n;i++) cin >> a[i];
    cin >> k >> l;
    
    int mn = func(a[0]), mn_idx = 0;

    for(int i=1;i<n;i++) {
        int t = func(a[i]);
        if(t < mn) {
            mn = t;
            mn_idx = i;
        }
    }

    cout << mn << ' ' << mn_idx+1 << '\n';
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int t; t=1;
	while(t--) solve();
}
