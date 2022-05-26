#include<iostream>
#include<vector>
#include<queue>

using namespace std;
struct Line {
	int dprt;
	int cost;
};

struct cmp {
	bool operator()(Line& a, Line& b) {
		return a.cost > b.cost;
	}
};
int N, M;
vector<Line> Bus[1001];
int costs[1001];
int src, dst;

void init() {
	cin >> N >> M;
	int s, e, c;
	for (int i = 0; i < M; i++) {
		cin >> s >> e >> c;
		Bus[s].push_back({ e, c });
	}
	cin >> src >> dst;
}

void dijk(int s) {
	for (int i = 1; i <= N; i++) costs[i] = 100'000'001;
	priority_queue<Line, vector<Line>, cmp> q;
	q.push({ s, 0 });
	costs[s] = 0;
	while (!q.empty()) {
		int city = q.top().dprt;
		int csum = q.top().cost;
		q.pop();
		if (city == dst || csum > costs[dst]) continue;

		for (auto& next : Bus[city]) {
			if (costs[next.dprt] > csum + next.cost) {
				costs[next.dprt] = csum + next.cost;
				q.push({ next.dprt, costs[next.dprt] });
			}
		}
	}
}

void solve() {
	dijk(src);
	cout << costs[dst];
}

int main() {
	init();
	solve();
}