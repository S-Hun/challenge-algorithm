#include<iostream>
#include<vector>
#include<limits>
#include<cmath>

using namespace std;
typedef long long ll;
bool sieve[1'000'001];
bool ans[1'000'001];
vector<ll> prime;
ll l, r;

void init() {
    cin >> l >> r;
    sieve[0] = sieve[1] = true;
    for (int i = 2; i <= 1'000'000; i++) {
        if (sieve[i]) continue;
        prime.push_back(i);
        if (i > sqrt(1'000'000)) continue;
        for (int j = i * i; j <= 1'000'000; j += i) {
            sieve[j] = true;
        }
    }
    
}

void solve() {
    for (auto& p : prime) {
        ll square = p * p;
        if (square > r) break;
        for (ll k = l / square; square * k <= r; k++) {
            if (square * k < l) continue;
            ans[square * k - l] = true;
        }
    }

    int res = 0;

    for (int i = 0; i <= r - l; i++) {
        if (!ans[i]) res++;
    }

    cout << res;
}

int main()
{
    init();
    solve();
}