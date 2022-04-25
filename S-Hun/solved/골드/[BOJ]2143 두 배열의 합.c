#include<iostream>
#include<unordered_map>
#include<vector>
#include<algorithm>

using namespace std;
typedef long long ll;
ll T, al, bl;
vector<ll> sum_a, sum_b;
unordered_map<ll, ll> sub_a;

vector<int> test1, test2;

void solution() {
	cin >> al;
	ll ans = 0;
	ll temp;
	sum_a.push_back(0);
	for (int i = 1; i <= al; i++) {
		cin >> temp;
		sum_a.push_back(sum_a[i - 1] + temp);
		for (int j = 0; j < i; j++) {
			sub_a[sum_a[i] - sum_a[j]] += 1;
			//test1.push_back(sum_a[i] - sum_a[j]);
		}
	}

	cin >> bl;
	sum_b.push_back(0);
	for (int i = 1; i <= bl; i++) {
		cin >> temp;
		sum_b.push_back(sum_b[i - 1] + temp);
		for (int j = 0; j < i; j++) {
			//test2.push_back(sum);
			ans += sub_a[T - (sum_b[i] - sum_b[j])];
		}
	}

	cout << ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	cin >> T;
	solution();
}