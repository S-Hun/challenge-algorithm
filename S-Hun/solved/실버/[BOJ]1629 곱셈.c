#include<iostream>
#include<limits>

using namespace std;
typedef long long ll;
ll A, B, C;

void init() {
	cin >> A >> B >> C;
}

ll solution(ll a, ll b) {
	if (b == 0) return 1;
	if (b == 1) return a;
	if (b % 2 == 1) return solution(a, b - 1) * a;
	ll remain = solution(a, b / 2) % C;
	return (remain * remain) % C;
 }

int main() {
	init();
	cout << solution(A, B) % C;
}
