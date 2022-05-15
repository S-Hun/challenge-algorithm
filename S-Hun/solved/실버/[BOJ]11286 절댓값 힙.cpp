#include<iostream>
#include<queue>
#include<cmath>
#include<vector>

using namespace std;
int n;

struct cmp {
	bool operator()(int a, int b) {
		if (abs(a) == abs(b)) return a > b;
		else return abs(a) > abs(b);
	}
};

void init() {
	cin >> n;
}

void solve() {
	priority_queue<int, vector<int>, cmp> pq;
	int com;
	for (int i = 0; i < n; i++) {
		cin >> com;
		if (com == 0) {
			if (pq.empty()) cout << "0\n";
			else {
				cout << pq.top() << '\n';
				pq.pop();
			}
		}
		else {
			pq.push(com);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}