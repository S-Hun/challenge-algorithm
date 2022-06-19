#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int n, m;
const int inf = 1'000'000'000;
vector<vector<int>> bus;
vector<vector<int>> dist;

void init(){
	cin >> n >> m;
	bus.resize(n, vector<int>(n, inf));
	dist.resize(n, vector<int>(n, inf));
	int s, e, c;
	for (int i = 0; i < m; i++) {
		cin >> s >> e >> c;
		if (bus[s - 1][e - 1] > c) { bus[s - 1][e - 1] = c; dist[s - 1][e - 1] = c; }
	}
	for (int i = 0; i < n; i++) { dist[i][i] = 0; bus[i][i] = 0; }
}

void solve() {
	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (dist[i][j] < inf) cout << dist[i][j] << ' ';
			else cout << "0 ";
		}
		cout << '\n';
	}
}

int main(void) {
	init();
	solve();
}
