#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main() {
	int tc, n;
	string polycarp;
	string ans;
	cin >> tc;
	int num = 0, cnt = 0;
	while (tc--) {
		ans = "";
		int num = 0;
		cin >> n >> polycarp;
		for (int i = n - 1; i >= 0; i--) {
			if (polycarp[i] == '0') {
				num = 10 * (polycarp[i - 2] - '0') + (polycarp[i - 1] - '0');
				i -= 2;
			}
			else num = polycarp[i] - '0';
			ans.push_back('a' + (num - 1));
		}
		reverse(ans.begin(), ans.end());
		cout << ans << '\n';
	}
}