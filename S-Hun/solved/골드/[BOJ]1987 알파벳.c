#include<iostream>
#include<queue>
#include<vector>
#include<utility>
#include<algorithm>
#include<cmath>
#include<string>
#include<map>

using namespace std;
int r, c, lmax = 0;
vector<string> arr;
map<char, int> visit;

void input() {
	cin >> r >> c;
	string temp;
	for (int i = 0; i < r; i++) {
		cin >> temp;
		arr.push_back(temp);
	}
}

void dfs(int x, int y, int l) {
	if (visit[arr[y][x]] == 0) {
		lmax = max(lmax, l + 1);
		visit[arr[y][x]] += 1;
		if (x > 0) dfs(x - 1, y, l + 1);
		if (y > 0) dfs(x, y - 1, l + 1);
		if (x < c - 1) dfs(x + 1, y, l + 1);
		if (y < r - 1) dfs(x, y + 1, l + 1);
		visit[arr[y][x]] -= 1;
	}
	else return;
}

void solution() {
	dfs(0, 0, 0);
	cout << lmax;
}

int main() {
	input();
	solution();
}