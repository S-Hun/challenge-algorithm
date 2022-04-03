#include<iostream>
#include<vector>
#include<algorithm>
#include<set>

using namespace std;

int main() {
	int L, n;
	vector<int> S;
	cin >> L;
	for (int i = 0; i < L; i++) {
		cin >> n;
		S.push_back(n);
	}
	cin >> n;
	int right, left, sum = 0;
	sort(S.begin(), S.end());
	for (int i = 0; i < L; i++) {
		if (S[i] == n) {
			cout << 0;
			return 0;
		}
		else if (S[i] > n) {
			right = S[i];
			if (i == 0) left = 0;
			else left = S[i - 1];
			sum = right - n;
			sum = (sum - 1) + (n - left - 1) * sum;
			cout << sum;
			return 0;
		}
	}
}