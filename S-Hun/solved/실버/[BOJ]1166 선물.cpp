#include<iostream>

using namespace std;
typedef long long ll;

int main(){
	ll N, L, W, H;
	double l = 0, r = 1'000'000'000, m;
	cin >> N >> L >> W >> H;
	for(int i=0; i<100; i++) {
		m = (l+r) / 2;
		if(ll(L/m)*ll(W/m)*ll(H/m) < N) r = m;
		else l = m;
	}
	printf("%.10lf", m);
}