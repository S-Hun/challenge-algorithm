#include<iostream>
#include<deque>
#include<string>

using namespace std;
deque<int> q;
int tc, n;
string com;

void init() {
	string s;
	int v = 0;
	cin >> com >> n >> s;
	q.clear();
	for (auto& c : s) {
		if (isdigit(c)) {
			v = v * 10 + c - '0';
		}
		else if (v != 0) {
			q.push_back(v);
			v = 0;
		}
	}
}

void solve() {
	enum class DIR { front, back };
	DIR dir{DIR::front};
	for (auto& c : com) {
		if (c == 'R') dir = (dir == DIR::front) ? DIR::back : DIR::front;
		else {
			if (dir == DIR::front) {
				if (q.empty()) goto EXIT;
				else q.pop_front();
			}
			else {
				if (q.empty()) goto EXIT;
				else q.pop_back();
			}
		}
	}
	if (q.empty()) cout << "[]\n";
	else if (dir == DIR::front) {
		cout << '[' << *q.begin();
		for (auto it = next(q.begin()); it != q.end(); it++) {
			cout << ',' << *it;
		}
		cout << "]\n";
	}
	else {
		cout << '[' << *q.rbegin();
		for (auto it = next(q.rbegin()); it != q.rend(); it++) {
			cout << ',' << *it;
		}
		cout << "]\n";
	}
	return;
EXIT:
	cout << "error\n";
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	cin >> tc;
	while (tc--) {
		init();
		solve();
	}
}