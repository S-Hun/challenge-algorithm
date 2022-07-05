#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;
int h, w;
struct pos {
    int i, j;
};
int D[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
bool valid_keys[26];
vector<string> map;
vector<vector<bool>> visit;
vector<queue<pos>> tmp;

void init() {
    cin >> h >> w;
    map.resize(h);
    visit.assign(h, vector<bool>(w, false));
    tmp.assign(26, queue<pos>());
    for (int i = 0; i < h; i++) cin >> map[i];
    string key;
    cin >> key;
    for (int i = 0; i < 26; i++) valid_keys[i] = false;
    if(key[0] != '0') for (auto& k : key) valid_keys[k - 'a'] = true;
}

void solve() {
    int ans = 0;
    queue<pos> q;
    for (int i = 0; i < h; i++) {
        if (map[i][0] != '*') {
            if(map[i][0] == '.') q.push(pos{ i, 0 });
            else if (map[i][0] == '$') {
                q.push(pos{ i, 0 });
                ans++;
            }
            else if ('A' <= map[i][0] && map[i][0] <= 'Z') { 
                if (valid_keys[map[i][0] - 'A']) q.push(pos{ i, 0 });
                else tmp[map[i][0] - 'A'].push({ i, 0 });
            }
            else if ('a' <= map[i][0] && map[i][0] <= 'z') {
                q.push(pos{ i, 0 });
                valid_keys[map[i][0] - 'a'] = true;
            }
        }
        if (map[i][w-1] != '*') {
            if (map[i][w-1] == '.') q.push(pos{ i, w-1 });
            else if (map[i][w-1] == '$') {
                q.push(pos{ i, w-1 });
                ans++;
            }
            else if ('A' <= map[i][w - 1] && map[i][w - 1] <= 'Z') {
                if (valid_keys[map[i][w - 1] - 'A']) q.push(pos{ i, w-1 });
                else tmp[map[i][w - 1] - 'A'].push({ i, w-1 });
            }
            else if ('a' <= map[i][w - 1] && map[i][w - 1] <= 'z') {
                q.push(pos{ i, 0 });
                valid_keys[map[i][w - 1] - 'a'] = true;
            }
        }
        visit[i][0] = true;
        visit[i][w - 1] = true;
    }

    for (int i = 1; i < w - 1; i++) {
        if (map[0][i] != '*') {
            if (map[0][i] == '.') q.push(pos{ 0, i });
            else if (map[0][i] == '$') {
                q.push(pos{ 0, i });
                ans++;
            }
            else if ('A' <= map[0][i] && map[0][i] <= 'Z') {
                if (valid_keys[map[0][i] - 'A']) q.push(pos{ 0, i });
                else tmp[map[0][i] - 'A'].push({ 0, i });
            }
            else if ('a' <= map[0][i] && map[0][i] <= 'z') {
                q.push(pos{ 0, i });
                valid_keys[map[0][i] - 'a'] = true;
            }
        }
        if (map[h - 1][i] != '*') {
            if (map[h - 1][i] == '.') q.push(pos{ h - 1, i });
            else if (map[h-1][i] == '$') {
                q.push(pos{ h-1, i });
                ans++;
            }
            else if ('A' <= map[h - 1][i] && map[h - 1][i] <= 'Z') {
                if (valid_keys[map[h - 1][i] - 'A']) q.push(pos{ h - 1, i });
                else tmp[map[h - 1][i] - 'A'].push({ h - 1, i });
            }
            else if ('a' <= map[h - 1][i] && map[h - 1][i] <= 'z') {
                q.push(pos{ h - 1, i });
                valid_keys[map[h - 1][i] - 'a'] = true;
            }
        }
        visit[0][i] = true;
        visit[h - 1][i] = true;
    }

    while (!q.empty()) {
        pos cur = q.front();
        //cout << cur.i << ' ' << cur.j << '\n';
        q.pop();

        for (int k = 0; k < 4; k++) {
            int di = cur.i + D[k][0], dj = cur.j + D[k][1];
            if (di >= 0 && dj >= 0 && di < h && dj < w) {
                if (!visit[di][dj] && map[di][dj] != '*') {
                    visit[di][dj] = true;
                    if (map[di][dj] == '$') {
                        ans++;
                        q.push({ di, dj });
                    }
                    else if (map[di][dj] == '.') q.push({ di, dj });
                    else if ('A' <= map[di][dj] && map[di][dj] <= 'Z') {
                        if (!valid_keys[map[di][dj] - 'A']) tmp[map[di][dj] - 'A'].push({ di, dj });
                        else q.push({ di, dj });
                    }
                    else if ('a' <= map[di][dj] && map[di][dj] <= 'z') {
                        valid_keys[map[di][dj] - 'a'] = true;
                        while (!tmp[map[di][dj] - 'a'].empty()) {
                            q.push(tmp[map[di][dj] - 'a'].front());
                            tmp[map[di][dj] - 'a'].pop();
                        }
                        q.push({ di, dj });
                    }
                }
            }
        }
    }

    cout << ans << '\n';
}

int main()
{
    int TC;
    cin >> TC;
    while (TC--) {
        init();
        solve();
    }
}