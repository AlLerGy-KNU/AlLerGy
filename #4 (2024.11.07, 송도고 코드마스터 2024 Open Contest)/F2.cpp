#include <bits/stdc++.h>
using namespace std;

const int M = 1e9+7;
void solve() {
    int n, k; cin >> n >> k;
    vector<int> a(n+2, 0);
    for(int i=1;i<=n;i++) cin >> a[i];

    vector<long long> dp1(n+2, 0), dp2(n+2, 0);
    vector<long long> px1(n+2, 0), px2(n+2, 0); // px?[i] = dp?[0] + ... + dp?[i]
    dp1[0] = 1; px1[0] = 1;

    for(int i=1;i<=n+1;i++) {
        px1[i] = px1[i-1];
        px2[i] = px2[i-1];
        if(a[i] == 1) continue;

        dp1[i] = px1[i-1];
        if(i-k-1 >= 0) dp1[i] = (dp1[i] - px1[i-k-1])%M;

        dp2[i] = px2[i-1];
        if(i-k-2 >= 0) dp2[i] = (dp2[i] - px2[i-k-2])%M;
        if(i-k-1 >= 0) dp2[i] = (dp2[i] + dp1[i-k-1])%M;

        px1[i] = (px1[i]+dp1[i])%M;
        px2[i] = (px2[i]+dp2[i])%M;
    }

    dp2[n+1] = (dp2[n+1]+M)%M;

    cout << dp2[n+1] << '\n';
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int t; t=1;
    while(t--) solve();
}
