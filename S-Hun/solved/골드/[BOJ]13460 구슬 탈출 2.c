#include<iostream>
#include<string>
#include<vector>
#include<cmath>

using namespace std;
const int up = 0, right = 1, down = 2, left = 3;
int dir_val[4] = { -10, 1, 10, -1 };
int n, m, ans = 100;
int rs, bs;
string map;
// int dp[100][100];

long long test = 0;

void input() {
	cin >> n >> m;
	string temp;
	dir_val[0] = -m;
	dir_val[2] = m;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		map += temp;
		if (temp.find("R") != string::npos)  rs = i * m + temp.find("R");
		if (temp.find("B") != string::npos)  bs = i * m + temp.find("B");
	}
	map[rs] = '.'; map[bs] = '.';
}

void dfs(int n, int r, int b) {
	if (n >= 10) return;
	for (int i = 0; i < 4; i++) {
		int move_r = 0, move_b = 0;
		for (move_r = 0; map[r + move_r + dir_val[i]] == '.'; move_r += dir_val[i]);
		for (move_b = 0; map[b + move_b + dir_val[i]] == '.'; move_b += dir_val[i]);
		if (map[b + move_b + dir_val[i]] == 'O') continue;
		if (map[r + move_r + dir_val[i]] == 'O') {
			ans = min(ans, n + 1);
			return;
		}
		if (r + move_r == b + move_b) {
			if (abs(move_r) > abs(move_b)) move_r -= dir_val[i];
			else move_b -= dir_val[i];
		}
		if (r != r + move_r || b != b + move_b)	dfs(n + 1, r + move_r, b + move_b);
	}
}

void solution() {
	dfs(0, rs, bs);
	cout << ((ans == 100)? -1 : ans);
}

int main() {
	input();
	solution();
}