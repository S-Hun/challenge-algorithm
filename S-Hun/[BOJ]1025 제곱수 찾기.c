#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<cmath>
#include<fstream>

using namespace std;
int N, M;
vector<vector<int>> table;

int main() {
	// 완전제곱수인지 검사 (int(ceil(sqrt(12321))) == int(sqrt(12321))) ? 1 : 0)
	// (int(sqrt(9)) * int(sqrt(9)) == 9) ? 1 : 0
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		table.push_back(vector<int>());
		string row;
		cin >> row;
		for (auto& e : row) {
			table[i].push_back(e - '0');
		}
	}
	int ans = -1;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			// 수열 진행중에 0 보다 작아지거나 M 또는 N 보다 크거나 같아지면 수열 중단
			// cout << "pos " << i << " " << j << endl;
			int temp = table[i][j], sum;
			for (int k = -N; k <= N; k++) {
				for (int l = -M; l <= M; l++) {
					int r = 0, c = 0;
					// cout << r << " " << l << endl;
					sum = 0;
					while (!(i + r < 0 || j + c < 0 || i + r >= N || j + c >= M)) {
						sum = sum * 10 + table[i + r][j + c];
						if ((int(sqrt(sum)) * int(sqrt(sum)) == sum) && ans < sum) ans = sum;
						if (k == 0 && l == 0) break;
						r += k; c += l;
					}
				}
			}
		}
	}
	cout << ans;
}