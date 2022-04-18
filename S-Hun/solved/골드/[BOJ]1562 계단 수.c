#include<iostream>

using namespace std;
typedef long long ll;
int n;
ll stair_dp[101][10][1 << 10];
ll sdiv = 1'000'000'000;

void init() {
	cin >> n;
}

void dp() {
	for (int i = 1; i <= 9; i++) {
		stair_dp[1][i][1 << i] = 1;
	}
	
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= 9; j++) {
			for (int k = 0; k < (1 << 10); k++) {
				ll left = (j >= 1) ? stair_dp[i - 1][j - 1][k] : 0;
				ll right = (j <= 8) ? stair_dp[i - 1][j + 1][k] : 0;
				stair_dp[i][j][k | 1 << j] += (left + right) % sdiv;
			}
		}
	}
}

void solution() {
	dp();
	ll sum = 0;
	for (int i = 0; i <= 9; i++) {
		sum = (sum + stair_dp[n][i][(1 << 10) - 1]) % sdiv;
	}
	cout << sum;
}

int main() {
	init();
	solution();
}