#include<iostream>
#include<vector>
#include<queue>

using namespace std;
int N, M;
vector<vector<bool>> cheese;
vector<vector<int>> cnt;
int D[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };

struct pos {
	int i, j;
};

void init() {
	cin >> N >> M;
	cheese.assign(N, vector<bool>(M));
	cnt.assign(N, vector<int>(M, 0));
	int value;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> value;
			cheese[i][j] = (value == 1) ? true : false;
		}
	}
}

void solve() {
	int ans = 0;
	bool no_cheese = false;
	queue<pos> q;
	while (!no_cheese) {
		no_cheese = true;
		q.push({ 0, 0 });
		cnt[0][0] = 1;
		while (!q.empty()) {
			pos cur = q.front();
			q.pop();
			if (cheese[cur.i][cur.j]) {
				no_cheese = false;
				continue;
			}

			for (int k = 0; k < 4; k++) {
				int di = cur.i + D[k][0], dj = cur.j + D[k][1];
				if (di >= 0 && dj >= 0 && di < N && dj < M) {
					if(cnt[di][dj] == 0) q.push({ di, dj });
					cnt[di][dj]++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cnt[i][j] >= 2) {
					cheese[i][j] = false;
				}
				cnt[i][j] = 0;
			}
		}
		if (!no_cheese) ans++;
	}
	cout << ans;
}

int main() {
	init();
	solve();
}