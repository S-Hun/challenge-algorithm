#include <iostream>
#include <queue>
#include <vector>
#define max_int 50
#define max_val 401

using namespace std;

int map[max_int][max_int], cal[max_int][max_int];
int result = 0, R, C, T, y1;

int dx[] = {0, 0, 1, -1};
int dy[] = {-1, 1, 0, 0};

void mise()
{
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            if (map[i][j] > 4)
            {
                int count = 0;
                int pro = map[i][j] / 5;
                for (int k = 0; k < 4; k++)
                {
                    if (j + dx[k] < 0 || j + dx[k] >= C || i + dy[k] < 0 || i + dy[k] >= R || map[i + dy[k]][j + dx[k]] == -1)
                    {
                        continue;
                    }
                    count++;
                    cal[i + dy[k]][j + dx[k]] += pro;
                }
                if (count > 0)
                {
                    cal[i][j] += (-1) * count * pro;
                }
            }
        }
    }
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            map[i][j] += cal[i][j];
            cal[i][j] = 0;
        }
    }
    return;
}
void clean()
{
    int one = map[0][0];
    int two = map[0][C - 1];
    int sam = map[y1 - 1][C - 1];
    int four = map[y1][C - 1];
    int five = map[R - 1][0];
    int six = map[R - 1][C - 1];
    for (int i = 0; i < C - 1; i++)
    {
        map[0][i] = map[0][i + 1];
        map[R - 1][i] = map[R - 1][i + 1];
    }
    for (int i = C - 1; i > 1; i--)
    {
        map[y1 - 1][i] = map[y1 - 1][i - 1];
        map[y1][i] = map[y1][i - 1];
    }
    for (int i = y1 - 2; i > 1; i--)
    {
        map[i][0] = map[i - 1][0];
    }
    map[1][0] = one;
    for (int i = R - 1; i > y1 + 1; i--)
    {
        map[i][C - 1] = map[i - 1][C - 1];
    }
    map[y1 + 1][C - 1] = four;
    for (int i = 0; i < y1 - 2; i++)
    {
        map[i][C - 1] = map[i + 1][C - 1];
    }
    map[y1 - 2][C - 1] = sam;
    for (int i = y1 + 1; i < R - 2; i++)
    {
        map[i][0] = map[i + 1][0];
    }
    map[R - 2][0] = five;
    map[y1 - 1][1] = 0;
    map[y1][1] = 0;
    return;
}

int main()
{
    cin >> R >> C >> T;
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            cin >> map[i][j];
            if (map[i][j] == -1)
            {
                y1 = i;
            }
        }
    }
    for (int i = 0; i < T; i++)
    {
        mise();
        clean();
    }
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            if (map[i][j] > 0)
            {
                result += map[i][j];
            }
        }
    }
    cout << result;
}