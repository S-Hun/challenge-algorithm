#include<iostream>
#include<algorithm>

using namespace std;
int N;

void init() {
	cin >> N;
}

void solve() {
	int *S = new int[3];
	int *B = new int[3];
	int t[3];
	int input[3];
	for (int k = 0; k < 3; k++) { 
		cin >> input[k];
		S[k] = input[k];
		B[k] = input[k];
	}
	for (int i = 1; i < N; i++) {
		for (int k = 0; k < 3; k++) cin >> input[k];
		t[0] = min(S[0], S[1]) + input[0];
		t[1] = *min_element(S, S + 3) + input[1];
		t[2] = min(S[1], S[2]) + input[2];
		S[0] = t[0]; S[1] = t[1]; S[2] = t[2];
		t[0] = max(B[0], B[1]) + input[0];
		t[1] = *max_element(B, B + 3) + input[1];
		t[2] = max(B[1], B[2]) + input[2];
		B[0] = t[0]; B[1] = t[1]; B[2] = t[2];
	}
	cout << *max_element(B, B + 3) << ' ';
	cout << *min_element(S, S + 3);
}

int main() {
	init();
	solve();
}