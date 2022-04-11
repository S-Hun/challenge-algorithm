#include<iostream>
#include<string>
#include<vector>
#include<deque>
#include<cmath>

using namespace std;
bool broken[10];
vector<int> numbers;
int N, M, small_max = -101, large_min = 1'000'010;

int length(int n) {
	int cnt = 1;
	while (n >= 10) {
		cnt++;
		n /= 10;
	}
	return cnt;
}

void init() {
	cin >> N >> M;
	int num;
	for (int i = 0; i < M; i++) {
		cin >> num;
		broken[num] = true;
	}
	for (int i = 0; i <= 9; i++) {
		if (!broken[i]) numbers.push_back(i);
	}
}

void dfs(int cur, int target) {
	if (target == 0) return;
	int temp;
	for (auto& n : numbers) {
		if (cur == 0 && n == 0) continue;
		temp = cur * 10 + n;
		cout << temp << " ";
		if (temp <= N) small_max = temp;
		if (temp >= N && large_min > temp) {
			large_min = temp;
			return;
		}
		dfs(temp, target-1);
	}
}

void solution() {
	vector<int> arr; int len = 1, sz = numbers.size(), num;
	if (sz != 0) {
		arr.push_back(0);
		do {
			num = 0;
			for (auto& v : arr) num = num * 10 + numbers[v];
			cout << num << " ";
			if (num <= N) small_max = num;
			if (num >= N) {
				large_min = num;
			}
			arr[len - 1] += 1;
			for (int i = len - 1; i >= 0; i--) {
				if (arr[i] == sz) {
					if (i == 0) {
						arr[i] = 0;
						arr.insert(arr.begin(), (numbers[0] == 0)? 1 : 0);
						if (sz <= 1 && numbers[0] == 0) num = N + 1;
						len++;
						break;
					}
					else {
						arr[i - 1] += 1;
						arr[i] = 0;
					}
				}
			}
		} while (num <= N);
	}
	int ans = min(abs(100 - N), min(N - small_max + length(small_max), large_min - N + length(large_min)));
	cout << ans;
}

int main() {
	init();
	solution();
}