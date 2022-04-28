#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int N, min, max, result = 100000000;
int A[20][20];
void Input()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> A[i][j];
        }
    }
}

void Solution()
{
    for (int i = 0; i < N - 2; i++)
    {
        for (int j = 1; j < N - 1; j++)
        {
            pair<int, int> a = make_pair(j, i);
            for (int k = 1; a.first - k >= 0 && a.second + k < N - 1; k++)
            {
                pair<int, int> b = make_pair(a.first - k, a.second + k);
                for (int t = 1; b.second + t < N && a.first + t < N; t++)
                {
                    pair<int, int> c = make_pair(b.first + t, b.second + t);
                    pair<int, int> d = make_pair(a.first + t, a.second + t);
                    int map[N][N];

                    for (int ii = 0; ii < N; ii++)
                    {
                        for (int jj = 0; jj < N; jj++)
                        {
                            map[ii][jj] = 0;
                        }
                    }
                    int one = 0, two = 0, three = 0, four = 0, five = 0;
                    int x = a.first;
                    int y = a.second;
                    map[y][x] = 5;
                    for (;;)
                    {
                        if (x == b.first && y == b.second)
                        {
                            break;
                        }
                        x--;
                        y++;
                        map[y][x] = 5;
                    }
                    for (;;)
                    {
                        if (x == c.first && y == c.second)
                        {
                            break;
                        }
                        x++;
                        y++;
                        map[y][x] = 5;
                    }
                    for (;;)
                    {
                        if (x == d.first && y == d.second)
                        {
                            break;
                        }
                        x++;
                        y--;
                        map[y][x] = 5;
                    }
                    for (;;)
                    {
                        if (x == a.first && y == a.second)
                        {
                            break;
                        }
                        x--;
                        y--;
                        map[y][x] = 5;
                    }
                    for (int ii = 0; ii < b.second; ii++)
                    {
                        for (int jj = 0; jj < a.first + 1; jj++)
                        {
                            if (map[ii][jj] == 5)
                            {
                                break;
                            }
                            map[ii][jj] = 1;
                            one += A[ii][jj];
                        }
                    }
                    for (int ii = b.second; ii < N; ii++)
                    {
                        for (int jj = 0; jj < c.first; jj++)
                        {
                            if (map[ii][jj] == 5)
                            {
                                break;
                            }
                            map[ii][jj] = 3;
                            three += A[ii][jj];
                        }
                    }
                    for (int ii = 0; ii < d.second + 1; ii++)
                    {
                        for (int jj = N - 1; jj > a.first; jj--)
                        {
                            if (map[ii][jj] == 5)
                            {
                                break;
                            }
                            map[ii][jj] = 2;
                            two += A[ii][jj];
                        }
                    }
                    for (int ii = d.second + 1; ii < N; ii++)
                    {
                        for (int jj = N - 1; jj >= c.first; jj--)
                        {
                            if (map[ii][jj] == 5)
                            {
                                break;
                            }
                            map[ii][jj] = 4;
                            four += A[ii][jj];
                        }
                    }
                    for (int ii = 0; ii < N; ii++)
                    {
                        for (int jj = 0; jj < N; jj++)
                        {
                            if (map[ii][jj] == 5 || map[ii][jj] == 0)
                            {
                                five += A[ii][jj];
                            }
                        }
                    }
                    int min = 100000000;
                    int max = 0;
                    min = min > one ? one : min;
                    min = min > two ? two : min;
                    min = min > three ? three : min;
                    min = min > four ? four : min;
                    min = min > five ? five : min;
                    max = max < one ? one : max;
                    max = max < two ? two : max;
                    max = max < three ? three : max;
                    max = max < four ? four : max;
                    max = max < five ? five : max;
                    result = result < (max - min) ? result : (max - min);
                }
            }
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
