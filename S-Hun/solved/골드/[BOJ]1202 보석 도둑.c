#include<iostream>
#include<queue>
#include<vector>
#include<utility>
#include<algorithm>

using namespace std;
int N, K;
vector<pair<int, int>> jews;
priority_queue<int> jqw;
priority_queue<int, vector<int>, greater<>> bags;

void init() {
	cin >> N >> K;
	int a, b;
	for (int i = 0; i < N; i++) {
		cin >> a >> b;
		jews.push_back(make_pair(a, b));
	}
	for (int i = 0; i < K; i++) {
		cin >> a;
		bags.push(a);
	}
}

void solution() {
	sort(jews.begin(), jews.end());
	int jew_i = 0;
	long long ans = 0;
	while (!bags.empty()) {
		int bag = bags.top();
		bags.pop();

		for (; jew_i < N && jews[jew_i].first <= bag; jew_i++) {
			jqw.push(jews[jew_i].second);
		}

		if (jqw.empty()) continue;
		ans += jqw.top();
		jqw.pop();
	}
	cout << ans;
}

int main() {
	init();
	solution();
}