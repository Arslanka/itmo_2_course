#include <iostream>

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
    int eq_in_a_row = 1, cur = -1;
    int flower, l = 0, l_mn = 0, r_mx = n - 1, mx = 1, i;
    for (i = 0; i < n; ++i) {
        cin >> flower;
        if (flower == cur) {
            eq_in_a_row++;
        } else {
            cur = flower;
            eq_in_a_row = 1;
        }
        if (eq_in_a_row == 3) {
            if (i - l > mx) {
                mx = i - l, l_mn = l, r_mx = i - 1;
            }
            l = i - 1;
            cur = flower;
            eq_in_a_row = 2;
        }
    }
    if (i - l > mx) {
        l_mn = l, r_mx = i - 1;
    }
    cout << l_mn + 1 << ' ' << r_mx + 1 << '\n';
}

signed main() {
    GO();
    solve();
}
