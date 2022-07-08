#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
int N, M;
vector<int> arr;
vector<int> even;
vector<int> odd;


void init() {
    cin >> N;
    arr.resize(N);
    even.resize(N, -1);
    odd.resize(N, -1);
    for (int i = 0; i < N; i++) cin >> arr[i];
}

bool palind(int s, int e) {
    int half = (e + s) / 2;
    if ((e + s) % 2 != 0) {
        if (even[half] == -1) {
            int l = half, r = half + 1, cnt = 0;
            while (l >= 0 && r < N && arr[l] == arr[r]) {
                cnt++; l--; r++;
            }
            even[half] = cnt;
        }
        if (even[half] >= e - half) return true;
        else return false;
    }
    else {
        if (odd[half] == -1) {
            int l = half - 1, r = half + 1, cnt = 0;
            while (l >= 0 && r < N && arr[l] == arr[r]) {
                cnt++; l--; r++;
            }
            odd[half] = cnt;
        }
        if (odd[half] >= e - half) return true;
        else return false;
    }
}

void solve() {
    cin >> M;
    int s, e;
    while (M--) {
        cin >> s >> e;
        cout << ((palind(s - 1, e - 1)) ? 1 : 0) << '\n';
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    init();
    solve();
}