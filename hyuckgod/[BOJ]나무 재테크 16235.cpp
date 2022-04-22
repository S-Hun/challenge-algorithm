#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;

int result = 0, N, M, K;
vector<int> MAP[10][10];
int A[10][10];
int energy[10][10];

int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

void Input()
{
    cin >> N >> M >> K;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> A[i][j];
            energy[i][j] = 5;
        }
    }
    for (int i = 0; i < M; i++)
    {
        int x, y, z;
        cin >> y >> x >> z;
        MAP[y - 1][x - 1].push_back(z);
    }
}

void Solution()
{
    for (int i = 0; i < K; i++)
    {
        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < N; k++)
            {
                vector<int> Temp;
                int Death = 0;
                for (int t = MAP[j][k].size() - 1; t >= 0; t--)
                {
                    if (energy[j][k] >= MAP[j][k][t])
                    {
                        energy[j][k] -= MAP[j][k][t];
                        Temp.push_back(MAP[j][k][t] + 1);
                    }
                    else
                    {
                        Death += MAP[j][k][t] / 2;
                    }
                }
                MAP[j][k].clear();
                for (int t = Temp.size() - 1; t >= 0; t--)
                {
                    MAP[j][k].push_back(Temp[t]);
                }
                energy[j][k] += Death + A[j][k];
            }
        }
        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < N; k++)
            {
                for (int t = MAP[j][k].size() - 1; t >= 0; t--)
                {
                    if (MAP[j][k][t] % 5 == 0)
                    {
                        for (int v = 0; v < 8; v++)
                        {
                            int nx = k + dx[v];
                            int ny = j + dy[v];
                            if (nx == -1 || ny == -1 || nx == N || ny == N)
                            {
                                continue;
                            }
                            MAP[ny][nx].push_back(1);
                        }
                    }
                }
            }
        }
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            result += MAP[i][j].size();
        }
    }
}

void Solve()
{
    Input();
    Solution();
    cout << result;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    Solve();
    return 0;
}