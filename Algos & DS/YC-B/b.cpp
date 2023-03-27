#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <unordered_map>
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
    string s;
    cin >> s;
    stack<char> st;
    for (auto &i: s) {
        if (!st.empty() && tolower(i) == tolower(st.top())) {
            st.pop();
        } else {
            st.push(i);
        }
    }
    if (!st.empty()) {
        cout << "Impossible\n";
        return;
    }
    int lower_cnt = 1;
    unordered_map<char, stack<int>> mp;
    for (auto &i: s) {
        if (islower(i)) {
            mp[i].push(lower_cnt);
            ++lower_cnt;
        }
    }
    cout << "Possible\n";
    for (auto &i: s) {
        if (isupper(i)) {
            cout << mp[tolower(i)].top() << ' ';
            mp[tolower(i)].pop();
        }

    }
}

signed main() {
    GO();
    solve();
}
