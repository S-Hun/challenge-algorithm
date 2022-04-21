#include<iostream>
#include<queue>

using namespace std;

int main() {
	queue<int> q;
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) q.push(i);
	int cond = 1;
	while (q.size() != 1) {
		if (cond == 1) {
			q.pop();
			cond = 2;
		}
		else if (cond == 2) {
			q.push(q.front());
			q.pop();
			cond = 1;
		}
	}
	cout << q.front();
}