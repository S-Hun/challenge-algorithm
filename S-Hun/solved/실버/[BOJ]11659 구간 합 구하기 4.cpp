#include<iostream>
#include<vector>

using namespace std;
int n, m;
vector<int> v;
vector<int> segtree;

int gen_seg(int s, int e, int idx) {
	if (e - s == 0) {
		segtree[idx] = v[s];
		return segtree[idx];
	}
	else {
		int mid = (s + e) / 2;
		segtree[idx] = gen_seg(s, mid, 2 * idx + 1) + gen_seg(mid + 1, e, 2 * idx + 2);
		return segtree[idx];
	}
}

int sum_seg(int s, int e, int ts, int te, int idx) {
	if (ts <= s && e <= te) return segtree[idx];
	else if (te < s || e < ts) return 0;
	else {
		int mid = (s + e) / 2;
		return sum_seg(s, mid, ts, te, 2 * idx + 1) + sum_seg(mid + 1, e, ts, te, 2 * idx + 2);
	}
}

void init() {
	cin >> n >> m;
	v.resize(n);
	for (int i = 0; i < n; i++) cin >> v[i];
	segtree.resize(n * 4);
	gen_seg(0, n - 1, 0);
}

void solve() {
	int s, e;
	for (int i = 0; i < m; i++) {
		cin >> s >> e;
		cout << sum_seg(0, n - 1, s - 1, e - 1, 0) << '\n';
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}