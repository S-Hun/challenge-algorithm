#include<iostream>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int N, arr[1'050];
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        int ans = 0, rooms = 0;
		cout << "#" << test_case << " ";
        cin >> N;
        for(int i=2; i<N+2; i++) cin >> arr[i];
        arr[N+2] = arr[N+3] = 0;
        for(int i=2; i<N+2; i++) {
            rooms = max(0, arr[i] - arr[i-2]);
            rooms = min(rooms, max(0, arr[i] - arr[i-1]));
            rooms = min(rooms, max(0, arr[i] - arr[i+1]));
            rooms = min(rooms, max(0, arr[i] - arr[i+2]));
            ans += rooms;
        }
        cout << ans << "\n";

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}