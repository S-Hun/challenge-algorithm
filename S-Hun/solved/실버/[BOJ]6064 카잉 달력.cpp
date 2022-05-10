#include<iostream>
#include<cmath>

using namespace std;
int tc, M, N, x, y;

void init() {
	cin >> M >> N >> x >> y;
}

int gcd(int a, int b) {
	while (b != 0) {
		int temp = a % b;
		a = b;
		b = temp;
	}
	return a;
}

int lcm(int a, int b) {
	return a * b / gcd(a, b);
}

int solve() {
	int max_diff = abs(M-N);
	int diff = x-y;
	if (M < N) {
		swap(M, N);
		swap(x, y);
	}
	for (int i = x; i <= lcm(M, N); i += M) {
		int temp = (i % N) ? i % N : N;
		if (temp == y) {
			return i;
		}
	}
	return -1;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> tc;
	while (tc--) {
		init();
		cout << solve() << '\n';
	}
}
