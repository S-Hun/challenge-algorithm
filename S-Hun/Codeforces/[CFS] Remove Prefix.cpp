#include<iostream>
#include<cstring>

using namespace std;
int TC, N, ANS;
bool temp[200'001];
int arr[200'001];

void init() {
	cin >> N;
	ANS = 0;
	memset(temp, false, sizeof(bool) * 200'001);
	for (int i = 0; i < N; i++) cin >> arr[i];
}

void solve() {
	for (int i = N - 1; i >= 0; i--) {
		if (temp[arr[i]]) {
			ANS = i + 1;
			break;
		}
		temp[arr[i]] = true;
	}
	cout << ANS << '\n';
}

int main() {
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}