#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
typedef pair<double, double> Pos;
int N;
vector<Pos> stars;
vector<int> parent;

void init() {
    cin >> N;
    stars.resize(N);
    parent.resize(N);
    for (int i = 0; i < N; i++) { cin >> stars[i].first >> stars[i].second; parent[i] = i; }
}

struct star_dist {
    double dist;
    int src, dst;

    bool operator()(const star_dist a, const star_dist b) {
        return a.dist > b.dist;
    }
};

double dist(Pos a, Pos b) {
    return sqrt(pow(b.second - a.second, 2) + pow(b.first - a.first, 2));
}

int star_find(int n) {
    if (n == parent[n]) return n;
    else return parent[n] = star_find(parent[n]);
}

void star_union(int a, int b) {
    int A = star_find(a);
    int B = star_find(b);
    parent[B] = A;
}

void solve() {
    priority_queue<star_dist, vector<star_dist>, star_dist> q;
    for (int i = 0; i < N; i++) {
        for (int j = 1; j < N; j++) {
            q.push({ dist(stars[i], stars[j]), i, j });
        }
    }
    double ans = 0;
    while (!q.empty()) {
        star_dist cur = q.top();
        q.pop();
        if (star_find(cur.src) != star_find(cur.dst)) {
            star_union(cur.src, cur.dst);
            ans += cur.dist;
        }
    }
    cout << ans;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cout << fixed; cout.precision(2);
    init();
    solve();
}