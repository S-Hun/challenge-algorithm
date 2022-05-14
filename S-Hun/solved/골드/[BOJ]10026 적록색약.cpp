#include<iostream>
#include<vector>
#include<utility>
#include<queue>
#include<string>

using namespace std;
int n;
string map[101];
bool visit[101][101];
bool visitRG[101][101];
int dir[4][2] = { {1, 0}, {0, 1} ,{-1, 0}, {0, -1} };

struct coord {
	int x, y;

	coord(int a, int b) : x(a), y(b) {}
	coord() {
		x = 0;
		y = 0;
	}
};

void init() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> map[i];
	}
}

void solve() {
	int cnt1 = 0, cnt2 = 0;
	queue<coord> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visit[i][j]) {
				q.push(coord(i, j));
				visit[i][j] = true;
				cnt1 += 1;
			}
			while (!q.empty()) {
				coord cur = q.front();
				q.pop();

				for (int i = 0; i < 4; i++) {
					int dx = cur.x + dir[i][0], dy = cur.y + dir[i][1];
					if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
						if (!visit[dx][dy] && map[dx][dy] == map[cur.x][cur.y]) {
							q.push(coord(dx, dy));
							visit[dx][dy] = true;
						}
					}
				}
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visitRG[i][j]) {
				q.push(coord(i, j));
				visitRG[i][j] = true;
				cnt2 += 1;
			}
			while (!q.empty()) {
				coord cur = q.front();
				q.pop();

				for (int i = 0; i < 4; i++) {
					int dx = cur.x + dir[i][0], dy = cur.y + dir[i][1];
					if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
						if (!visitRG[dx][dy] && 
							(map[dx][dy] == map[cur.x][cur.y] || 
								(map[dx][dy] == 'R' && map[cur.x][cur.y] == 'G') || 
								(map[dx][dy] == 'G' && map[cur.x][cur.y] == 'R'))) {
							q.push(coord(dx, dy));
							visitRG[dx][dy] = true;
						}
					}
				}
			}
		}
	}

	cout << cnt1 << ' ' << cnt2;
}

int main() {
	init();
	solve();
}