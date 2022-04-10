#include<iostream>
#include<vector>
#include<stack>
#include<deque>
#include<algorithm>

using namespace std;

int T;

int solution() {
	int N, K, W;
	cin >> N >> K;
	vector<int> D(N);
	vector<int> edgein(N, 0);
	vector<vector<int>> step(N, vector<int>());
	for (auto& d : D) cin >> d;
	for (int i = 0; i < K; i++) {
		int X, Y;
		cin >> X >> Y;
		step[X-1].push_back(Y-1);
		edgein[Y - 1] += 1;
	}
	cin >> W;
	W -= 1;
	deque<int> q;
	vector<int> result(D.begin(), D.end());
	for (int i = 0; i < N; i++) {
		if (edgein[i] == 0) q.push_front(i);
	}
	while (!q.empty()) {
		int cur = q.front();
		q.pop_front();

		for (auto& next : step[cur]) {
			result[next] = max(result[next], result[cur] + D[next]);
			edgein[next] -= 1;

			if(edgein[next] == 0)
				q.push_front(next);
		}
	}
	return result[W];
}

int main() {
	cin >> T;
	for (int i = 0; i < T; i++) {
		cout << solution() << "\n";
	}
}