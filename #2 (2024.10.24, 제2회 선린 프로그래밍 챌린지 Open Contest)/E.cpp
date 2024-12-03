#include <bits/stdc++.h>
using namespace std;

void solve() {
    long long x, y, c; cin >> x >> y >> c;
    if(x == 0 && y == 0) {
        cout << "0\n";
        return;
    }
    if(x*x+y*y < c*c) {
        cout << "2\n";
        return;
    }
    long double xx = x, yy = y;
    long long ans = ceil(sqrt(xx*xx+yy*yy)/c);

    cout << ans << '\n';
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int t; t=1;
	while(t--) solve();
}
