#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int N, M;
vector<vector<int>> S;

void init(){
	cin >> N >> M;
	int value;
	S.resize(N, vector<int>(N, 0));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> value;
			if (i == 0 && j == 0) S[0][0] = value;
			else if (i == 0) S[0][j] = S[0][j - 1] + value;
			else if (j == 0) S[i][0] = S[i - 1][0] + value;
			else S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i - 1][j - 1] + value;
		}
	}
} 

void solve() {
	int x1, y1, x2, y2;
	for (int i = 0; i < M; i++) {
		cin >> x1 >> y1 >> x2 >> y2;
		x1--;
		y1--;
		x2--;
		y2--;
		int ans;
		if (x1 == 0 && y1 == 0) ans = S[x2][y2];
		else if (x1 == 0) ans = S[x2][y2] - S[x2][y1 - 1];
		else if (y1 == 0) ans = S[x2][y2] - S[x1 - 1][y2];
		else ans = S[x2][y2] - S[x2][y1 - 1] - S[x1 - 1][y2] + S[x1 - 1][y1 - 1];
		cout << ans << '\n';
	}
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
