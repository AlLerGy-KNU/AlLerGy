#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, k; cin >> n >> k;
    vector<long double> a(n);
    for(int i=0;i<n;i++) {
        long double x, y; cin >> x >> y;
        a[i] = sqrt(x*x+y*y);
    }
    sort(a.begin(), a.end());
    int ans = 0;
    int i=0, j=0;
    for(i=0;i<n;i++) {
        while(j != n-1 && a[j+1] <= a[i]+k) j++;
        ans = max(ans, j-i+1);
    }
    
    cout.precision(15);
    cout << fixed << (long double)(ans*100)/(long double)(n) << '\n';
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int t; t=1;
	while(t--) solve();
}
