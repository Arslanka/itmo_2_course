#include <iostream>
#include <vector>
#include <algorithm>

// @author: Arslanka
using namespace std;

#define int long long

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
    int n, k;
    cin >> n >> k;
    vector<int> a(n);
    long long result = 0;
    for (auto &i: a)  {
        cin >> i;
        result += i;
    }
    sort(a.begin(), a.end());
    for (int i = n - k; i >= 0; i -= k) {
        result -= a[i];
    }
    cout << result << '\n';
}

signed main() {
    GO();
    solve();
}
