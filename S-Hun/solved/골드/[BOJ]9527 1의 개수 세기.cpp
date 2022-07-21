#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
typedef long long ll;
ll a, b, dp[64];
/*
1
# 1
10
11
# 2 + 1 + 1 = 4
100
101
110
111
# 4 + 4 + 4 = 12
1000
1001
1010
1011
1100
1101
1110
1111
# 8 + 12 + 12 = 32
...
*/
// 1
// 1 + 1 + 2

void init() {
    cin >> a >> b;
}

ll calc(ll v) {
    ll res = v & 1, i = 63;
    for (; i > 0; i--) {
        if (v & (1LL << i)) {
            res += dp[i - 1] + (v - (1LL << i) + 1);
            v -= 1LL << i;
        }
    }
    return res;
}

void solve() {
    dp[0] = 1;
    for (ll i = 1; i < 64; i++) {
        dp[i] = dp[i - 1] * 2 + (1LL << i);
    }
    cout << calc(b) - calc(a-1);
}

int main()
{
    init();
    solve();
}