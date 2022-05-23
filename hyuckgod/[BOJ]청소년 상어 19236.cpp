#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int result = 0;
// int sx = 0, sy = 0, sd = 0;
int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
void Input(vector<vector<int>> &map, vector<vector<int>> &fish)
{
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            int a, b;
            cin >> a >> b;
            fish[a - 1][0] = j;
            fish[a - 1][1] = i;
            fish[a - 1][2] = b - 1;
            map[i][j] = a;
        }
    }
}
void movefish(vector<vector<int>> &map, vector<vector<int>> &fish, int sx, int sy, int sd)
{
    for (int i = 0; i < 16; i++)
    {
        if (fish[i][2] == 8)
        {
            continue;
        }
        for (int j = 0; j < 8; j++)
        {
            int dir = (fish[i][2] + j) % 8;
            int nx = fish[i][0] + dx[dir];
            int ny = fish[i][1] + dy[dir];
            if ((sx == nx && sy == ny) || nx == -1 || ny == -1 || nx == 4 || ny == 4)
            {
                continue;
            }
            if (map[ny][nx] == 0)
            {
                fish[i][2] = dir;
                map[fish[i][1]][fish[i][0]] = 0;
                map[ny][nx] = i + 1;
                fish[i][0] = nx;
                fish[i][1] = ny;
                break;
            }
            if (map[ny][nx] > 0)
            {
                fish[i][2] = dir;
                int temp = map[ny][nx];
                map[ny][nx] = i + 1;
                map[fish[i][1]][fish[i][0]] = temp;
                int tx = fish[i][0];
                int ty = fish[i][1];
                fish[i][0] = nx;
                fish[i][1] = ny;
                fish[temp - 1][0] = tx;
                fish[temp - 1][1] = ty;
                break;
            }
        }
    }
}
void re(int num, vector<vector<int>> map, vector<vector<int>> fish, int sx, int sy, int sd)
{
    movefish(map, fish, sx, sy, sd);
    int caneat[] = {0, 0, 0, 0};
    int caneatnum = 0;
    int nx = sx + dx[sd];
    int ny = sy + dy[sd];
    for (;;)
    {
        if (nx == -1 || ny == -1 || nx == 4 || ny == 4)
        {
            break;
        }
        if (map[ny][nx] > 0)
        {
            caneat[caneatnum] = map[ny][nx];
            caneatnum++;
        }
        nx += dx[sd];
        ny += dy[sd];
    }
    if (caneatnum == 0)
    {
        if (result < num)
            result = num;
        return;
    }
    for (int i = 0; i < caneatnum; i++)
    {
        int ssd = fish[caneat[i] - 1][2];
        fish[caneat[i] - 1][2] = 8;
        map[fish[caneat[i] - 1][1]][fish[caneat[i] - 1][0]] = 0;
        re(num + caneat[i], map, fish, fish[caneat[i] - 1][0], fish[caneat[i] - 1][1], ssd);
        fish[caneat[i] - 1][2] = ssd;
        map[fish[caneat[i] - 1][1]][fish[caneat[i] - 1][0]] = caneat[i];
    }
}
void Solution()
{
    vector<vector<int>> fish(16, vector<int>(3, 0));
    vector<vector<int>> map(4, vector<int>(4, 0));
    Input(map, fish);
    int temp = map[0][0];
    int sd = fish[map[0][0] - 1][2];
    fish[map[0][0] - 1][2] = 8;
    result += map[0][0];
    map[0][0] = 0;
    re(temp, map, fish, 0, 0, sd);
}
void Output()
{
    cout << result;
}
void Solve()
{
    Solution();
    Output();
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Solve();

    return 0;
}
