#include<iostream>
#include<queue>
#include<vector>
#include<utility>
#include<algorithm>

using namespace std;
int n, m;
vector<pair<int, int>> roads[100001];
bool visit[100001];
vector <int> ans;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> q;

void input() {
	cin >> n >> m;
	int s, e, w;
	for (int i = 0; i < m; i++) {
		cin >> s >> e >> w;
		roads[s].push_back(make_pair(w, e));
		roads[e].push_back(make_pair(w, s));
	}
}

void solution() {
	int maxw = -1, sum = 0;
	q.push(make_pair(0, 1));
	while (!q.empty()) {
		pair<int, int> road = q.top();
		q.pop();
		if (visit[road.second]) continue;
		visit[road.second] = true;
		sum += road.first;
		if (maxw < road.first) maxw = road.first;
		ans.push_back(road.first);
		for (auto& r : roads[road.second]) {
			q.push(r);
		}
	}
	cout << sum - maxw;
}

int main() {
	input();
	solution();
}