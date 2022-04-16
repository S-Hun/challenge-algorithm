#include<iostream>
#include<vector>
#include<map>

using namespace std;
map<int, int> mp;
int n, k;
vector<int> arr;
long long ans;

void init() {
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int t;
		cin >> t;
		arr.push_back(t);
	}
	ans = 0;
}

void ldfs(int cnt, int sum) {
	if (cnt == n/2) {
		mp[sum] += 1;
		return;
	}
	ldfs(cnt + 1, sum + arr[cnt]);
	ldfs(cnt + 1, sum);
}

void rdfs(int cnt, int sum) {
	if (cnt == n) {
		ans += mp[k - sum];
		return;
	}
	rdfs(cnt + 1, sum + arr[cnt]);
	rdfs(cnt + 1, sum);
}

void solution() {
	ldfs(0, 0);
	rdfs(n / 2, 0);
	if (k == 0) ans -= 1; // 아무것도 포함안했을 때 제외
	cout << ans;
}

int main() {
	init();
	solution();
}