#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
vector<int> v;

void init() {
	int n;
	while (cin >> n) {
		v.push_back(n);
	}
}

void pre2post(int s, int e) {
	if (s > e) {
		//cout << v[s] << '\n';
		return;
	}
	int l = s, r = e;
	/*while (true) {
		int mid = (l + r) / 2;
		if (mid == s || mid == e) {
			pre2post(s + 1, e);
			cout << v[s] << '\n';
			break;
		}
		else if (v[mid] < v[s] && v[mid + 1] > v[s]) {
			pre2post(s + 1, mid);
			pre2post(mid + 1, e);
			cout << v[s] << '\n';
			break;
		}
		if (v[mid] > v[s]) r = mid - 1;
		else if (v[mid + 1] < v[s]) l = mid + 1;
	}*/
	for (r = s + 1; r <= e; r++) {
		if (v[s] < v[r]) break;
	}
	if (r == s + 1 || r == e + 1) {
		pre2post(s + 1, e);
	}
	else {
		pre2post(s + 1, r - 1);
		pre2post(r, e);
	}
	cout << v[s] << '\n';
}

void solve() {
	pre2post(0, v.size() - 1);
}

int main() {
	init();
	solve();
}