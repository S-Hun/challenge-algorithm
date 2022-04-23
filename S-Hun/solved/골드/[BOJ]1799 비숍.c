#include<iostream>
#include<queue>
#include<vector>
#include<utility>
#include<algorithm>
#include<cmath>

using namespace std;
int n;
int map[12][12];
vector<pair<int, int>> black;
vector<pair<int, int>> white;
int pmax = 0;

void input() {
	cin >> n;
	int temp;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> temp;
			// map[i][j] = temp;
			if (temp == 1) 
			{
				if ((i + j) % 2 == 0) white.push_back(make_pair(i, j));
				else black.push_back(make_pair(i, j));
			}
		}
	}
}

void dfs(int p, vector<pair<int, int>> bi, vector<pair<int, int>>& coord) {
	if (coord.size() <= p) {
		if (bi.size() > pmax) pmax = bi.size();
		return;
	}
	bool cond = true;
	for (auto& b : bi) {
		if (abs(coord[p].first - b.first) == abs(coord[p].second - b.second)) {
			cond = false;
			break;
		}
	}
	if (cond) {
		bi.push_back(coord[p]);
		dfs(p + 1, bi, coord);
		bi.pop_back();
	}
	dfs(p + 1, bi, coord);
}

void solution() {
	int sum = 0;
	pmax = 0;
	dfs(0, vector<pair<int, int>>(), white);
	sum += pmax;
	pmax = 0;
	dfs(0, vector<pair<int, int>>(), black);
	sum += pmax;
	cout << sum;
}

int main() {
	input();
	solution();
}