#include<iostream>
#include<string>
#include<algorithm>

using namespace std;
string input, ans;
int len;

void init(){
	cin >> input;    
	len = input.length();
} 

void divide(string s, int first, int second){    
	string A, B, C;    
	A = B = C = "";        
	for (int i = 0; i <= first; i++) 
		A = A + s[i];    
	
	for (int i = first + 1; i <= second; i++)
		B = B + s[i];    
	
	for (int i = second + 1; i < len; i++) 
		C = C + s[i];     
	
	reverse(A.begin(), A.end());   
	reverse(B.begin(), B.end());    
	reverse(C.begin(), C.end());     
	string temp = A + B + C;        
	if (ans == "") ans = temp;    
	else{        
	if (ans > temp) 
		ans = temp;    
}
} 
void solve() {        
	for (int i = 0; i < len-1; i++){        
		for (int j = i; j < len-1; j++){            
			if (i >= j) continue;            
			string temp = input;            
			divide(temp, i, j);        
		}    
	}    
	cout << ans << '\n';
}

int main(void) {
	init();
	solve();    
}
