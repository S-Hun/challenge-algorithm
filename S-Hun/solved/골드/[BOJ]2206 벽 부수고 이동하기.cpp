#include<iostream>
#include<vector>
#include<queue>
#include<string>

using namespace std;
int N, M;
bool map[1001][1001];
int cnt_s[1001][1001], cnt_e[1001][1001];
int D[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };

struct pos {
	int i, j;
};

void init() {
	cin >> N >> M;
	string row;
	for (int i = 0; i < N; i++) {
		cin >> row;
		for (int j = 0; j < M; j++) {
			map[i][j] = (row[j] - '0') ? true : false;
		}
	}
}

void bfs(int i, int j, int cnt[][1001]) {
	queue<pos> q;
	q.push({ i, j });
	cnt[i][j] = 1;
	while (!q.empty()) {
		pos cur = q.front();
		q.pop();

		for (int k = 0; k < 4; k++) {
			int di = cur.i + D[k][0], dj = cur.j + D[k][1];
			if (di >= 0 && dj >= 0 && di < N && dj < M) {
				if (cnt[di][dj] == 0) {
					cnt[di][dj] = cnt[cur.i][cur.j] + 1;
					if(map[di][dj] != 1) q.push({ di, dj });
				}
			}
		}
	}
}

void solve() {
	bfs(0, 0, cnt_s);
	bfs(N - 1, M - 1, cnt_e);
	int ans = 1'000'001;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (cnt_s[i][j] != 0 && cnt_e[i][j] != 0) {
				ans = min(ans, cnt_s[i][j] + cnt_e[i][j] - 1);
			}
		}
	}
	if (ans != 1'000'001) cout << ans;
	else cout << -1;
}

int main() {
	init();
	solve();
}