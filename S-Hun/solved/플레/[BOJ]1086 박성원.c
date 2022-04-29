#include<iostream>
#include<string>
#include<vector>

using namespace std;
typedef long long ll;
const int max_bit = 1 << 15;
const int max_div = 101;
int target_bit;
ll n, k;
vector<string> nums;
ll dp[max_bit][max_div];
ll cache_mod[15];
ll cache_len[15];

string pow10(int s) {
	string ans{ "1" };
	for (int i = 0; i < s; i++) {
		ans.push_back('0');
	}
	return ans;
}

ll mod(string num, ll div) {
	int idx = 0; ll temp = 0;
	while (idx < num.size() && temp < div) {
		temp = temp * 10 + (num[idx++] - '0');
	}

	while (idx < num.size()) {
		temp = (temp % div) * 10 + num[idx++] - '0';
	}

	temp = (temp % div);

	return temp;
}

void input() {
	cin >> n;
	nums.resize(n);
	target_bit = (1 << n) - 1;
	for (int i = 0; i < n; i++) {
		cin >> nums[i];
	}
	cin >> k;
	for (int i = 0; i < n; i++) {
		cache_mod[i] = mod(nums[i], k);
		cache_len[i] = mod(pow10(nums[i].size()), k);
	}
}

ll gcd(ll a, ll b) {
	ll temp;
	while (b != 0) {
		temp = a % b;
		a = b;
		b = temp;
	}
	return a;
}

void solution() {
	for (int j = 0; j < n; j++) {
		dp[1 << j][cache_mod[j]] = 1;
	}

	for (int i = 1; i < target_bit; i++) {
		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) continue;
			int bit_res = i | (1 << j);
			for (int m = 0; m < k; m++) {
				if (dp[i][m] == 0) continue;
				int mod_res = ((m * (cache_len[j] % k)) % k + cache_mod[j]) % k;
				dp[bit_res][mod_res] += dp[i][m];
			}
		}
	}
	/*
	for (int i = 1; i <= target_bit; i++) {
		for (int m = 0; m < k; m++) {
			cout << '[' << i << "," << m << "] == " << dp[i][m] << '\n';
		}
	}
	*/
	ll numerator = dp[target_bit][0];
	ll denominator = 1;
	for (int i = 2; i <= n; i++) {
		ll fact = i;
		ll com_gcd = gcd(numerator, fact);
		numerator /= com_gcd;
		fact /= com_gcd;
		denominator *= fact;
	}
	cout << numerator << '/' << denominator;
}

int main() {
	input();
	solution();
}