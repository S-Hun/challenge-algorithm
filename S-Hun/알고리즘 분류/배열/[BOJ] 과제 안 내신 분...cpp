#include<iostream>
#include<vector>

bool stu[30];

int main(){
    int n;
    for(int i=0; i<30; i++) {
        scanf("%d", &n);
        stu[n-1] = true; 
    }
        
    for(int i=0; i<30; i++) {
        if(!stu[i]) printf("%d\n", i+1);
    }
}