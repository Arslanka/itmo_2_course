#include <iostream>
#include <vector>
#include <numeric>

// @author: Arslanka

using namespace std;

void GO() {
#ifdef LOL
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#else
    //    freopen("game.in", "r", stdin);
//    freopen("game.out", "w", stdout);
#endif
    ios_base::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
}

void solve() {
    int a, b, c, d;
    long long k;
    cin >> a >> b >> c >> d >> k;
    vector<int> cycle = {a};
    long long q = k;
    int res = a;
    while (q--) {
        res *= b;
        if (res <= c) {
            cout << "0\n";
            return;
        }
        res -= c;
        if (res >= d) {
            cout << d << '\n';
            return;
        }
        if (res == a) {
            cout << cycle[k % (cycle.size() + 1)] << '\n';
            return;
        }
        cycle.push_back(res);
    }
    cout << res << '\n';
}

signed main() {
    GO();
    solve();
}
