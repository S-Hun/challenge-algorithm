#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<cmath>
#include<limits>

using namespace std;
typedef pair<int, int> coord;
int tc, n;
vector<coord> points;
vector<bool> start;
double ans;

// 벡터의 성질과 dfs를 이용하는 풀이
void init() {
	cin >> n;
	int a, b;
	points.clear();
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		points.push_back(coord(a, b));
	}
	start.assign(n, false);
}

double vec_sum() {
	coord res(0, 0);
	for (int i = 0; i < n; i++) {
		if (start[i]) {
			res.first -= points[i].first;
			res.second -= points[i].second;
		}
		else {
			res.first += points[i].first;
			res.second += points[i].second;
		}
	}
	return sqrt(pow(res.first, 2) + pow(res.second, 2));
}

void dfs(int cur, int cnt) {
	if (cnt == n / 2) {
		ans = min(ans, vec_sum());
		return;
	}
	for (int i = cur; i < n; i++) {
		if (!start[i]) {
			start[i] = true;
			dfs(i+1, cnt + 1);
			start[i] = false;
		}
	}
}

void solution() {
	ans = numeric_limits<double>::max();
	dfs(0, 0);
	cout << ans << '\n';
}

int main() {
	cin >> tc;
	cout << fixed;
	cout.precision(11);
	while (tc--) {
		init();
		solution();
	}
}