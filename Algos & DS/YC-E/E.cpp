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

void solve() {
    std::vector<std::string> a;
    std::string s;
    while (std::cin >> s) {
        a.push_back(s);
    }
    sort(a.begin(), a.end(), [](const std::string &s1, const std::string &s2) { return s1 + s2 > s2 + s1; });
    for (auto &i: a) std::cout << i;
}

signed main() {
    GO();
    solve();
}
