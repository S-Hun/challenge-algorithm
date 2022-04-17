#include<iostream>
#include<vector>
#include<string>

using namespace std;
typedef long long ll;
const int MAX = 2510;

int n;
vector<vector<ll>> dp1;
vector<ll> dp2;
string str;


void init() {
	cin >> str; 
	n = str.size(); 
	str = '#' + str;
	dp1.assign(MAX, vector<ll>(MAX, -1));
	dp2.assign(MAX, 0x3f);
}

int isPal(int st, int ed) {
	ll& res = dp1[st][ed];
	if (res != -1) return res;
	if (st >= ed) return 1;
	if (str[st] != str[ed]) return res = 0;
	return res = isPal(st + 1, ed - 1);
}

void solution() {
	dp2[0] = 0;
	for (int i = 1; i <= n; i++) {
		dp2[i] = dp2[i - 1] + 1;
		for (int j = 1; j < i; j++) {
			if (!isPal(j, i)) continue;
			dp2[i] = min(dp2[i], dp2[j - 1] + 1);
		}
	}
	cout << dp2[n];
}

int main() {
	init();
	solution();
}