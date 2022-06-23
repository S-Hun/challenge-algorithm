#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;
typedef long long ll;
ll A, B;
struct elem {
	ll T;
	ll value;
};

void init(){
	cin >> A >> B;
}

void solve() {
	ll ans = -1;
	queue<elem> q;
	q.push({ 1, A });
	while (!q.empty()) {
		elem cur = q.front();
		q.pop();
		if (cur.value == B) {
			ans = cur.T;
			break;
		}

		if (cur.value * 2 <= B) q.push({ cur.T + 1, cur.value * 2 });
		if (cur.value * 10 + 1 <= B) q.push({ cur.T + 1, cur.value * 10 + 1 });
	}
	cout << ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
