#include <iostream>
#include <queue>
#include <vector>
#define max_int 100
#define max_val 401

using namespace std;

vector<vector<int>> shark;
int result = 0, R, C, M;

int dx[] = {0, 0, 0, 1, -1};
int dy[] = {0, -1, 1, 0, 0};

int map[max_int][max_int][6] = {0};
int main()
{
    cin >> R >> C >> M;
    if(M ==0){
        cout << result;
        return 0;
    }
    for (int i = 0; i < M; i++)
    {
        shark.push_back(vector<int>());
    }
    for (int i = 0; i < M; i++)
    {
        int r, c, s, d, z;
        cin >> r >> c >> s >> d >> z;
        shark[i].push_back(r - 1);
        shark[i].push_back(c - 1);
        shark[i].push_back(s);
        shark[i].push_back(d);
        shark[i].push_back(z);
    }
    for (int i = 0; i < C; i++)
    {
        int del[M];
        int delcnt = 0;
        for (int j = 0; j < M; j++)
        {
            if (shark[j][4] != 0)
            {
                if (map[shark[j][0]][shark[j][1]][4] != 0)
                {
                    if (map[shark[j][0]][shark[j][1]][4] < shark[j][4])
                    {
                        map[shark[j][0]][shark[j][1]][0] = shark[j][0];
                        map[shark[j][0]][shark[j][1]][1] = shark[j][1];
                        map[shark[j][0]][shark[j][1]][4] = shark[j][4];
                        shark[map[shark[j][0]][shark[j][1]][5]][4] = 0;
                    }
                    else
                    {
                        shark[j][4] = 0;
                    }
                }
                else
                {
                    map[shark[j][0]][shark[j][1]][0] = shark[j][0];
                    map[shark[j][0]][shark[j][1]][1] = shark[j][1];
                    map[shark[j][0]][shark[j][1]][4] = shark[j][4];
                    map[shark[j][0]][shark[j][1]][5] = j;
                }
            }
        }
        for (int j = 0; j < R; j++)
        {
            if (map[j][i][4] != 0)
            {
                result += map[j][i][4];
                map[j][i][0] = 0;
                map[j][i][1] = 0;
                map[j][i][4] = 0;
                shark[map[j][i][5]][4] = 0;
                map[j][i][5] = 0;
                break;
            }
        }
        for (int j = 0; j < M; j++)
        {
            if (shark[j][4] != 0)
            {
                for (int k = 0; k < shark[j][2]; k++)
                {
                    shark[j][1] += dx[shark[j][3]];
                    shark[j][0] += dy[shark[j][3]];
                    if (shark[j][1] > C - 1 || shark[j][0] > R - 1)
                    {
                        if (shark[j][1] > C - 1)
                        {
                            shark[j][1] = C - 2;
                            shark[j][3] = 4;
                        }
                        else if (shark[j][0] > R - 1)
                        {
                            shark[j][0] = R - 2;
                            shark[j][3] = 1;
                        }
                    }
                    if (shark[j][1] < 0 || shark[j][0] < 0)
                    {
                        if (shark[j][1] < 0)
                        {
                            shark[j][1] = 1;
                            shark[j][3] = 3;
                        }
                        else if (shark[j][0] < 0)
                        {
                            shark[j][0] = 1;
                            shark[j][3] = 2;
                        }
                    }
                }
            }
        }
        for (int k = 0; k < R; k++)
        {
            for (int t = 0; t < C; t++)
            {
                map[k][t][4] = 0;
            }
        }
    }
    cout << result;
    return 0;
}