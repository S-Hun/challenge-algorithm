#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
 
#define endl "\n"
#define MAX 101
using namespace std;
 
int R, C, K, Answer;
int MAP[MAX][MAX];
int Number_Cnt[MAX];
 
void Input()
{
    cin >> R >> C >> K;
    for (int i = 1; i <= 3; i++)
    {
        for (int j = 1; j <= 3; j++)
        {
            cin >> MAP[i][j];
        }
    }
}
 
void Print()
{
    for (int i = 1; i < 50; i++)
    {
        for (int j = 1; j < 50; j++)
        {
            cout << MAP[i][j] << " ";
        }
        cout << endl;
    }
    cout << "########################################" << endl;
}
 
void Find()
{
    int Time = 0;
    int Hang = 3;
    int Yul = 3;
 
    while (1)
    {
        if (MAP[R][C] == K) { Answer = Time; break; }
        if (Time > 100) { Answer = -1; break; }
 
        vector<int> Size;
        if (Hang >= Yul)    // 정사각형이거나 세로로긴 형태
        {
            for (int i = 1; i <= Hang; i++)
            {
                vector<pair<int, int>> V;
                memset(Number_Cnt, 0, sizeof(Number_Cnt));
                for (int j = 1; j <= Yul; j++) Number_Cnt[MAP[i][j]]++;
                for (int j = 1; j < MAX; j++)
                {
                    if (Number_Cnt[j] == 0) continue;
                    V.push_back(make_pair(Number_Cnt[j], j));
                }
                sort(V.begin(), V.end());
                for (int j = 1; j <= Yul; j++) MAP[i][j] = 0;
                int Idx = 1;
                for (int j = 0; j < V.size(); j++)
                {
                    MAP[i][Idx++] = V[j].second;
                    MAP[i][Idx++] = V[j].first;
                }
                Idx--;
                Size.push_back(Idx);
            }
            sort(Size.begin(), Size.end());
            Yul = Size.back();
        }
        else        // 가로로 더 긴꼴
        {
            for (int i = 1; i <= Yul; i++)
            {
                vector<pair<int, int>> V;
                memset(Number_Cnt, 0, sizeof(Number_Cnt));
                for (int j = 1; j <= Hang; j++) Number_Cnt[MAP[j][i]]++;
                for (int j = 1; j < MAX; j++)
                {
                    if (Number_Cnt[j] != 0)
                    {
                        V.push_back(make_pair(Number_Cnt[j], j));
                    }
                }
                sort(V.begin(), V.end());
                for (int j = 1; j <= Hang; j++) MAP[j][i] = 0;
                int Idx = 1;
                for (int j = 0; j < V.size(); j++)
                {
                    MAP[Idx++][i] = V[j].second;
                    MAP[Idx++][i] = V[j].first;
                }
                Idx--;
                Size.push_back(Idx);
            }
            sort(Size.begin(), Size.end());
            Hang = Size.back();
        }
        Time++;
    }
}
 
void Solution()
{
    if (MAP[R][C] == K)
    {
        Answer = 0;
        cout << Answer << endl;
        return;
    }
    Find();
    cout << Answer << endl;
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
