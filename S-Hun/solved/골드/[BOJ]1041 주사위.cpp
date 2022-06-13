#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int N;
int S[6];
enum dice { A, B, C, D, E, F };
long long min_sum3, min_sum2, min_surface;

void init() {
	cin >> N;
	for (int i = 0; i < 6; i++) cin >> S[i];
}

void solve() {
	min_surface = *min_element(S, S + 6);
	min_sum2 = min(S[E] + S[A], min(S[A] + S[B], min(S[B] + S[F], min(S[F] + S[E], min(S[D] + S[A], min(S[A] + S[C], min(S[C] + S[F], min(S[F] + S[D], min(S[D] + S[B], min(S[B] + S[C], min(S[C] + S[E], S[E] + S[D])))))))))));
	min_sum3 = min(S[D], S[C]) + min(S[E] + S[A], min(S[A] + S[B], min(S[B] + S[F], S[F] + S[E])));
	//cout << min_sum2 << " " << min_sum3 << '\n';
	long long ans = 0;	
	if (N == 1) {
		for (int i = 0; i < 6; i++) ans += S[i];
		ans -= *max_element(S, S + 6);
	}
	else {
		ans += (min_sum3 + min_sum2) * 4;
		ans += min_sum2 * (8 * (N - 2)) + min_surface * (4 * (N - 2));
		ans += min_surface * 5 * (N - 2) * (N - 2);
	}
	cout << ans;
}

int main() {
	init();
	solve();
}