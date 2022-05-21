#include <iostream>
#include <vector>

using namespace std;
int n, max_dist = 0, max_node;
struct node {
	int index;
	int dist;
}
vector<node> graph[100001];
bool visit[100001];

using namespace std;

void init() {
	cin >> n;
	int s, e, d;
	for(int i=1; i<=n; i++) {
		cin >> s;
		while(true) {
			cin >> e;
			if(e == -1) break;
			cin >> d;
			graph[s].push_back({e, d});
			graph[e].push_back({s, d});
		}
	}
}

void dfs(int N, int D) {
	if (visit[N]) return;
    if (max_dist < D)
    {
        max_dist = dist;
        max_node = node;
    }
    visit[N] = true;
    for (int i = 0; i < graph[N].size(); i++)
    {
        int next_index = graph[N][i].index;
        int next_dist = graph[N][i].dist;
        dfs(next_index, next_dist + D);
    }
}

void solve() {
	dfs(1, 0);
	for(int i=1; i<=n; i++) visit[i] = false;
	max_dist = 0;
	dfs(max_node, 0);
	cout << max_node;
}

int main() {
	init();
	solve();
}
