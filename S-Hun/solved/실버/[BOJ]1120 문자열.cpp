#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
string A, B;

void init() {
    cin >> A >> B;
}

void solve() {
    int ans = 100;
    if (A.size() < B.size()) swap(A, B);
    for (int i = 0; i <= A.size() - B.size(); i++) {
        int tmp = 0;
        for (int j = 0; j < B.size(); j++) {
            if (A[i + j] != B[j]) tmp++;
        }
        if (ans > tmp) ans = tmp;
    }
    cout << ans;
}

int main()
{
    init();
    solve();
}