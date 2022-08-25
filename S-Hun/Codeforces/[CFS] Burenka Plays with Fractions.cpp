#include<iostream>

using namespace std;
typedef long long ll;
ll TC, a, b, c, d;

void init() {
	cin >> a >> b >> c >> d;
}

void solve() {
	ll t1 = a * d, t2 = b * c;
	if (t1 == 0 && t2 == 0) cout << 0;
	else if (t1 == 0 || t2 == 0) cout << 1;
	else if (t1 % t2 != 0 && t2 % t1 != 0) cout << 2;
	else if (t1 % t2 != 0 || t2 % t1 != 0) cout << 1;
	else cout << 0;
	cout << '\n';
}

int main() {
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}