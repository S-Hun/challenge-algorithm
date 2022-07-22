#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>
#include<limits>

using namespace std;
typedef long long ll;
int N;
vector<int> li;

void init() {
    cin >> N;
    int A, B;
    for (int i = 0; i < N; i++) {
        cin >> A >> B;
        li.push_back(A - B);
    }
    sort(li.begin(), li.end());
}

void solve() {
    if (N & 1) cout << 1;
    else cout << li[N / 2] - li[N / 2 - 1] + 1;
}

int main()
{
    init();
    solve();
}