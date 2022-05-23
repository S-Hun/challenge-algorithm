#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int N, t, x, y, result = 0, result1 = 0;
bool map[10][10] = {0};
void Input()
{
    cin >> t >> x >> y;
}
void pushRight()
{
    int xx = x;
    int yy = y;
    int right = x;
    int sizeb = 1;
    if (t == 3)
    {
        right++;
    }
    if (t == 3 || t == 2)
    {
        sizeb++;
    }
    for (int i = 0;; i++)
    {
        if (t == 2)
        {
            if (map[yy][right+1] == 1 || right+1 == 10 || map[yy + 1][right+1] == 1)
            {
                break;
            }
        }
        if (map[yy][right+1] == 1 || right+1 == 10)
        {
            break;
        }
        xx++;
        right++;
    }
    map[yy][xx] = 1;
    if (map[0][xx] == 1 && map[3][xx] == 1 && map[2][xx] == 1 && map[1][xx] == 1)
    {
        result++;
        for (int j = xx; j > 4; j--)
        {
            map[0][j] = map[0][j - 1];
            map[1][j] = map[1][j - 1];
            map[3][j] = map[3][j - 1];
            map[2][j] = map[2][j - 1];
        }
    }
    if (t == 2)
    {
        map[yy + 1][xx] = 1;
        if (map[0][xx] == 1 && map[3][xx] == 1 && map[2][xx] == 1 && map[1][xx] == 1)
        {
            result++;
            for (int j = xx; j > 4; j--)
            {
                map[0][j] = map[0][j - 1];
                map[1][j] = map[1][j - 1];
                map[3][j] = map[3][j - 1];
                map[2][j] = map[2][j - 1];
            }
        }
    }
    if (t == 3)
    {
        map[yy][xx + 1] = 1;
        if (map[0][xx + 1] == 1 && map[3][xx + 1] == 1 && map[2][xx + 1] == 1 && map[1][xx + 1] == 1)
        {
            result++;
            for (int j = xx + 1; j > 4; j--)
            {
                map[0][j] = map[0][j - 1];
                map[1][j] = map[1][j - 1];
                map[3][j] = map[3][j - 1];
                map[2][j] = map[2][j - 1];
            }
        }
    }
}
void pushDown()
{
    int xx = x;
    int yy = y;
    int right = yy;
    int sizeb = 1;
    if (t == 2)
    {
        right++;
    }
    if (t == 3 || t == 2)
    {
        sizeb++;
    }
    right++;
    yy++;
    for (int i = 0;; i++)
    {
        if (t == 3)
        {
            if (map[right+1][xx] == 1 || right+1 == 10 || map[right+1][xx + 1] == 1)
            {
                break;
            }
        }
        if (map[right+1][xx] == 1 || right+1 == 10)
        {
            break;
        }
        yy++;
        right++;
    }
    map[yy][xx] = 1;
    if (map[yy][0] == 1 && map[yy][3] == 1 && map[yy][2] == 1 && map[yy][1] == 1)
    {
        result++;
        for (int j = yy; j > 4; j--)
        {
            map[j][0] = map[j - 1][0];
            map[j][1] = map[j - 1][1];
            map[j][3] = map[j - 1][3];
            map[j][2] = map[j - 1][2];
        }
    }
    if (t == 2)
    {
        map[yy + 1][xx] = 1;
        if (map[yy + 1][0] == 1 && map[yy + 1][3] == 1 && map[yy + 1][2] == 1 && map[yy + 1][1] == 1)
        {
            result++;
            for (int j = yy + 1; j > 4; j--)
            {
                map[j][0] = map[j - 1][0];
                map[j][1] = map[j - 1][1];
                map[j][3] = map[j - 1][3];
                map[j][2] = map[j - 1][2];
            }
        }
    }
    if (t == 3)
    {
        map[yy][xx + 1] = 1;
        if (map[yy][0] == 1 && map[yy][3] == 1 && map[yy][2] == 1 && map[yy][1] == 1)
        {
            result++;
            for (int j = yy; j > 4; j--)
            {
                map[j][0] = map[j - 1][0];
                map[j][1] = map[j - 1][1];
                map[j][3] = map[j - 1][3];
                map[j][2] = map[j - 1][2];
            }
        }
    }
}
void remove_block()
{
    int rs = 0, ds = 0;
    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            if (map[4 + i][j] == 1)
            {
                ds++;
            }
            if (map[j][4 + i] == 1)
            {
                rs++;
            }
        }
    }
    for (int i = 0; i < ds; i++)
    {
        for (int j = 9; j > 4; j--)
        {
            map[j][0] = map[j - 1][0];
            map[j][1] = map[j - 1][1];
            map[j][3] = map[j - 1][3];
            map[j][2] = map[j - 1][2];
        }
        map[4][0] = 0;
        map[4][1] = 0;
        map[4][2] = 0;
        map[4][3] = 0;
        if (t == 3)
        {
            break;
        }
    }
    for (int i = 0; i < rs; i++)
    {
        for (int j = 9; j > 4; j--)
        {
            map[0][j] = map[0][j - 1];
            map[1][j] = map[1][j - 1];
            map[3][j] = map[3][j - 1];
            map[2][j] = map[2][j - 1];
        }
        map[0][4] = 0;
        map[1][4] = 0;
        map[2][4] = 0;
        map[3][4] = 0;
        if (t == 2)
        {
            break;
        }
    }
}
void count_block()
{
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            if (map[i + 6][j] == 1)
                result1++;
            if (map[i][j + 6] == 1)
                result1++;
        }
    }
}
void Solution()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        Input();
        pushRight();
        pushDown();
        remove_block();
    }
    count_block();
}
void output()
{
    cout << result << endl
         << result1;

}
void Solve()
{
    Solution();
    output();
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Solve();

    return 0;
}

