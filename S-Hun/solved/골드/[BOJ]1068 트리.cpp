#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
int N, ans = 0, root = 0, del;
vector<int> parent;
vector<vector<int>> child;

void init() {
    cin >> N;
    parent.resize(N);
    child.resize(N);
    for (int i = 0; i < N; i++) { 
        cin >> parent[i];
        if (parent[i] != -1) child[parent[i]].push_back(i);
        else root = i;
    }
    cin >> del;
}

void solve() {
    queue<int> q;
    q.push(root);
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        
        if (cur == del) continue;
        if (child[cur].size() == 0 || (child[cur].size() == 1 && child[cur][0] == del)) ans++;

        for (auto& c : child[cur]) {
            q.push(c);
        }
    }
    cout << ans;
}

int main()
{
    init();
    solve();
}