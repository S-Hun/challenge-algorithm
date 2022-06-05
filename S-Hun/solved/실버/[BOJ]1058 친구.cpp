#include<iostream>
#include<string>
#include<vector>
#include<algorithm>

using namespace std;
int N;
vector<string> people;
vector<int> ans;

void init() {
	cin >> N;
	people.resize(N);
	ans.assign(N, 0);
	for (int i = 0; i < N; i++) cin >> people[i];
}

void solve() {
	for (int i = 0; i < N; i++) {
		for (int j = i+1; j < N; j++) {
			bool check = false;
			if (people[i][j] == 'Y') check = true;
			else {
				for (int k = 0; k < N; k++) {
					if (people[i][k] == 'Y' && people[k][j] == 'Y') {
						check = true;
						break;
					}
				}
			}
			if (check) { ans[i]++; ans[j]++; }
		}
	}
	cout << *max_element(ans.begin(), ans.end());
}

int main() {
	init();
	solve();
}