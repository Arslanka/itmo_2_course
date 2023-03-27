#include <iostream>
#include <vector>

// @author: Arslanka

void GO() {
#ifdef LOL
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#else
    //    freopen("game.in", "r", stdin);
//    freopen("game.out", "w", stdout);
#endif
    std::ios_base::sync_with_stdio(0);
    std::cin.tie(0), std::cout.tie(0);
}

bool check(std::vector<int> &cows, int m, int k) {
    int cow_cnt = 1;
    int cur_cow = cows[0];
    for (auto c: cows) {
        if (c - cur_cow >= m) {
            cow_cnt++;
            cur_cow = c;
        }
    }
    return cow_cnt >= k;
}

void solve() {
    int n, k;
    std::cin >> n >> k;
    std::vector<int> cows(n);
    for (auto &i: cows) std::cin >> i;
    int l = 0, r = cows.back() - cows.front() + 1;
    while (r - l > 1) {
        int m = l + (r - l) / 2;
        if (check(cows, m, k)) {
            l = m;
        } else {
            r = m;
        }
    }
    std::cout << l << '\n';
}

signed main() {
    GO();
    solve();
}
