#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<cmath>

using namespace std;
int N, A, B;
struct line {
	int src;
	int dst;
};
struct te {
	int value;
};
bool comp(const line& a, line b) {
		if (a.src == b.src) return a.dst < b.dst;
		else return a.src < b.src;
}
vector<line> lines;
vector<int> ans, pos;

void init() {
	cin >> N;
	int src, dst;
	for (int i = 0; i < N; i++) {
		cin >> src >> dst;
		lines.push_back({ src, dst });
	}
	sort(lines.begin(), lines.end(), comp);
}

void solve() {
	ans.push_back(lines[0].dst);
	pos.push_back(0);
	for (int i = 1; i < N; i++) {
		if (ans.back() < lines[i].dst) {
			ans.push_back(lines[i].dst);
			pos.push_back(ans.size() - 1);
		}
		else {
			int j = lower_bound(ans.begin(), ans.end(), lines[i].dst) - ans.begin();
			ans[j] = lines[i].dst;
			pos.push_back(j);
		}
	}
	/*
	for (auto& v : ans) cout << v << ' ';
	cout << '\n';
	for (auto& v : pos) cout << v << ' ';
	cout << '\n';
	*/
	int len = ans.size();
	cout << N - len << '\n';
	ans.clear();

	len = len - 1;
	for (int i = N - 1; i >= 0; i--) {
		if (pos[i] == len) {
			len--;
		}
		else {
			ans.push_back(lines[i].src);
		}
	}
	sort(ans.begin(), ans.end());
	for (auto& v : ans) cout << v << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
