#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include<algorithm>

using namespace std;
string A, B, ans;
int a, b;
vector<vector<int>> LCS;

void init() {
    cin >> A >> B;
    a = A.size();
    b = B.size();
    LCS.resize(a + 1, vector<int>(b + 1, 0));
}

void solve() {
    for (int i = 0; i < a; i++) {
        for (int j = 0; j < b; j++) {
            if (A[i] == B[j]) { 
                LCS[i + 1][j + 1] = LCS[i][j] + 1;
            }
            else LCS[i + 1][j + 1] = max(LCS[i][j + 1], LCS[i + 1][j]);
        }
    }
    cout << LCS[a][b] << '\n';
    string ans;
    int i = a, j = b;
    while (LCS[i][j] != 0) {
        if (A[i-1] == B[j-1]) {
            ans.push_back(A[i-1]);
            i--; j--;
        }
        else LCS[i][j - 1] > LCS[i - 1][j] ? j-- : i--;
    }
    reverse(ans.begin(), ans.end());
    cout << ans;
}

int main()
{
    init();
    solve();
}