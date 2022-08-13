#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
int N;
const int MAX_SIZE = 2001;
vector<int> arr1, arr2;
vector<vector<int>> with_prime;
bool is_odd;
bool sieve[MAX_SIZE];

vector<int> target;
vector<bool> connected;

void init() {
    int value;
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> value;
        if (i == 0) {
            if (value & 1) is_odd = true;
            else is_odd = false;
        }
        if (value & 1) {
            if (is_odd) arr1.push_back(value);
            else arr2.push_back(value);
        }
        else {
            if (is_odd) arr2.push_back(value);
            else arr1.push_back(value);
        }
    }
    //for (auto& v : arr1) cout << v << ' ';
    //cout << '\n';
    //for (auto& v : arr2) cout << v << ' ';
    //cout << '\n';
}

bool dfs(int x) {
    //cout << '(' << x << ") ";
    if (connected[x] || x == 0) return false;
    connected[x] = true;

    for (auto& nxt : with_prime[x]) {
        if (target[nxt] == -1 || dfs(target[nxt])) {
            target[nxt] = x;
            return true;
        }
    }
    return false;
}

bool check(int x) {
    int cnt = 1;
    target = vector<int>(N / 2, -1);
    target[x] = 0;
    for (int i = 1; i < N / 2; i++) {
        connected = vector<bool>(N / 2, false);
        if (dfs(i)) cnt++;
    }
    //cout << "[" << x << "] ";
    //for (int i = 0; i < N / 2; i++) cout << target[i] << ' ';
    //cout << '\n';
    if (cnt == N / 2) {
        return true; 
    }
    else return false;
}

void solve() {
    if (arr1.size() != arr2.size()) {
        cout << -1;
        return;
    }

    sieve[0] = true;
    sieve[1] = true;
    for (int i = 2; i * i < MAX_SIZE; i++) {
        if (sieve[i]) continue;
        for (int j = i * i; j < MAX_SIZE; j += i) {
            sieve[j] = true;
        }
    }

    with_prime.resize(arr1.size());
    for (int i = 0; i < arr1.size(); i++) {
        for (int j = 0; j < arr2.size(); j++) {
            if (!sieve[arr1[i] + arr2[j]]) {
                with_prime[i].push_back(j);
            }
        }
    }

    vector<int> ans;
    for (int i = 0; i < with_prime[0].size(); i++) {
        if (check(with_prime[0][i])) ans.push_back(arr2[with_prime[0][i]]);
    }
    if (ans.empty()) cout << -1;
    sort(ans.begin(), ans.end());
    for (auto& a : ans) {
        cout << a << ' ';
    }
}

int main()
{
    init();
    solve();
}