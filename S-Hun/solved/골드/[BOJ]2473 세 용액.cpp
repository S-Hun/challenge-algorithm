#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<cmath>

using namespace std;
typedef long long ll;
int N;
vector<ll> sol;
ll ans[3];
ll min_sol = 3'000'000'001;

void init() {
	cin >> N;
	sol.resize(N);
	for (int i = 0; i < N; i++) { 
		cin >> sol[i];
	}
}

void check(int i, int j, int k) {
	if (abs(sol[i] + sol[j] + sol[k]) < min_sol) {
		ans[0] = sol[i];
		ans[1] = sol[j];
		ans[2] = sol[k];
		min_sol = abs(sol[i] + sol[j] + sol[k]);
	}
}

void solve() {
	sort(sol.begin(), sol.end());
	int pos;
	for (int i = 0; i < N; i++) {
		for (int j = i + 1; j < N; j++) {
			pos = lower_bound(sol.begin(), sol.end(), -1 * (sol[i] + sol[j])) - sol.begin();
			// cout << sol[i] << ',' << sol[j] << ',' << sol[pos] << '\n';
			if (pos == N) pos = N - 1;
			int k = pos - 1;
			while (k == i || k == j) k--;
			if (k >= 0) check(i, j, k);
			k = pos;
			while (k == i || k == j) k++;
			if (k < N) check(i, j, k);
		}
	}
	sort(ans, ans + 3);
	for (int i = 0; i < 3; i++) cout << ans[i] << ' ';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
