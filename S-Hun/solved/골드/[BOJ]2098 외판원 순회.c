#include<iostream>

using namespace std;
int bit_max, cmin = 17'000'001, n;
const int inf = 17'000'001;
int dp[16][1 << 16];
int graph[16][16];

void input() {
	cin >> n;
	bit_max = (1 << n) - 1;
	int temp;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> temp;
			graph[i][j] = temp;
		}
	}
}

int dfs(int pos, int stat) {
	if (stat == bit_max) {
		if (graph[pos][0] == 0) return inf;
		else return graph[pos][0];
	}

	if (dp[pos][stat] != 0) return dp[pos][stat];
	
	dp[pos][stat] = inf;
	for (int i = 1; i < n; i++) {
		if (graph[pos][i] != 0 && (stat & (1 << i)) == 0) {
			int next = stat | (1 << i);
			dp[pos][stat] = min(dp[pos][stat], graph[pos][i] + dfs(i, next));
		}
	}
	return dp[pos][stat];
}

/* 
// 둘다 Bottom-Up 방식이지만, 
// 이 방식은 쓸데없는 탐색회수가 더 많을 수 있다.
// 위 방식은 n^2이지만, 이 방식은 n^3에 가까울 수 있다.
void calc(int pos, int stat) {
	if (stat == bit_max) {
		if (graph[pos][0] != 0) {
			cmin = min(cmin, dp[pos][stat] + graph[pos][0]);
		}
		return;
	}
	for (int i = 1; i < n; i++) {
		if (graph[pos][i] != 0 && (stat & (1 << i)) == 0) {
			int next = stat | (1 << i);
			if (dp[i][next] == 0 || dp[i][next] > dp[pos][stat] + graph[pos][i]) {
				dp[i][next] = dp[pos][stat] + graph[pos][i];
				calc(i, next);
			}
		}
	}
}
*/

void solution() {
	cout << dfs(0, 1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	input();
	solution();
}