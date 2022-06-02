#include<iostream>

using namespace std;
typedef long long ll;
ll S;

void init() {
	cin >> S;
}

void solve() {
	ll i, sum = 0;
	for (i = 1; sum + i <= S; i++) sum += i;
	cout << i - 1;
}

int main() {
	init();
	solve();
}