#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<cmath>

using namespace std;
int N, M;
vector<vector<int>> edges;
vector<int> inDeg;
vector<int> s;
vector<int> ans;

void init() {
	int num, pre, singer;
	cin >> N >> M;
	edges.resize(N + 1);
	inDeg.resize(N + 1, 0);
	for (int i = 0; i < M; i++) {
		cin >> num;
		cin >> singer;
		for (int j = 1; j < num; j++) {
			pre = singer;
			cin >> singer;
			edges[pre].push_back(singer);
			inDeg[singer]++;
		}
	}
	for (int i = 1; i < N + 1; i++) if (inDeg[i] == 0) { s.push_back(i); }
}

void solve() {
	if (s.empty()) {
		cout << 0;
		goto END;
	}
	while (!s.empty()) {
		int src = s.back();
		s.pop_back();
		ans.push_back(src);

		for (auto& dst : edges[src]) {
			inDeg[dst] -= 1;
			if (inDeg[dst] == 0) s.push_back(dst);
			if (inDeg[dst] < 0) {
				cout << 0;
				goto END;
			}
		}
	}

	if (ans.size() != N) cout << 0;
	else for (auto& a : ans) cout << a << '\n';
END:
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
