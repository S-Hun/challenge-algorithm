#include <string>
#include <vector>

using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    long long l = 1, r = 1'000'000'000'000'000'000;
    while(l<=r) {
        long long mid = (l+r) / 2;
        long long sum = 0;
        for(auto& time : times) {
            sum += mid / time;
            if(sum >= n) break;
        }
        if(sum >= n) {
            answer = mid;
            r = mid - 1;
        } else l = mid + 1;
    }
    return answer;
}