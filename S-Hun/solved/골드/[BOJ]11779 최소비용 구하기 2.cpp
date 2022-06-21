#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;
int n, m, src, dst;
struct bus {
	int dst;
	int cost;
};
struct pq {
	int src;
	int dist;
};
struct comp {
	bool operator()(pq& a, pq& b) {
		return a.dist > b.dist;
	}
};
const int inf = 1'000'000'000;
vector<vector<bus>> edges;
vector<pq> path;

void init(){
	cin >> n >> m;
	edges.resize(n + 1);
	path.resize(n + 1, {-1, inf});
	int s, e, c;
	for (int i = 0; i < m; i++) {
		cin >> s >> e >> c;
		edges[s].push_back({ e, c });
	}
	cin >> src >> dst;
	path[src].dist = 0;
}

void solve() {
	priority_queue<pq, vector<pq>, comp> q;
	q.push({ src, 0 });
	while (!q.empty()) {
		pq cur = q.top();
		q.pop();
		if (cur.src == dst || cur.dist >= path[dst].dist) continue;

		for (auto& p : edges[cur.src]) {
			if (path[p.dst].dist > path[cur.src].dist + p.cost) {
				path[p.dst].src = cur.src;
				path[p.dst].dist = path[cur.src].dist + p.cost;
				q.push({ p.dst, path[p.dst].dist });
			}
		}
	}
	vector<int> ans;
	int tmp = dst;
	while (tmp != -1) {
		ans.push_back(tmp);
		//cout << tmp << '\n';
		tmp = path[tmp].src;
	}
	cout << path[dst].dist << '\n' << ans.size() << '\n';
	while (!ans.empty()) {
		cout << *ans.rbegin() << ' ';
		ans.pop_back();
	}
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
