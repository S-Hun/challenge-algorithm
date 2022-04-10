#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
typedef long long ll;
vector<ll> v;
vector<ll> s;

int main() {
	int n;
	cin >> n;
	for (int i = 0; i <= 9; i++) {
		v.push_back(i);
		s.push_back(i);
	}

	while (!s.empty()) {
		ll X = s.back();
		s.pop_back();

		for (int i = 0; i <= 9; i++) {
			if (X % 10 > i) {
				v.push_back(X * 10 + i);
				s.push_back(X * 10 + i);
			}
			else break;
		}
	}
	sort(v.begin(), v.end());
	if (v.size() <= n) cout << -1;
	else cout << v[n];
}