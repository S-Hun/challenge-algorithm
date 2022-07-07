#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
int tc, r;
vector<int> s;
vector<bool> visit;
vector<bool> check;

void init() {
    cin >> r;
    s.resize(r);
    visit.assign(r, false);
    check.assign(r, false);
    for (int i = 0; i < r; i++) { cin >> s[i]; s[i]--; }
    // for (int i = 0; i < r; i++) { cout << s[i] << ' '; }
    // cout << '\n';

}

void solve() {
    vector<int> dfs;
    int ans = r;
    for (int i = 0; i < r; i++) {
        if (!visit[i]) {
            dfs.push_back(i);
            visit[i] = true;
        }
        
        while (!dfs.empty()) {
            int cur = dfs.back();
            // cout << cur << ' ';
            
            if (!visit[s[cur]]) {
                visit[s[cur]] = true;
                dfs.push_back(s[cur]);
            }
            else if (!check[s[cur]]) {
                for (int i = cur; i != s[cur]; i = dfs.back()) {
                    dfs.pop_back();
                    check[i] = true;
                    ans--;
                }
                // cout << "!" << cur << '\n';
                ans--;
                dfs.pop_back();
                check[s[cur]] = true;
            }
            else while (!dfs.empty()) {
                check[dfs.back()] = true;
                dfs.pop_back();
            }
        }
        
    }
    cout << ans << '\n';
}

int main()
{
    cin >> tc;
    while (tc--) {
        init();
        solve();
    }
}