#include<iostream>
#include<queue>

using namespace std;
int map[41][41], dist[41][41];
const int max_dist = 99999999;
int D[4][2] = { {0,1},{1,0},{0,-1},{-1,0} };
int n, shark_size = 2, growth_left = 2, x, y;

void init() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 9) {
				map[i][j] = 0;
				x = i;
				y = j;
			}
		}
	}
}

void set0() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			dist[i][j] = 0;
		}
	}
}

void solve() {
	int ans = 0;
	queue<pair<int, int>> q;
	int tx, ty, min_dist;
	do {
		tx = 41;
		ty = 41;
		min_dist = max_dist;
		set0();
		q.push({ x, y });
		while (!q.empty()) {
			int i = q.front().first, j = q.front().second;
			q.pop();

			// cout << i << ' ' << j << "move\n";

			for (int d = 0; d < 4; d++) {
				int di = i + D[d][0], dj = j + D[d][1];
				if (di >= 0 && dj >= 0 && di < n && dj < n) {
					if (dist[di][dj] == 0 && map[di][dj] <= shark_size) {
						q.push({ di, dj });
						dist[di][dj] += dist[i][j] + 1;
						if (map[di][dj] != 0 && map[di][dj] < shark_size) { // eat check
							if (dist[di][dj] < min_dist || (dist[di][dj] == min_dist && di < tx) || (dist[di][dj] == min_dist && di == tx && dj < ty)) {
								tx = di;
								ty = dj;
								min_dist = dist[di][dj];
							}
							else if(dist[di][dj] > min_dist) {
								q = queue<pair<int, int>>();
							}
						}
					}
				}
			}
		}
		dist[x][y] = 0;
		if (min_dist != max_dist) {
			ans += dist[tx][ty];
			map[tx][ty] = 0;
			x = tx;
			y = ty;
			growth_left--;
			if (growth_left == 0) {
				shark_size++;
				growth_left = shark_size;
			}
		}
		else break;

		/*
		cout << "\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cout << map[i][j] << ' ';
			}
			cout << "\n";
		}
		cout << ans;
		*/

	} while (min_dist != max_dist);
	cout << ans;
}

int main() {
	init();
	solve();
}