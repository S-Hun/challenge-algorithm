#include<iostream>
#include<vector>
#include<queue>

using namespace std;
int n;
vector<vector<int>> edges;
vector<int> ans;

void init(){
	cin >> n;
	edges.resize(n + 1);
	ans.resize(n + 1, -1);
	ans[1] = 0;
	int s, e;
	for (int i = 0; i < n - 1; i++) {
		cin >> s >> e;
		edges[s].push_back(e);
		edges[e].push_back(s);
	}
}

void solve() {
	queue<int> q;
	q.push(1);
	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (auto& e : edges[cur]) {
			if (ans[e] == -1) {
				ans[e] = cur;
				q.push(e);
			}
		}
	}
	for (int i = 2; i <= n; i++) {
		cout << ans[i] << '\n';
	}
}

int main(void) {
	init();
	solve();
}
