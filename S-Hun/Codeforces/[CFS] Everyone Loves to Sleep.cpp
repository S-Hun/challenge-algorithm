#include<iostream>
#include<algorithm>

using namespace std;
int TC, n, sh, sm, h, m;
int time_diff = 0;

void init() {
	cin >> n >> sh >> sm;
	time_diff = 24 * 60;
}

int TtoM(int h, int m) {
	return h * 60 + m;
}

int cal_diff(int h, int m) {
	int result_start = TtoM(sh, sm);
	int result_alarm = TtoM(h, m);
	if (result_start > result_alarm) {
		return 24 * 60 - result_start + result_alarm;
	}
	else {
		return result_alarm - result_start;
	}
}

void solve() {
	while (n--) {
		cin >> h >> m;
		time_diff = min(time_diff, cal_diff(h, m));
	}
	cout << time_diff / 60 << ' ' << time_diff % 60 << '\n';
}

int main() {
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}