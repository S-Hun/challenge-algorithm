#include<iostream>
#include<vector>
#include<string>
#include<cmath>

using namespace std;
int R, C;
vector<string> graph;
int dpLB[750][750], dpRB[750][750], dpLU[750][750], dpRU[750][750];

void pre_process() {
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (graph[i][j] == '1') {
				dpRB[i][j] = (i > 0 && j > 0) ? 1 + dpRB[i-1][j-1] : 1;
				dpLB[i][j] = (i > 0 && j < C - 1) ? 1 + dpLB[i - 1][j + 1] : 1;
			}
			if (graph[(R - 1) - i][(C - 1) - j] == '1') {
				dpRU[(R - 1) - i][(C - 1) - j] = (i > 0 && j < C - 1) ? 1 + dpRU[R - i][(C - 2) - j] : 1;
				dpLU[(R - 1) - i][(C - 1) - j] = (i > 0 && j > 0) ? 1 + dpLU[R - i][C - j] : 1;
			}
		}
	}
	/*for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cout << dpRB[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cout << dpLB[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cout << dpRU[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cout << dpLU[i][j] << " ";
		}
		cout << endl;
	}*/
}

int solution() {
	int ans = 0;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			int size = min(dpRU[i][j], dpLU[i][j]);
			for (int s = ans + 1; s <= size; s++) {
				int endpoint = i + (s - 1) * 2;
				if (endpoint < R 
					&& min(dpRB[endpoint][j], dpLB[endpoint][j]) >= s) {
					ans = max(ans, s);
				}
			}
		}
	}
	return ans;
}

int main() {
	cin >> R >> C;
	string temp;
	for (int i = 0; i < R; i++) {
		cin >> temp;
		graph.push_back(temp);
	}
	pre_process();
	cout << solution();
}

//int check(vector<string>& g, int x, int y, int k) {
//	for (int i = 1; i < k; i++) {
//		// cout << 1 << " " << i << endl;
//		if (g[y + i][x + i] == '0' || g[y + i][x - i] == '0') return false;
//	}
//	for (int i = 0; i < k - 1; i++) {
//		 // cout << 2 << " " << i << " " << x + i << " " << y + (2 * k - 2) - i << endl;
//		if (g[y + (2 * k - 2) - i][x + i] == '0' || g[y + (2 * k - 2) - i][x - i] == '0') return false;
//	}
//	return true;
//}
//
//int main() {
//	cin >> R >> C;
//	string temp;
//	for (int i = 0; i < R; i++) {
//		cin >> temp;
//		graph.push_back(temp);
//	}
//	int num_max = 0;
//	for (int i = 1; i*2-1 <= int(min(R, C)); i++) {
//		bool exist = false;
//		for (int j = 0; j <= R - (i*2-1); j++) {
//			for (int k = i - 1; k <= C - i; k++) {
//				if (graph[j][k] == '1' && check(graph, k, j, i)) {
//					// cout << i << " okay" << endl;
//					exist = true;
//					num_max = i;
//					break;
//				}
//			}
//			if (exist) break;
//		}
//	}
//	cout << num_max;
//}