#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std;
struct Edge {
	int src;
	int dst;
	int w;
};

const int NODE_MAX = 501;
int TC, N, M, W;
int dist[NODE_MAX];
vector<Edge> edges;

void init() {
	cin >> N >> M >> W;
	int s, e, d;
	edges.clear();
	for (int i = 1; i <= N; i++) dist[i] = 0;
	for (int i = 0; i < M; i++) {
		cin >> s >> e >> d;
		edges.push_back({ s, e, d });
		edges.push_back({ e, s, d });
	}
	for (int i = 0; i < W; i++) {
		cin >> s >> e >> d;
		edges.push_back({ s, e, -d });
	}
}

void solve() {
	bool ans = false;

	for (int i = 1; i <= N; i++) {
		for (auto& e : edges) {
			if (dist[e.dst] > dist[e.src] + e.w) {
				dist[e.dst] = dist[e.src] + e.w;
				if (i == N) ans = true;
			}
		}
	}

	if (ans) cout << "YES\n";
	else cout << "NO\n";
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}