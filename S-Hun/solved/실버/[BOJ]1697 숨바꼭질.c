#include<iostream>
#include<cstdlib>
#include<queue>
#include<limits>
#include<vector>

using namespace std;
int N, K;
const int max_pos = 100'000;
vector<int> dp(max_pos+1, numeric_limits<int>::max());
queue<int> q;

void init() {
	cin >> N >> K;
}

int main() {
	init();
	q.push(N);
	dp[N] = 0;
	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		// cout << cur << " dist:" << dp[cur] << endl;
		if (cur == K) { cout << dp[cur]; break; }
		if (cur + 1 <= max_pos && dp[cur + 1] > dp[cur] + 1) {
			dp[cur + 1] = dp[cur] + 1;
			q.push(cur + 1);
		}
		if (cur - 1 >= 0 && dp[cur - 1] > dp[cur] + 1) {
			dp[cur - 1] = dp[cur] + 1;
			q.push(cur - 1);
		}
		if (cur * 2 <= max_pos && dp[cur * 2] > dp[cur] + 1) {
			dp[cur * 2] = dp[cur] + 1;
			q.push(cur * 2);
		}
	}
}