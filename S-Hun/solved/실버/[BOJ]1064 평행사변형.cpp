#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<cmath>

using namespace std;
struct point {
	double x, y;
};
vector<point> points;

void init() {
	points.resize(3);
	for (int i = 0; i < 3; i++) {
		cin >> points[i].x >> points[i].y;
	}
}

double dist(point a, point b) {
	return sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
}

bool line_test(point o, point a, point b) {
	typedef point vec;
	vec oa{ a.x - o.x, a.y - o.y }, ob{ b.x - o.x, b.y - o.y };
	if ((oa.x == 0 && ob.x == 0)) return false;
	if ((oa.x == 0 && ob.x != 0) || (oa.x != 0 && ob.x == 0)) return true;
	if (oa.y / oa.x == ob.y / ob.x) return false;
	return true;
}

void solve() {
	if (line_test(points[0], points[1], points[2])) {
		double da = dist(points[0], points[1]), db = dist(points[1], points[2]), dc = dist(points[0], points[2]);
		double max_peri = max(da + db, max(da + dc, db + dc));
		double min_peri = min(da + db, min(da + dc, db + dc));
		printf("%.10lf", 2 * (max_peri - min_peri));
		return;
	}
	printf("-1.0");
}

int main() {
	init();
	solve();
}