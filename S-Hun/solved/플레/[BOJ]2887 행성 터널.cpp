#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<cmath>

using namespace std;
int N;
struct planet {
	int p, i;
	bool operator<(const planet& other) {
		if (this->p == other.p) return this->i < other.p;
		else return this->p < other.p;
	}
};
struct dist {
	int src, dst, len;
};
bool distComp(const dist& a, const dist& b) {
		return a.len < b.len;
}
vector<planet> x, y, z;
vector<int> parent;

int pfind(int i) {
	if (parent[i] == i) {
		return i;
	}
	else {
		return parent[i] = pfind(parent[i]);
	}
}

bool punion(int i, int j) {
	int r1 = pfind(i);
	int r2 = pfind(j);

	if (r1 == r2) return false;
	else { parent[r2] = r1; return true; };
}

void init() {
	cin >> N;
	parent.resize(N);
	int in[3];
	for (int i = 0; i < N; i++) {
		cin >> in[0] >> in[1] >> in[2];
		x.push_back({ in[0], i });
		y.push_back({ in[1], i });
		z.push_back({ in[2], i });
		parent[i] = i;
	}
	sort(x.begin(), x.end());
	sort(y.begin(), y.end());
	sort(z.begin(), z.end());
}

void solve() {
	int ans = 0;
	vector<dist> tunnels;
	for (int i = 1; i < N; i++) {
		tunnels.push_back({ x[i].i, x[i - 1].i, x[i].p - x[i - 1].p });
		tunnels.push_back({ y[i].i, y[i - 1].i, y[i].p - y[i - 1].p });
		tunnels.push_back({ z[i].i, z[i - 1].i, z[i].p - z[i - 1].p });
	}
	sort(tunnels.begin(), tunnels.end(), distComp);
	for (auto& tunnel : tunnels) {
		if (punion(tunnel.src, tunnel.dst)) ans += tunnel.len;
	}
	cout << ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
