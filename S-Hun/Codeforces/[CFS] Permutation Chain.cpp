#include<iostream>
#include<vector>

using namespace std;
int TC, N;
vector<int> v;

void init() {
	v.clear();
	cin >> N;
	for (int i = 0; i < N; i++) v.push_back(i + 1);
}

void PRINT() {
	for (auto i : v) cout << i << ' ';
	cout << '\n';
}

void solve() {
	cout << N << '\n';
	PRINT();
	for (int i = 0; i < N - 1; i++) {
		int temp = v[i];
		v[i] = v[i + 1];
		v[i + 1] = temp;
		PRINT();
	}
}

int main() {
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}