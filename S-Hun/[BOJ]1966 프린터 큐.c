#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std;
int tc;

void init() {
	cin >> tc;
}

void solution() {
	int docs, check_doc;
	queue<int> q;
	cin >> docs >> check_doc;
	int temp, cnt = 0;
	vector<int> imp;
	for (int i = 0; i < docs; i++) {
		cin >> temp;
		q.push(temp);
		imp.push_back(temp);
	}
	sort(imp.begin(), imp.end());
	while (!q.empty()) {
		//cout << imp.top() << "," << q.front() << " ";
		if (imp.back() == q.front()) {
			q.pop();
			imp.pop_back();
			++cnt;
			if (check_doc == 0) {
				cout << cnt << "\n";
				break;
			}
			else check_doc--;
		}
		else {
			if (check_doc == 0) {
				check_doc = q.size();
			}
			check_doc--;
			q.push(q.front());
			q.pop();
		}
	}
	return;
}

int main() {
	init();
	for (int i = 0; i < tc; i++) {
		solution();
	}
}