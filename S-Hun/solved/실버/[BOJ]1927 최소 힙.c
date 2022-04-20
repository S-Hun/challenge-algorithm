#include<iostream>
#include<queue>
#include<algorithm>

using namespace std;
int n;
priority_queue<int, vector<int>, greater<>> q;

void input() {
	cin >> n;
}

void solution() {
	int command;
	for (int i = 0; i < n; i++) {
		cin >> command;
		if (command == 0) {
			if (q.empty()) {
				cout << 0 << '\n';
			}
			else {
				cout << q.top() << '\n';
				q.pop();
			}
		}
		else {
			q.push(command);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	input();
	solution();
}