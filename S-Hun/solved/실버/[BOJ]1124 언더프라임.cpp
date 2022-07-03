#include<iostream>
#include<vector>
#include<cmath>

using namespace std;
int A, B;
vector<bool> prime;
vector<int> div_num;

void init() {
    cin >> A >> B;
    prime.resize(B + 1, true);
    div_num.resize(B + 1, -1);
    prime[0] = prime[1] = false;
    div_num[1] = 0;

}

int get_div_num(int n) {
    if (div_num[n] != -1) return div_num[n];
    if (prime[n]) {
        div_num[n] = 1;
        return 1;
    }
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) {
            div_num[n] = get_div_num(i) + get_div_num(n / i);
            return div_num[n];
        }
    }
}

void solve() {
    int ans = 0;
    for (int i = 2; i <= B; i++) {
        if(i > sqrt(10000)) break;
        if (prime[i]) {
            //cout << i << ' ';
            for (int j = i * i; j <= B; j += i) prime[j] = false;
        }
    }
    //cout << '\n';
    for (int i = 2; i <= B; i++) {
        int v = get_div_num(i);
        //cout << v << ' ';
        if (i >= A && prime[v]) ans++;
    }
    //cout << '\n';
    cout << ans;
}

int main()
{
    init();
    solve();
}
