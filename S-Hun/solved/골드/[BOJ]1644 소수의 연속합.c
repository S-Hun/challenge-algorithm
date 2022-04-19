#include<iostream>
#include<vector>

using namespace std;
int n;
bool not_prime[10000001];
vector<int> prime;

void input() {
	cin >> n;
}

void cal_prime() {
	for (int i = 2; i * i<= n; i++) {
		if (!not_prime[i]) {
			for (int j = i * i; j <= n; j += i) {
				not_prime[j] = true;
			}
		}
	}
	for (int i = 2; i <= n; i++) {
		if (!not_prime[i]) prime.push_back(i);
	}
	// prime.push_back(0);
}

void solution() {
	cal_prime();
	//for (auto& i : prime) cout << i << " ";
	int left = 0, right = 0, sum = 0, ans = 0;
	while (right < prime.size()) {
		// cout << endl << left << " " << right;
		if (sum < n) {
			sum += prime[right++];
		}
		else if (sum >= n) {
			sum -= prime[left++];
		}
		if(sum == n) {
			ans += 1;
		}
	}
	while (left < prime.size()) {
		sum -= prime[left++];
		if (sum == n) {
			ans += 1;
		}
	}
	cout << ans;
}

int main() {
	input();
	solution();
}