#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<int, int>> house, chi;
int N, L, R, num = 0;
int result = 0;
int map[50][50];
bool visited[50][50] = {0};
bool cal[50][50] = {0};
int re(int x, int y, int xx, int yy)
{
    if (x == xx && y == yy)
    {
        visited[y][x] = 1;
        num++;
        return re(x, y, x + 1, y) + re(x, y, x, y - 1) + re(x, y, x - 1, y) + re(x, y, x, y + 1) + map[y][x];
    }
    if (xx == N || yy == N || xx == -1 || yy == -1 || visited[yy][xx] == 1 || abs(map[y][x] - map[yy][xx]) < L || abs(map[y][x] - map[yy][xx]) > R)
    {
        return 0;
    }
    x = xx;
    y = yy;
    num++;
    visited[y][x] = 1;
    return re(x, y, x + 1, y) + re(x, y, x, y - 1) + re(x, y, x - 1, y) + re(x, y, x, y + 1) + map[y][x];
}

int main(void)
{
    cin >> N >> L >> R;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> map[i][j];
        }
    }
    int p = 0;
    for (;; p++)
    {
        bool ischange = false;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (visited[i][j] == 0)
                {
                    int caln = re(j, i, j, i);
                    caln /= num;
                    int k = i; int t = j ; int nn = 0;
                    for (; k < N; k++)
                    {
                        for (; t < N; t++)
                        {
                            if (visited[k][t] == 1 && cal[k][t] == 0)
                            {
                                cal[k][t] = 1;
                                map[k][t] = caln;
                                nn++;
                            }
                        }
                        if(nn == num){
                            break;
                        }
                        t = 0;
                    }
                    if (num > 1)
                    {
                        ischange = true;
                    }
                    num = 0;
                }
            }
        }
        if (ischange == false)
        {
            break;
        }
        for (int o = 0; o < N; o++)
        {
            for (int c = 0; c < N; c++)
            {
                cal[c][o] = 0;
                visited[c][o] = 0;
            }
        }
    }
    cout << p;
}