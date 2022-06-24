#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;
int N, K;
struct step {
	int time;
	int pos;
};

struct comp {
	bool operator()(step& a, step& b) {
		if (a.time == b.time) return a.pos > b.pos;
		else return a.time > b.time;
	}
};

bool visit[100'001];

void init() {
	cin >> N >> K;
}

void solve() {
	int ans = 0;
	priority_queue<step, vector<step>, comp> q;
	q.push({ 0, N });
	visit[N] = true;
	while (!q.empty()) {
		step cur = q.top();
		q.pop();

		if (cur.pos == K) {
			ans = cur.time;
			break;
		}

		if (cur.pos * 2 <= 100'000 && !visit[cur.pos * 2]) {
			q.push({ cur.time, cur.pos * 2 }); visit[cur.pos * 2] = true;
		}
		if (cur.pos + 1 <= 100'000 && !visit[cur.pos + 1]) {
			q.push({ cur.time + 1, cur.pos + 1 }); visit[cur.pos + 1] = true;
		}
		if (cur.pos - 1 >= 0 && !visit[cur.pos - 1]) {
			q.push({ cur.time + 1, cur.pos - 1 }); visit[cur.pos - 1] = true;
		}
	}
	cout << ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
