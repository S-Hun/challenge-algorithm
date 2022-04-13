#include<iostream>
#include<vector>

using namespace std;
int n, k;
vector<vector<int>> pebs;
vector<bool> visit;
vector<int> match;

void init() {
	cin >> n >> k;
	pebs.resize(n+1);
	visit.assign(n + 1, false);
	match.assign(n + 1, 0);
	for (int i = 0; i < k; i++) {
		int row, col;
		cin >> row >> col;
		pebs[row].push_back(col);
	}
}

bool dfs(int row) {
	for (auto& col : pebs[row]) {
		if (visit[col]) continue;
		visit[col] = true;
		if (match[col] == 0 || dfs(match[col])) {
			match[col] = row;
			return true;
		}
	}
	return false;
}

int solution() {
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		visit.assign(n + 1, false);
		if (dfs(i)) ans++;
	}
	return ans;
}

int main() {
	init();
	cout << solution();
}