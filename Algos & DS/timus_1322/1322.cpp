#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>
// @author: Arslanka

#define int long long

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
    int n;
    std::string s, sorted;
    std::cin >> n >> s;
    --n;
    size_t len = s.size();
    std::unordered_map<char, std::vector<std::size_t>> mp;
    std::unordered_map<std::size_t, std::size_t> reverse_mp;
    sorted = s;
    std::sort(sorted.begin(), sorted.end());
    for (std::size_t i = 0; i < len; ++i) {
        mp[sorted[i]].push_back(i);
    }
    for (size_t i = len - 1; i != -1; --i) {
        reverse_mp[i] = mp[s[i]].back();
        mp[s[i]].pop_back();
    }
    char res[len];
    for (std::size_t i = 0, j = len - 1, k = n; i < len; ++i, --j) {
        res[j] = s[k];
        k = reverse_mp[k];
    }
    for (auto &i: res)
        std::cout << i;
}

signed main() {
    GO();
    solve();
}
