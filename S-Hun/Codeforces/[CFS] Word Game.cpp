#include<iostream>
#include<string>
#include<map>
#include<vector>

using namespace std;
int TC, N;
map<string, int> m;
vector<string> list[3];

void init() {
	cin >> N;
	m = map<string, int>();
	string tmp;
	for (int i = 0; i < 3; i++) {
		list[i].clear();
		for (int j = 0; j < N; j++) {
			cin >> tmp;
			m[tmp] += 1;
			list[i].emplace_back(tmp);
		}
	}
}

void solve() {
	int value;
	for (int i = 0; i < 3; i++) {
		value = 0;
		for (auto& s : list[i]) {
			switch (m[s]) {
			case 1:
				value += 3;
				break;
			case 2:
				value += 1;
				break;
			}
		}
		cout << value << ' ';
	}
	cout << '\n';
}

int main() {
	cin >> TC;
	while (TC--) {
		init();
		solve();
	}
}