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
    int n;
    cin >> n;
    vector<int> weights(n);
    int sum = 0;
    for (auto &i: weights) {
        cin >> i;
        sum += i;
    }
    int mn = sum;
    for (size_t mask = 0; mask < (1 << n); ++mask) {
        int sum1 = 0, sum2 = 0;
        for (size_t i = 0; i < n; ++i) {
            if ((mask >> i) & 1 | 0) {
                sum1 += weights[i];
            } else {
                sum2 += weights[i];
            }
        }
        mn = min(mn, abs(sum1 - sum2));
    }
    cout << mn << '\n';

}

signed main() {
    GO();
    solve();
}
