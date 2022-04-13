#include<iostream>
#include<vector>

using namespace std;
typedef long long ll;
typedef vector<vector<ll>> matrix;
const ll mod = 1'000'000'007;

ll n;

matrix operator*(matrix& a, matrix& b) {
	matrix ret(2, vector<ll>(2, 0));
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 2; k++) {
				ret[i][j] += a[i][k] * b[k][j];
			}
			ret[i][j] %= mod;
		}
	}
	return ret;
}



int main() {
	cin >> n;

	vector<vector<long long>> ans = { {1,0}, {0,1} };
	vector<vector<long long>> a = { {1,1}, {1,0} };

	while (n > 0)
	{
		if (n % 2 == 1)
			ans = ans * a;
		a = a * a;
		n /= 2;
	}

	cout << ans[0][1] << "\n";
}