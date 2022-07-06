#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
int X;
struct idx {
    int from, cnt;
};
vector<idx> tmp;

void init() {
    cin >> X;
    tmp.resize(X + 1, {-1, 0});
}

void printRoute(int i) {
    if (i == tmp[i].from) {
        cout << i << ' ';
        return;
    }
    else {
        printRoute(tmp[i].from);
        cout << i << ' ';
    }
}

void solve() {
    queue<int> q;
    q.push(X);
    tmp[X] = { X, 0 };
    while (!q.empty()) {
        int cur = q.front();
        int cnt = tmp[cur].cnt;
        if (cur == 1) break;
        q.pop();

        if (cur % 3 == 0 && cur / 3 > 0 && tmp[cur / 3].from == -1) { tmp[cur / 3] = { cur, cnt + 1 }; q.push(cur / 3); }
        if (cur % 2 == 0 && cur / 2 > 0 && tmp[cur / 2].from == -1) { tmp[cur / 2] = { cur, cnt + 1 }; q.push(cur / 2); }
        if (cur - 1 > 0 && tmp[cur - 1].from == -1) { tmp[cur - 1] = { cur, cnt + 1 }; q.push(cur - 1); }
    }
    cout << tmp[1].cnt << '\n';
    printRoute(1);
}

int main()
{
    init();
    solve();
}