#include<iostream>

using namespace std;
int n;
const int MOD = 9901;
int dp[100'001][3];

void init() {
    cin >> n;
    dp[1][0] = 1;
    dp[1][1] = 1;
    dp[1][2] = 1;
}

void solve() {
    for (int i = 2; i <= n; i++) {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
    }
    cout << (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
}

int main()
{
    init();
    solve();
}