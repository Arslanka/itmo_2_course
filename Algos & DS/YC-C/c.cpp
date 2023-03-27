#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
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

inline bool is_open_bracket(string &c) {
    return c == "{";
}

inline bool is_close_bracket(string &c) {
    return c == "}";
}

void parse_key_value_from_str(string &s, string &key, string &value) {
    bool was_eq_sign = false;
    for (char i: s) {
        if (i == '=') {
            was_eq_sign = true;
            continue;
        }
        if (was_eq_sign) { value += i; }
        else { key += i; }
    }
}

bool is_number(const string &str) {
    for (int i = 0; i < str.size(); ++i) {
        if (str[i] == '-' && i == 0) continue;
        if (isdigit(str[i]) == 0) return false;
    }
    return true;
}

void solve() {
    string s;
    unordered_map<string, vector<int>> mpst(1);
    vector<unordered_set<string>> re(1);
    while (cin >> s) {
        if (is_open_bracket(s)) {
            re.emplace_back();
        } else if (is_close_bracket(s)) {
            for (auto &i: re.back()) {
                mpst[i].pop_back();
            }
            re.pop_back();
        } else {
            string key, value;
            parse_key_value_from_str(s, key, value);
            if (is_number(value)) {
                int val = stoi(value);
                if (re.back().count(key)) {
                    mpst[key].back() = val;
                } else {
                    mpst[key].push_back(val);
                }
            } else {
                if (re.back().count(key)) {
                    mpst[key].back() = mpst[value].empty() ? 0 : mpst[value].back();
                } else {
                    mpst[key].push_back(mpst[value].empty() ? 0 : mpst[value].back());
                }
                cout << mpst[key].back() << '\n';
            }
            re.back().insert(key);
        }
    }
}

signed main() {
    GO();
    solve();
}
