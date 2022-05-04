#include<iostream>
#include<string>
#include<queue>
#include<vector>
#include<utility>
#include<algorithm>

using namespace std;
typedef long long ll;
int n;
string maps[26];
bool visit[26][26];
int dir[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
queue<pair<int, int>> q;
vector<int> ans;

void init() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> maps[i];
	}
}

int bfs(int x, int y) {
	q.push(make_pair(x, y));
	visit[x][y] = true;
	int cnt = 0;
	while (!q.empty()) {
		pair<int, int> cur = q.front();
		q.pop();
		cnt++;

		int i = cur.first, j = cur.second;
		for (int k = 0; k < 4; k++) {
			int di = i + dir[k][0], dj = j + dir[k][1];
			if (di >= 0 && dj >= 0 && di < n && dj < n) {
				if (maps[di][dj] == '1' && !visit[di][dj]) {
					visit[di][dj] = true;
					q.push(make_pair(di, dj));
				}
			}
		}
	}
	return cnt;
}

void solve() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (maps[i][j] == '1' && !visit[i][j]) {
				ans.push_back(bfs(i, j));
			}
		}
	}
	cout << ans.size() << '\n';
	sort(ans.begin(), ans.end());
	for (auto& v : ans) cout << v << '\n';
}

int main() {
	init();
	solve();
}