#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>
#include<limits>

using namespace std;
typedef long long ll;
ll a, b;

void init() {
    cin >> a >> b;
}

void solve() {
    int rate = b * 100 / a;
    if ((b + a) * 100 / (a + a) == rate) {
        cout << -1;
        return;
    }
    else {
        int s = 1, e = a, ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            ll res = (b + mid) * 100 / (a + mid);

            if (res > rate) {
                e = mid - 1;
                ans = mid;
            }
            else {
                s = mid + 1;
            }
        }
        cout << ans;
        return;
    }
       
}

int main()
{
    init();
    solve();
}