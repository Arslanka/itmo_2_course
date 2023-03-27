#include <iostream>
#include <cmath>

// @author: Arslanka
#define re return
#define ll long long
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

ll result_table[512][512];
ll num = 0;

void color(ll x, ll y, ll i, ll j, ll n) {
    ++num;
    n = n / 2;
    if ((x - j) >= n && (y - i) >= n) {
        result_table[i + n][j + n - 1] = num;
        result_table[i + n - 1][j + n] = num;
        result_table[i + n - 1][j + n - 1] = num;
        if (n > 1) {
            color(j + n - 1, i + n - 1, i, j, n);
            color(j + n, i + n - 1, i, j + n, n);
            color(x, y, i + n, j + n, n);
            color(j + n - 1, i + n, i + n, j, n);
        }
    } else if ((x - j) < n && (y - i) < n) {
        result_table[i + n - 1][j + n] = num;
        result_table[i + n][j + n] = num;
        result_table[i + n][j + n - 1] = num;
        if (n > 1) {
            color(x, y, i, j, n);
            color(j + n, i + n - 1, i, j + n, n);
            color(j + n, i + n, i + n, j + n, n);
            color(j + n - 1, i + n, i + n, j, n);
        }
    } else if ((x - j) >= n && (y - i) < n) {
        result_table[i + n - 1][j + n - 1] = num;
        result_table[i + n][j + n] = num;
        result_table[i + n][j + n - 1] = num;
        if (n > 1) {
            color(j + n - 1, i + n - 1, i, j, n);
            color(x, y, i, j + n, n);
            color(j + n, i + n, i + n, j + n, n);
            color(j + n - 1, i + n, i + n, j, n);
        }
    } else if ((x - j) < n && (y - i) >= n) {
        result_table[i + n - 1][j + n - 1] = num;
        result_table[i + n - 1][j + n] = num;
        result_table[i + n][j + n] = num;
        if (n > 1) {
            color(j + n - 1, i + n - 1, i, j, n);
            color(j + n, i + n - 1, i, j + n, n);
            color(j + n, i + n, i + n, j + n, n);
            color(x, y, i + n, j, n);
        }
    }
    re;
}

ll binpow(ll a, ll n) {
    ll res = 1;
    while (n) {
        if (n & 1)
            res *= a;
        a *= a;
        n >>= 1;
    }
    return res;
}

void solve() {
    int n, x, y;
    cin >> n >> y >> x;
    n = 1 << n;
    if ((int) (binpow(n, 2) - 1ll) % 3 != 0) {
        cout << "-1\n";
        re;
    }

    color(x - 1, y - 1, 0, 0, n);

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cout << result_table[i][j] << ' ';
        }
        cout << '\n';
    }

}

signed main() {
    GO();
    solve();
}