#include <iostream>
#include <algorithm>
#include <cmath>
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

struct point {
    int x, y, pos;
} points[10001];

inline bool comp(point a, point b) {
    if (atan2(a.y, a.x) - atan2(b.y, b.x) == 0)
        return a.x < b.x;
    return atan2(a.y, a.x) < atan2(b.y, b.x);
}

void solve() {
    int n;
    std::cin >> n;
    int mny = 2e9, mn_pos = -1;
    for (int i = 0; i < n; ++i) {
        std::cin >> points[i].x >> points[i].y;
        points[i].pos = i;
        if (points[i].y < mny) {
            mny = points[i].y;
            mn_pos = i;
        }
    }

    std::swap(points[0], points[mn_pos]);
    for (int i = 1; i < n; ++i) {
        points[i].x -= points[0].x;
        points[i].y -= points[0].y;
    }
    std::sort(points + 1, points + n, comp);
    std::cout << mn_pos + 1 << ' ' << points[n / 2].pos + 1 << '\n';
}

signed main() {
    GO();
    solve();
}
