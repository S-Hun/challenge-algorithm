#include<iostream>

using namespace std;

int N, p1, p2, cnt = 0;

void init() {
    cin >> N >> p1 >> p2;
}

void solve() {
    while (p1 != p2) {
        p1 = p1 - p1 / 2;
        p2 = p2 - p2 / 2;
        cnt++;
    }

    cout << cnt;
}

int main()
{
    init();
    solve();
}