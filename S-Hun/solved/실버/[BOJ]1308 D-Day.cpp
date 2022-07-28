#include<iostream>

using namespace std;
int month_days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
struct date {
    int year = 0;
    int month = 0;
    int day = 0;

    bool isleap(int y) {
        if (y % 400 == 0) return true;
        else if (y % 100 == 0) return false;
        else if (y % 4 == 0) return true;
        else return false;
    }

    int toValue() {
        int ans = 0;
        for (int i = 1; i < year; i++) {
            if (isleap(i)) ans += 366;
            else ans += 365;
        }
        for (int i = 1; i < month; i++) {
            if (i == 2 && isleap(year)) ans += 29;
            else ans += month_days[i-1];
        }
        ans += day - 1;
        return ans;
    }

    void setValue(int v) {
        year = 1;
        month = 1;
        day = 1;
        while (v > 0) {
            if (!isleap(year) && v >= 365) { year += 1; v -= 365; }
            else if (isleap(year) && v >= 366) { year += 1; v -= 366; }
            else if (v >= month_days[month-1]) { v -= month_days[month-1]; month += 1; }
            else { day += v; v = 0; }
        }
    }
};
date s, e;

void init() {
    cin >> s.year >> s.month >> s.day;
    cin >> e.year >> e.month >> e.day;
}

void solve() {
    //date test{ 1, 2, 1 };
    //cout << test.toValue() << '\n';
    date cmp{ s.year + 1000, s.month, s.day };
    if (e.toValue() >= cmp.toValue()) cout << "gg";
    else cout << "D-" << e.toValue() - s.toValue();
}

int main()
{
    init();
    solve();
}