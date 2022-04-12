#include<iostream>
#include<vector>
#include<utility>
#include<limits>
#include<queue>

using namespace std;

int N, M, dest;
vector<vector<int>> G;
vector<vector<int>> sps;

void init() {
	cin >> N >> M >> dest;
	for (int i = 0; i < N; i++) {
		G.push_back(vector<int>(N, -1));
		sps.push_back(vector<int>(N, numeric_limits<int>::max()));
	}
	int x, y, w;
	for (int j = 0; j < M; j++) {
		cin >> x >> y >> w;
		G[x-1][y-1] = w;
	}
}

void solution() {
	priority_queue<pair<int, int>, vector<pair<int,int>>, greater<>> q;
	for (int i = 0; i < N; i++) {
		sps[i][i] = 0;
		q.push(pair<int,int>(0, i));
		while (!q.empty()) {
			pair<int, int> cur = q.top();
			q.pop();
			for (int j = 0; j < N; j++) {
				if (G[cur.second][j] == -1) continue;
				if (sps[i][j] > cur.first + G[cur.second][j]) {
					sps[i][j] = cur.first + G[cur.second][j];
					q.push(pair<int, int>(sps[i][j], j));
				}
			}
		}
	}
	/*
	cout.precision(4);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << sps[i][j] << " ";
		}
		cout << endl;
	}
	*/
	int ans = 0;
	for (int i = 0; i < N; i++) {
		ans = max(ans, sps[i][dest-1] + sps[dest-1][i]);
	}
	cout << ans;
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(0);
	init();
	solution();
}