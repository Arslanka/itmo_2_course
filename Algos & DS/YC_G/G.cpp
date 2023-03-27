#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>

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
    std::string s;
    std::cin >> s;
    std::size_t len = s.size();
    std::vector<std::pair<char, int>> p;
    int mp[26];
    for (auto &i: s) {
        mp[i - 'a']++;
        std::cout << i - 'a' << '\n';
    }
    int weight;
    for (char c = 'a'; c <= 'z'; ++c) {
        std::cin >> weight;
        p.emplace_back(c, weight);
    }

    sort(p.begin(), p.end(),
         [](const std::pair<char, int> &first,
            const std::pair<char, int> &second) {
             return second.second < first.second;
         }
    );
    size_t l = 0, r = len - 1;
    char result[len];
    for (auto &[c, i]: p) {
        if (mp[c - 'a'] > 1) {
            result[l++] = c;
            result[r--] = c;
            mp[c - 'a'] -= 2;
        }
    }
    for (auto &[c, i]: p) {
        while (mp[c - 'a']--) {
            result[l++] = c;
        }
    }
    for (auto &i: result)
        std::cout << i;
}

signed main() {
    GO();
    solve();
}
