#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
int N;
vector<int> arr;
vector<int> temp;

void init() {
    cin >> N;
    arr.resize(N);
    for (int i = 0; i < N; i++) cin >> arr[i];
}

void solve() {
    int len = 0;
    for (auto& v : arr) {
        int pos = lower_bound(temp.begin(), temp.end(), v) - temp.begin();
        if (pos == len) {
            temp.push_back(v);
            len++;
        }
        else temp[pos] = v;
    }
    cout << len;
}

int main()
{
    init();
    solve();
}