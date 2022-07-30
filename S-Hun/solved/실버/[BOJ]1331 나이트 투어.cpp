#include<iostream>
#include<cmath>

using namespace std;
char input[3];
char before[2];
char start[2];
bool map[6][6];
bool ans = false;

void init() {
    ans = false;
}

bool comp(char pre[], char cur[]) {
    int wdiff = abs(cur[0] - pre[0]), hdiff = abs(cur[1] - pre[1]);
    if (!(wdiff == 1 && hdiff == 2) && !(wdiff == 2 && hdiff == 1)) return true;
    else return false;
}

void solve() {
    for (int i = 0; i < 36; i++) {
        cin >> input;
        if (i == 0) {
            start[0] = input[0];
            start[1] = input[1];
        }
        if (i != 0 && comp(before, input)) ans = true;
        if (map[input[0] - 'A'][input[1] - '1']) ans = true;
        map[input[0] - 'A'][input[1] - '1'] = true;
        before[0] = input[0];
        before[1] = input[1];
    }
    if (comp(start, input)) ans = true;
    if (ans) cout << "Invalid";
    else cout << "Valid";
}

int main()
{
    init();
    solve();
}