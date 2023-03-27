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

    int dp[n + 1][(sum + 1) / 2 + 1];

    for (int c = 0; c <= sum; ++c) {
        dp[0][c] = 0;
    }

    for (int i = 1; i <= n; ++i) {
        for (int c = 0; c < weights[i - 1]; ++c) {
            dp[i][c] = dp[i - 1][c];
        }
        for (int c = weights[i - 1]; c <= (sum + 1) / 2; ++c) {
            dp[i][c] = max(dp[i - 1][c], dp[i - 1][c - weights[i - 1]] + weights[i - 1]);
        }
    }
    cout << abs(dp[n][(sum + 1) / 2] - (sum - dp[n][(sum + 1) / 2])) << '\n';
}

signed main() {
    GO();
    solve();
}