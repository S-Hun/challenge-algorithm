#include<iostream>
#include<string>

using namespace std;
int n;
bool map[65][65];

void input() {
	cin >> n;
	string s;
	for (int i = 0; i < n; i++) {
		cin >> s;
		for (int j = 0; j < n; j++) {
			map[i][j] = (s[j] == '1') ? true : false;
		}
	}
}

string dfs(int x, int y, int sz) {
	if (sz == 0) return "";
	int cnt0 = 0, cnt1 = 0;
	for (int i = y; i < y + sz; i++) {
		for (int j = x; j < x + sz; j++) {
			if (map[i][j]) cnt1 += 1;
			else cnt0 += 1;
		}
	}
	if (cnt0 == 0) return "1";
	else if(cnt1 == 0) return "0";
	else {
		int half = sz / 2;
		return "(" +
			dfs(x, y, half) +
			dfs(x + half, y, half) +
			dfs(x, y + half, half) +
			dfs(x + half, y + half, half) + 
			+")";
	}
}

void solution() {
	cout << dfs(0, 0, n);
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	input();
	solution();
}