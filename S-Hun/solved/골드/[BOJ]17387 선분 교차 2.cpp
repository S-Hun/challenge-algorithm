#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
typedef pair<long long, long long> Point;
Point p1, p2, p3, p4;

void init() {
    cin >> p1.first >> p1.second;
    cin >> p2.first >> p2.second;
    cin >> p3.first >> p3.second;
    cin >> p4.first >> p4.second;
}

int ccw(Point p1, Point p2, Point p3) { // 7
    Point v1 = Point(p2.first - p1.first, p2.second - p1.second);
    Point v2 = Point(p3.first - p1.first, p3.second - p1.second);
    long long outer = v1.first * v2.second - v2.first * v1.second;
    return ((outer == 0) ? 0 : (outer > 0) ? 1 : -1);
}

void solve() {
    int res1 = ccw(p1, p2, p3);
    int res2 = ccw(p1, p2, p4);
    int res3 = ccw(p3, p4, p1);
    int res4 = ccw(p3, p4, p2);
    if (res1 * res2 == 0 && res3 * res4 == 0) {
        if (p1 > p2) swap(p1, p2);
        if (p3 > p4) swap(p3, p4);
        if (p1 <= p4 && p3 <= p2) cout << 1;
        else cout << 0;
    }
    else if (res1 * res2 <= 0 && res3 * res4 <= 0) cout << 1;
    else cout << 0;
}

int main()
{
    init();
    solve();
}