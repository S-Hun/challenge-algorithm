#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std;
struct Node {
	int index;
	int weight;
};

struct cmp {
	bool operator()(const Node& a, const Node& b) {
		return a.weight > b.weight;
	}
};

const int NODE_MAX = 20'001;
int N, E;
int start;
int dist[NODE_MAX];
const int inf = 200'001;
vector<Node> edges[NODE_MAX];

void init() {
	cin >> N >> E;
	cin >> start;
	int s, e, d;
	for (int i = 0; i < E; i++) {
		cin >> s >> e >> d;
		edges[s].push_back({ e, d });
	}
}

void dijkstra(int s) {
	for (int i = 1; i <= N; i++) dist[i] = inf;
	priority_queue<Node, vector<Node>, cmp> q;
	q.push({s, 0});
	dist[s] = 0;
	while (!q.empty()) {
		int node = q.top().index;
		int w_sum = q.top().weight;
		q.pop();

		for (auto& v : edges[node]) {
			if (dist[v.index] > w_sum + v.weight) {
				dist[v.index] = w_sum + v.weight;
				q.push({ v.index, dist[v.index] });
			}
		}
	}
}

void solve() {
	dijkstra(start);
	for (int i = 1; i <= N; i++) {
		if (dist[i] == inf) cout << "INF\n";
		else cout << dist[i] << '\n';
	}
}

int main() {
	init();
	solve();
}