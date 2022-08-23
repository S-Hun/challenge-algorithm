#include<iostream>

using namespace std;
int TC, N;

void init() {
	cin >> N;
}

void solve() {
	int ans = 0;
	if (N >= 4 && (N - 4) % 3 == 0) ans -= 1;
	while (N != 0) {
		if (N == 1) {
			ans += 2;
			N = 0;
		}
		else if(N == 2) {
			ans += 1;
			N = 0;
		}
		else {
			ans += N / 3;
			N -= (N / 3) * 3;
		}
	}
	cout << ans << '\n';
}

int main() {
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}