#include<iostream>
#include<vector>
#include<string>

using namespace std;
int N, M, cnt = 0;
vector<string> src, dst;

void init() {
    cin >> N >> M;
    src.resize(N, "");
    dst.resize(N, "");
    for (int i = 0; i < N; i++) {
        cin >> src[i];
    }
    for (int i = 0; i < N; i++) {
        cin >> dst[i];
    }
}

void flip(int x, int y) {
    cnt++;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            src[x + i][y + j] = (src[x + i][y + j] == '1') ? '0' : '1';
        }
    }
}

void solve() {
    for (int i = 0; i < N - 2; i++) {
        for (int j = 0; j < M - 2; j++) {
            if (src[i][j] != dst[i][j]) flip(i, j);
        }
    }
    bool ans = true;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (src[i][j] != dst[i][j]) {
                ans = false;
                goto END;
            }
        }
    }
END:
    if (ans) cout << cnt;
    else cout << -1;
}

int main()
{
    init();
    solve();
}