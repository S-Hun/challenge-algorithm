// level 2, 요격 시스템, https://school.programmers.co.kr/learn/courses/30/lessons/181188?language=cpp
#include <string>
#include <vector>
#include <algorithm>
// #include <iostream>

using namespace std;

int solution(vector<vector<int>> targets) {
    int answer = 0;
    sort(targets.begin(), targets.end(), [](vector<int> a, vector<int> b) -> bool {
        if(a[0] == b[0]) return a[1] < b[1];
        else return a[0] < b[0];
    });
    int left = -1, right = -1;
    for(auto vec : targets)
    {
        if(left == -1 && right == -1)
        {
            left = vec[0];
            right = vec[1];
            answer += 1;
        }
        
        if(vec[0] < right)
        {
            left = max(left, vec[0]);
            right = min(right, vec[1]);
        }
        else
        {
            left = vec[0];
            right = vec[1];
            answer += 1;
        }
    }
    return answer;
}