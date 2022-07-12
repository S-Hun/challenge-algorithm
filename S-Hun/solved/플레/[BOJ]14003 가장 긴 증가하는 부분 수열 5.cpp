#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
int N;
vector<int> arr;
vector<int> dp;

void init() {
    cin >> N;
    arr.resize(N);
    dp.resize(N);
    for (int i = 0; i < N; i++) cin >> arr[i];
}

void solve() {
    vector<int> tmp;
    int max_dp = -1;
    for (int i = 0; i < N; i++) {
        auto it = lower_bound(tmp.begin(), tmp.end(), arr[i]);
        dp[i] = it - tmp.begin();
        if (dp[i] > max_dp) max_dp = dp[i];
        if (it == tmp.end()) tmp.push_back(arr[i]);
        else *it = arr[i];
    }
    vector<int> ans;
    for (int j = N - 1; j >= 0; j--) {
        if (max_dp == dp[j] && (ans.empty() || ans.back() > arr[j])) {
            ans.push_back(arr[j]);
            if(--max_dp < 0) break;
        }
    }
    cout << ans.size() << '\n';
    while (!ans.empty()) {
        cout << ans.back() << ' ';
        ans.pop_back();
    }
}

int main()
{
    init();
    solve();
}