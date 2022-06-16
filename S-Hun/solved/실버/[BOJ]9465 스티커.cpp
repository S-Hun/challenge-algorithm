#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int N;
vector<int> sticker[2];
vector<int> dp[2];

void init(){
	cin >> N;
	for (int i = 0; i < 2; i++) { 
		sticker[i].resize(N); 
		dp[i].resize(N, 0);
	}
	for (int j = 0; j < N; j++) cin >> sticker[0][j];
	for (int j = 0; j < N; j++) cin >> sticker[1][j];
} 

void solve() {        
	dp[0][0] = sticker[0][0];
	dp[1][0] = sticker[1][0];
	if (N >= 2) {
		dp[0][1] = dp[1][0] + sticker[0][1];
		dp[1][1] = dp[0][0] + sticker[1][1];
	}
	if (N >= 3) {
		for (int i = 2; i < N; i++) {
			dp[0][i] = sticker[0][i] + max(dp[1][i - 2], dp[1][i - 1]);
			dp[1][i] = sticker[1][i] + max(dp[0][i - 2], dp[0][i - 1]);
		}
	}
	cout << max(dp[0][N - 1], dp[1][N - 1]) << '\n';
}

int main(void) {
	int TC;
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}
