#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
typedef long long ll;
int n; ll m; ll umax = 0;
vector<ll> trees;

void input() {
	cin >> n >> m;
	trees.resize(n);
	for (int i = 0; i < n; i++) {
		cin >> trees[i];
		umax = max(umax, trees[i]);
	}
}

bool chop_get(ll height) {
	ll sum = 0;
	for (int i = 0; i < n; i++) {
		if (trees[i] > height) sum += trees[i] - height;
		if (sum >= m) return true;
	}
	return false;
}

void solution() {
	ll l = 0, r = umax, mid, ans = 0;
	while (l <= r) {
		mid = (l + r) / 2;
		if (chop_get(mid)) {
			ans = mid;
			l = mid + 1;
		}
		else r = mid - 1;
	}
	cout << ans;
}

int main() {
	input();
	solution();
}