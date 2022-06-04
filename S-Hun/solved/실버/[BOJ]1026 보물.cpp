#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
int N;
vector<int> A, B;

void init() {
	cin >> N;
	A.resize(N); B.resize(N);
	for (int i = 0; i < N; i++) cin >> A[i];
	for (int i = 0; i < N; i++) cin >> B[i];
	sort(A.begin(), A.end());
	sort(B.begin(), B.end(), greater<>());
}

void solve() {
	int ans = 0;
	for (int i = 0; i < N; i++) ans += A[i] * B[i];
	cout << ans;
}

int main() {
	init();
	solve();
}