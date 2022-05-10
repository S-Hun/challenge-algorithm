#include<iostream>
#include<string>
#include<vector>
#include<queue>

using namespace std;
int tc, a, b;
queue<pair<int, string>> q;
vector<bool> used;
char dir[4] = { 'D','S','L','R' };

void init() {
	q = queue<pair<int, string>>();
	used.assign(10000, false);
	cin >> a >> b;
}

int calc(int way, int v) {
	switch (way) {
	case 0:
		return (v * 2) % 10000;
	case 1:
		return (v + 9999) % 10000;
	case 2:
		return (v * 10) % 10000 + v / 1000;
	case 3:
		return v / 10 + (v % 10) * 1000;
	}
}

void solve() {
	used[a] = true;
	q.push(pair<int, string>(a, ""));
	while (!q.empty()) {
		int cur = q.front().first;
		string com = q.front().second;
		q.pop();
		if (cur == b) {
			cout << com << '\n';
			break;
		}
		for (int k = 0; k < 4; k++) {
			int v = calc(k, cur);
			if (used[v]) continue;
			used[v] = true;
			q.push(pair<int, string>(v, com + dir[k]));
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> tc;
	while (tc--) {
		init();
		solve();
	}
}
