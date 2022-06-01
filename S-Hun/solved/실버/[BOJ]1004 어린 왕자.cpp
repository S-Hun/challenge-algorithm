#include<iostream>
#include<vector>
#include<cmath>

using namespace std;
int TC;
int n;
int sx, sy, ex, ey;

int dist(int x1, int y1, int x2, int y2) {
	return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
}

void init() {
	cin >> sx >> sy >> ex >> ey >> n;
}

void solve() {
	int ans = 0;
	int x, y, r;
	bool start, end;
	while (n--) {
		cin >> x >> y >> r;
		start = false; end = false;
		if (dist(x, y, sx, sy) < r * r) start = true;
		if (dist(x, y, ex, ey) < r * r) end = true;
		if (start ^ end) ans++;
	}
	cout << ans << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}