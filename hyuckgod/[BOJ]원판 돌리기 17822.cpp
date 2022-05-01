#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int N, M, T, result = 0;
int map[50][50];
int TT[50][3];
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
void Input()
{
    cin >> N >> M >> T;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> map[i][j];
        }
    }
    for (int i = 0; i < T; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cin >> TT[i][j];
        }
    }
}
void delre(int x, int y, int num)
{
    if (map[y][x] != num || y == -1 || y == N)
    {
        return;
    }
    map[y][x] = -10000;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        nx = nx == -1 ? M - 1 : nx;
        nx = nx == M ? 0 : nx;
        delre(nx, ny, num);
    }
    return;
}

void Solution()
{
    for (int i = 0; i < T; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if ((j + 1) % TT[i][0] != 0)
            {
                continue;
            }

            for (int k = 0; k < TT[i][2]; k++)
            {
                int last = map[j][M - 1];
                int first = map[j][0];
                if (TT[i][1] == 0)
                {
                    for (int t = M - 1; t > 0; t--)
                    {
                        map[j][t] = map[j][t - 1];
                    }
                    map[j][0] = last;
                }
                else
                {
                    for (int t = 0; t < M - 1; t++)
                    {
                        map[j][t] = map[j][t + 1];
                    }
                    map[j][M - 1] = first;
                }
            }
        }
        int isdel = 0;
        int sum = 0;
        int count = 0;
        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < M; k++)
            {
                if (map[j][k] == -10000)
                    continue;
                for (int t = 0; t < 4; t++)
                {
                    int nx = k + dx[t];
                    int ny = j + dy[t];
                    nx = nx == -1 ? M - 1 : nx;
                    nx = nx == M ? 0 : nx;
                    if (ny == -1 || ny == N)
                        continue;
                    if (map[j][k] == map[ny][nx])
                    {
                        delre(k, j, map[j][k]);
                        isdel = 1;
                        sum += 10000;
                        count--;
                        break;
                    }
                }
                sum += map[j][k];
                count++;
            }
        }
        float aver = (float)sum / count;
        if (isdel == 0)
        {
            for (int j = 0; j < N; j++)
            {
                for (int k = 0; k < M; k++)
                {
                    if (map[j][k] == -10000)
                        continue;
                    if (map[j][k] > aver)
                    {
                        map[j][k]--;
                    }
                    else if (map[j][k] < aver)
                    {
                        map[j][k]++;
                    }
                }
            }
        }

    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (map[i][j] == -10000)
                continue;
            result += map[i][j];
        }
    }
    cout << result;
}

void Solve()
{
    Input();
    Solution();
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Solve();

    return 0;
}
