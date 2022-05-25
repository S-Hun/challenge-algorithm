#include<iostream>
#include<vector>
#include<queue>

using namespace std;

struct Edge {
	int vertex;
	int weight;
};
int n;
const int max_node = 10'001;
const int inf = 1'000'001;
int dist[max_node];
int max_dist_node = -1;
int max_dist = 0;
vector<Edge> edges[max_node];

void init() {
	cin >> n;
	int s, e, w;
	for (int i = 1; i <= n - 1; i++) {
		cin >> s >> e >> w;
		edges[s].push_back({ e, w });
		edges[e].push_back({ s, w });
		dist[i] = inf;
	}
	dist[n] = inf;
}

void bfs(int s) {
	queue<int> q;
	q.push(s);
	dist[s] = 0;

	max_dist = 0;
	max_dist_node = -1;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (auto& e : edges[cur]) {
			if (dist[e.vertex] == inf) {
				dist[e.vertex] = dist[cur] + e.weight;
				q.push(e.vertex);
				if (dist[e.vertex] > max_dist) {
					max_dist = dist[e.vertex];
					max_dist_node = e.vertex;
				}
			}
		}
	}
}

void solve() {
	bfs(1);
	for (int i = 1; i <= n; i++) dist[i] = inf;
	bfs(max_dist_node);
	cout << max_dist;
}

int main() {
	init();
	solve();
}