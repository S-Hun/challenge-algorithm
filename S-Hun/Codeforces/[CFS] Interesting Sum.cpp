#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int TC, N;
vector<int> arr;

void init() {
	cin >> N;
	arr.resize(N);
	for (int i = 0; i < N; i++) cin >> arr[i];
}

void solve() {
	sort(arr.begin(), arr.end());
	cout << arr[N - 1] + arr[N - 2] - arr[0] - arr[1] << '\n';
}

int main() {
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}