#include<iostream>
#include<vector>
#include<queue>
#include<string>

using namespace std;
int N, L;

void init() {
	cin >> N >> L;
}

void solve() {
	for (int i = L; i <= 100; i++) {
		int K = (i - 1) * i / 2;
		if ((N - K) % i == 0) {
			int tmp = (N - K) / i;
			if (tmp < 0) continue;
			for (int j = 0; j < i; j++) {
				cout << tmp + j << ' ';
			}
			return;
		}
	}
	cout << -1;
}

int main() {
	init();
	solve();
}