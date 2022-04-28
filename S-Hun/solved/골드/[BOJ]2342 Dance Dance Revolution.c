#include<iostream>
#include<vector>

using namespace std;
int dp[100001][5][5];
vector<int> steps;

void init() {
	int n;
	cin >> n;
	while (n != 0) {
		steps.push_back(n);
		cin >> n;
	}
}

int move(int s, int e) {
	if (s == e) return 1;
	switch (s) {
	case 0: return 2;
	case 1: return (e == 3) ? 4 : 3;
	case 2: return (e == 4) ? 4 : 3;
	case 3: return (e == 1) ? 4 : 3;
	case 4: return (e == 2) ? 4 : 3;
	}
}

int calc(int n, int l, int r) {
	if (n == steps.size()) return 0;
	int& sum = dp[n][l][r];
	if (sum != 0) return sum;
	return sum = min(move(l, steps[n]) + calc(n + 1, steps[n], r)
		, move(r, steps[n]) + calc(n + 1, l, steps[n]));
}

void solution() {
	cout << calc(0, 0, 0);
}

int main() {
	init();
	solution();
}