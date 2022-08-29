#include<iostream>
#include<vector>

using namespace std;
int TC, N, M;

void init() {
	cin >> N >> M;
}

void solve() {
	int ans = 0;
	if (N == 1 && M == 1) cout << "0\n";
	else {
		cout << max(N, M) - 1 + 2 * (min(N, M) - 1) + 1 << '\n';
	}
}

int main() {
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}