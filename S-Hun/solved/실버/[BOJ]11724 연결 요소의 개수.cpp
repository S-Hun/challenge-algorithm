#include<iostream>
#include<vector>
#include<queue>

using namespace std;
int n, m;
int visit[1001];
vector<vector<int>> edges;

void init() {
	cin >> n >> m;
	edges.resize(n+1);
	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		edges[a].push_back(b);
		edges[b].push_back(a);
	}
}

void solve() {
	int ans = 0;
	queue<int> q;
	for (int i = 1; i <= n; i++) {
		if (!visit[i]) {
			q.push(i);
			visit[i] = true;
			ans++;
		}
		while (!q.empty()) {
			int cur = q.front();
			q.pop();

			for (auto& t : edges[cur]) {
				if (!visit[t]) {
					q.push(t);
					visit[t] = true;
				}
			}
		}
	}
	cout << ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}