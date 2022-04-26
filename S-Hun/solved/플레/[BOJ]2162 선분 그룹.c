#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;
typedef pair<int, int> Point;
int n;
Point lines[3001][2];
bool used[3001];

void input() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> lines[i][0].first >> lines[i][0].second >> lines[i][1].first >> lines[i][1].second;
	}
}

int ccw(Point p1, Point p2, Point p3) { // 7
	Point v1 = Point(p2.first - p1.first, p2.second - p1.second);
	Point v2 = Point(p3.first - p1.first, p3.second - p1.second);
	int outer = v1.first * v2.second - v2.first * v1.second;
	return ((outer == 0) ? 0 : (outer > 0) ? 1 : -1);
}

int simple_dist(Point p1, Point p2) { // 4
	return (p2.second - p1.second) * (p2.second - p1.second) + (p2.first - p1.first) * (p2.first - p1.first);
}

bool p_cross(Point p1, Point p2, Point p3, Point p4) { // 12
	return simple_dist(p1, p2) >= min(simple_dist(p1, p3), simple_dist(p1, p4));
}

void solution() {
	int grp_cnt = 0, max_cnt = 0;
	int cnt = 0;
	Point p1, p2, p3, p4;
	queue<int> q;
	for (int i = 0; i < n; i++) {
		if (!used[i]) { 
			q.push(i);
			grp_cnt += 1;
			cnt = 0;
		}
		while (!q.empty()) {
			int cur = q.front();
			cnt += 1;
			used[cur] = true;
			q.pop();

			for (int j = 0; j < n; j++) {
				if (used[j]) continue;
				p1 = lines[cur][0];
				p2 = lines[cur][1];
				p3 = lines[j][0];
				p4 = lines[j][1];
				int res1 = ccw(p1, p2, p3);
				int res2 = ccw(p1, p2, p4);
				int res3 = ccw(p3, p4, p1);
				int res4 = ccw(p3, p4, p2);
				if ((res1 == 0 && res2 == 0 && p_cross(p1, p2, p3, p4))
					|| (res1 != res2 && res3 != res4)) {
					used[j] = true;
					q.push(j);
				} 
			}
		}
		max_cnt = max(max_cnt, cnt);
	}
	cout << grp_cnt << '\n' << max_cnt;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	input();
	solution();
}
