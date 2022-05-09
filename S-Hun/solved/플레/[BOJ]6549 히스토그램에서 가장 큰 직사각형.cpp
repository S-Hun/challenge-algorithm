#include<iostream>
#include<deque>
#include<vector>

using namespace std;
int n;
long long max_area = 0;
vector<int> hist;
deque<int> s;

int init() {
	max_area = 0;
	cin >> n;
	if (n == 0) return false;
	hist.resize(n);
	for (int i = 0; i < n; i++) cin >> hist[i];
	return true;
}

void solve() {
	for (int i = 0; i < n; i++) {
		while (!s.empty() && hist[s.back()] >= hist[i]) {
			int cur_index = s.back();
			s.pop_back();
			if (s.empty()) max_area = max(max_area, (long long)i * hist[cur_index]);
			else max_area = max(max_area, (long long)(i - 1 - s.back()) * hist[cur_index]);
		}
		s.push_back(i);
	}
	while (!s.empty()) {
		int cur_index = s.back();
		s.pop_back();
		if(s.empty()) max_area = max(max_area, (long long)n * hist[cur_index]);
		else max_area = max(max_area, (long long)(n - 1 - s.back()) * hist[cur_index]);
	}
	cout << max_area << '\n';
}

int main() {
	while (init()) {
		solve();
	}
}
