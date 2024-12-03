#include <bits/stdc++.h>
using namespace std;

void solve() {
    int a, b, c; cin >> a >> b >> c;
    if(a < b && b < c) cout << "Yes\n";
    if(a < c && c < b) cout << "No\n";
    if(b < a && a < c) cout << "No\n";
    if(b < c && c < a) cout << "Yes\n";
    if(c < a && a < b) cout << "Yes\n";
    if(c < b && b < a) cout << "No\n";
}
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int t; t=1;
    while(t--) solve();
}
