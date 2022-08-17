#include<iostream>

using namespace std;
int W;

void init() {
	cin >> W;
}

void solve() {
	if (W == 2 || W & 1) cout << "NO";
	else cout << "YES";
}

int main() {
	init();
	solve();
}