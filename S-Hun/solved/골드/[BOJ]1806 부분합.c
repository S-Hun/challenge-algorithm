#include<iostream>
#include<queue>
#include<vector>
#include<utility>
#include<algorithm>
#include<cmath>

using namespace std;
int n, s;
vector<int> arr;

void input() {
	cin >> n >> s;
	int temp;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		arr.push_back(temp);
	}
}

void solution() {
	int l = 0, r = 0, sum = 0, ans = 100'001;
	while (r < n) {
		if (sum < s) {
			sum += arr[r++];
		}
		else if (sum >= s) {
			ans = min(ans, r - l);
			sum -= arr[l++];
		}
	}
	while (l < n) {
		if (sum >= s) ans = min(ans, r - l);
		sum -= arr[l++];
	}
	cout << ((ans == 100'001)? 0 : ans);
}

int main() {
	input();
	solution();
}