#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<cmath>

using namespace std;
int N, M;
vector<int> pcks;
vector<int> inds;

void init() {
	cin >> N >> M;
	pcks.resize(M);
	inds.resize(M);
	for (int i = 0; i < M; i++) cin >> pcks[i] >> inds[i];
}

void solve() {
	int ans = 0;
	int c_pck = min_element(pcks.begin(), pcks.end()) - pcks.begin();
	int c_ind = min_element(inds.begin(), inds.end()) - inds.begin();
	if (pcks[c_pck] > inds[c_ind] * 6) {
		ans = N * inds[c_ind];
	}
	else {
		ans = (N / 6) * pcks[c_pck];
		ans += min(pcks[c_pck], (N % 6) * inds[c_ind]);
	}
	cout << ans;
}

int main() {
	init();
	solve();
}