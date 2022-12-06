#include<iostream>
#include<queue>
#include<vector>
#include<string>

using namespace std;

int main() {
	int N, K;
	cin >> N >> K;
	queue<int> nums;
	for (int i = 1; i <= N; i++) nums.push(i);

	vector<int> ans;
	int cnt = K;
	while (!nums.empty()) {
		int num = nums.front();
		nums.pop();
		cnt -= 1;

		if (cnt == 0) {
			ans.push_back(num);
			cnt = K;
		}
		else nums.push(num);
	}

	printf("<%d", ans[0]);
	for (int i = 1; i < ans.size(); i++) printf(", %d", ans[i]);
	printf(">");
}