#include<iostream>
#include<vector>

using namespace std;
int N;
char shape[3500][7000];
char D[3][5] = {
	' ', ' ', '*', ' ', ' ',
	' ', '*', ' ', '*', ' ',
	'*', '*', '*', '*', '*'
};

void init() {
	cin >> N;
}

void recur(int n, int m, int h) {
	if (h == 3) {
		shape[n][m] = '*';
		shape[n + 1][m - 1] = '*';
		shape[n + 1][m + 1] = '*';
		for (int i = 0; i < 5; i++) shape[n + 2][m + i - 2] = '*';
		return;
	}
	int move = h / 2;
	recur(n, m, move);
	recur(n + move, m - move, move);
	recur(n + move, m + move, move);
}

void solve() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N + i; j++) {
			shape[i][j] = ' ';
		}
	}
	recur(0, N - 1, N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 2 * N - 1; j++) {
			if (shape[i][j] == '*') cout << '*';
			else cout << ' ';
		}
		if(i != N - 1) cout << '\n';
	}
}

int main() {
	init();
	solve();
}