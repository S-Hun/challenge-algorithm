#include<iostream>
#include<queue>

using namespace std;
int n, m;
int min_dist[101];
int sl[101];

void init() {
	cin >> n >> m;
	int x, y;
	for (int i = 0; i < n + m; i++) {
		cin >> x >> y;
		sl[x] = y;
	}
}

void solve() {
	queue<int> q;
	q.push(1);
	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int i = 1; i <= 6; i++) {
			if (sl[cur + i] != 0) {
				if (min_dist[sl[cur + i]] == 0) {
					min_dist[sl[cur + i]] = min_dist[cur] + 1;
					q.push(sl[cur + i]);
				}
			}
			else {
				if (min_dist[cur + i] == 0) {
					min_dist[cur + i] = min_dist[cur] + 1;
					q.push(cur + i);
				}
			}
			if (cur + i >= 100) goto END;
		}
	}
	END:
	cout << min_dist[100];
}

int main() {
	init();
	solve();
}