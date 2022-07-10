#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
int N;
const int inf = 1'000'000'000;
vector<int> rc[2];
int dp[501][501];

void init() {
    cin >> N;
    rc[0].resize(N);
    rc[1].resize(N);
    for (int i = 0; i < N; i++) {
        cin >> rc[0][i] >> rc[1][i];
    }
}

void solve() {
    for (int i = 1; i < N; i++) {
        for (int j = 0; i + j < N; j++) {
            dp[j][i + j] = inf;
            for (int k = j; k <= i + j; k++) {
                dp[j][i + j] = min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + rc[0][j] * rc[1][k] * rc[1][i + j]);
            }
        }
    }
    cout << dp[0][N - 1];
}

int main()
{
    init();
     solve();
}