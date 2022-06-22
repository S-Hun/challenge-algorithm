#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;
int N, K;
const int inf = 1'000'000'000;
int tim = inf, cnt = 0;
bool visit[100'001];
struct pos {
	int T;
	int P;
};

void init(){
	cin >> N >> K;
}

void solve() {
	queue<pos> q;
	q.push({ 0, N });

	while (!q.empty()) {
		pos cur = q.front();
		q.pop();

		visit[cur.P] = true;

		if (cur.T > tim) break;

		if (cur.P == K) {
			tim = cur.T;
			cnt++;
			continue;
		}

		if (cur.P - 1 >= 0 && !visit[cur.P - 1]) q.push({cur.T + 1, cur.P - 1});
		if (cur.P + 1 <= 100'000 && !visit[cur.P + 1]) q.push({ cur.T + 1, cur.P + 1 });
		if (cur.P * 2 <= 100'000 && !visit[cur.P * 2]) q.push({ cur.T + 1, cur.P * 2 });
		
	}
	cout << tim << '\n' << cnt;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
