#include<iostream>
#include<vector>
#include<utility>
#include<cmath>
#include<algorithm>

using namespace std;
int n;
struct coord {
    double x, y;
};
vector<coord> points;

double tri_area(coord p1, coord p2, coord p3) {
    double sum0 = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
    double sum1 = p2.x * p1.y + p3.x * p2.y + p1.x * p3.y;
    return abs(sum0 - sum1) / 2;
}

void init() {
    cin >> n;
    points.resize(n);
    for (int i = 0; i < n; i++) cin >> points[i].x >> points[i].y;
}

void solve() {
    double ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                ans = max(ans, tri_area(points[i], points[j], points[k]));
            }
        }
    }
    printf("%.9lf", ans);
}

int main()
{
    init();
    solve();
}