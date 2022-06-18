#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int N;
const int MOD = 1'000;
long long B;
int matrix[5][5];
int ans[5][5];

void init(){
	cin >> N >> B;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> matrix[i][j];
			if (i == j) ans[i][j] = 1;
		}
	}
} 

void multi(int A[][5], long long step) {
	int temp[5][5];
	if (B > step) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) temp[i][j] = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				for (int k = 0; k < N; k++) temp[i][j] += (A[i][k] * A[k][j]) % MOD;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) temp[i][j] %= MOD;
		multi(temp, step * 2);
	}
	if (B >= step) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = ans[i][j];
				ans[i][j] = 0;
			}
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				for (int k = 0; k < N; k++) ans[i][j] += (temp[i][k] * A[k][j]) % MOD;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) ans[i][j] %= MOD;
		B -= step;
	}
}

void solve() {
	multi(matrix, 1);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << ans[i][j] << ' ';
		}
		cout << '\n';
	}
}

int main(void) {
	init();
	solve();
}
