#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>
#include<limits>

using namespace std;
string l, r;

void init() {
    cin >> l >> r;
}

void solve() {
    if (l.size() != r.size()) cout << 0;
    else {
        int cnt = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l[i] == r[i]) {
                if (l[i] == '8')
                    cnt++;
            }
            else break;
        }
        cout << cnt;
    }
}

int main()
{
    init();
    solve();
}