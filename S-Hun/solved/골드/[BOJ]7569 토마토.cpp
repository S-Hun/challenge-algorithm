#include<iostream>
#include<vector>
#include<queue>

using namespace std;
typedef pair<int, vector<int>> tomato;
int M, N, H;
int box[101][101][101];
int D[6][3] = { {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1} };
queue<tomato> q;

void init() {
	cin >> M >> N >> H;
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				cin >> box[i][j][k];
				if (box[i][j][k] == 1) {
					q.push(tomato(1, vector<int>({ i, j, k }))); 
				}
			}
		}
	}
}

void solve() {
	int ans = 0;
	while (!q.empty()) {
		int cnt = q.front().first;
		int i = q.front().second[0];
		int j = q.front().second[1];
		int k = q.front().second[2];
		q.pop();

		for (int d = 0; d < 6; d++) {
			int di = i + D[d][0], dj = j + D[d][1], dk = k + D[d][2];
			if (di >= 0 && dj >= 0 && dk >= 0 && di < H && dj < N && dk < M) {
				if (box[di][dj][dk] == 0) {
					box[di][dj][dk] = cnt + 1;
					q.push(tomato(cnt + 1, vector<int>({ di, dj, dk })));
				}
			}
		}
	}
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (box[i][j][k] == 0) {
					cout << -1;
					return;
				}
				else ans = max(ans, box[i][j][k]);
			}
		}
	}
	cout << ans - 1;
}

int main() {
	init();
	solve();
}