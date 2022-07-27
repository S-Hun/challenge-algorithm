#include<iostream>

using namespace std;
int A, B, N;

void init() {
    cin >> A >> B >> N;
}

void solve() {
    int tmp = A % B;
    for (int i = 1; i < N; i++) {
        if (tmp == 0) break;
        tmp = (tmp * 10) % B;
    }
    cout << (tmp * 10) / B;
}

int main()
{
    init();
    solve();
}