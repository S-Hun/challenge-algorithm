#include<iostream>

using namespace std;

int main(){
    int temp, sum = 0;
    for(int i=0; i<5; i++) {
        cin >> temp;
        sum += temp * temp;
    }
    cout << sum % 10;
}