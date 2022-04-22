#include<iostream>
#include<queue>
#include<vector>
#include<utility>
#include<algorithm>

using namespace std;
int n, m;
vector<int> graph[32001];
vector<int> in_edge;
vector<int> ans;
bool visit[32001];
priority_queue<int, vector<int>, greater<>> q;

void input() {
	cin >> n >> m;
	in_edge.resize(n + 1);
	int fir, sec;
	for (int i = 0; i < m; i++) {
		cin >> fir >> sec;
		in_edge[sec] += 1;
		graph[fir].push_back(sec);
	}
}

void solution() {
	for (int i = 1; i <= n; i++) {
		if (in_edge[i] == 0) {
			q.push(i);
			visit[i] = true;
		}
	}
	while (!q.empty()) {
		int cur = q.top();
		ans.push_back(cur);
		q.pop();
		for (auto& p : graph[cur]) {
			in_edge[p] -= 1;
			if (!visit[p] && in_edge[p] <= 0) q.push(p);
		}
	}
	for (auto& i : ans) cout << i << " ";
}

int main() {
	input();
	solution();
}