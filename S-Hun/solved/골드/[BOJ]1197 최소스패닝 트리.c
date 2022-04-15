#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<cmath>
#include<limits>
#include<tuple>
#include<queue>

using namespace std;
typedef pair<int, int> path;
int v, e;
vector<bool> visit;
vector<path> edges[10001];

void init() {
	cin >> v >> e;
	int s, d, w;
	for (int i = 0; i < e; i++) {
		cin >> s >> d >> w;
		edges[s].push_back(path(w, d));
		edges[d].push_back(path(w, s));
	}
	visit.assign(v+1, false);
}

void solution() {
	long long ans = 0;
	priority_queue<path, vector<path>, greater<>> P;
	P.push(path(0, 1));

	while (!P.empty()) {
		path cur = P.top();
		P.pop();

		if (visit[cur.second]) continue;
		visit[cur.second] = true;
		ans += cur.first;

		for (int i = 0; i < edges[cur.second].size(); i++) {
			if (!visit[edges[cur.second][i].second]) {
				P.push(edges[cur.second][i]);
			}
		}
	}
	cout << ans;
}

int main() {
	init();
	solution();
}