#include<iostream>
#include<vector>
#include<limits>

using namespace std;

int N, M;
vector<vector<int>> edges;
vector<vector<int>> sps;

void init() {
	cin >> N >> M;
	int x, y;
	edges.resize(N);
	for (int i = 0; i < M; i++) {
		cin >> x >> y;
		edges[x - 1].push_back(y - 1);
		edges[y - 1].push_back(x - 1);
	}
}

void solution() {
	for (int i = 0; i < N; i++) {
		vector<int> search(1, i);
		vector<int> sp(N, numeric_limits<int>::max());
		sp[i] = 0;
		while (!search.empty()) {
			int u = search.back();
			search.pop_back();
			for(auto& edge : edges[u]) {
				if (sp[u] + 1 < sp[edge]) {
					sp[edge] = sp[u] + 1;
					search.push_back(edge);
				}
			}
		}
		sps.push_back(sp);
	}
	/*
	for (int i = 0; i < N; i++) {
		for (auto& p : sps[i]) cout << p << " ";
		cout << endl;
	}
	*/
	int kb_min = numeric_limits<int>::max(), min_idx = 0;
	for (int i = 0; i < N; i++) {
		int kb = 0;
		for (auto& p : sps[i]) kb += p;
		if (kb < kb_min) {
			kb_min = kb;
			min_idx = i + 1;
		}
	}
	cout << min_idx;
}

int main() {
	init();
	solution();
}