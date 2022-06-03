#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
int N, M;
vector<int> P;

void init() {
	cin >> N >> M;
	P.resize(M);
	for (int i = 0; i < M; i++) cin >> P[i];
	sort(P.begin(), P.end());
}

void solve() {
	int ans_cost = -1, ans_sum = 0;
	for (int i = (M-N < 0)? 0 : M-N; i < M; i++) {
		if ((M - i) * P[i] > ans_sum) {
			ans_cost = P[i];
			ans_sum = (M - i) * P[i];
		}
	}
	cout << ans_cost << ' ' << ans_sum;
}

int main() {
	init();
	solve();
}