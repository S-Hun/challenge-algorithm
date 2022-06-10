#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int N, score, P;
vector<int> scores;

int main() {
    cin >> N >> score >> P;
    scores.resize(N);
    for (int i = 0; i < N; i++) cin >> scores[i];
    sort(scores.begin(), scores.end(), greater<>());
    int pos = N, spos = -1;
    for (int i = 0; i < N; i++) {
        if (spos == -1 && scores[i] == score) spos = i;
        if (scores[i] < score) {
            pos = i;
            break;
        }
    }
    if (spos == -1) spos = pos;
    if (pos < P) {
        cout << spos + 1;
    }
    else cout << -1;
}