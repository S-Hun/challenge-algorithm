#include<iostream>
#include<queue>
#include<utility>

using namespace std;
typedef long long ll;
int n, m;
int map[1001][1001];
int dir[4][2] = { {-1,0},{0,1},{1,0},{0,-1} };
queue<pair<int, int>> q;

void input() {
	cin >> m >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) q.push(make_pair(i, j));
		}
	}
}

void solve() {
	while (!q.empty()) {
		pair<int, int> cur = q.front();
		q.pop();

		int v = map[cur.first][cur.second];
		for (int k = 0; k < 4; k++) {
			int di = cur.first + dir[k][0], dj = cur.second + dir[k][1];
			if (di >= 0 && dj >= 0 && di < n && dj < m) {
				if (map[di][dj] != -1) {
					if (map[di][dj] == 0 || map[di][dj] > v + 1) {
						map[di][dj] = v + 1;
						q.push(make_pair(di, dj));
					}
				}
			}
		}
	}
	int time_cnt = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) {
				cout << -1;
				return;
			}
			else if (map[i][j] > time_cnt) time_cnt = map[i][j];
		}
	}
	cout << time_cnt - 1;
}

int main() {
	input();
	solve();
}