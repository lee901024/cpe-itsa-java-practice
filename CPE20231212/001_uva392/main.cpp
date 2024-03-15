#include <iostream>
#include <ostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

int myabs(int n){
	int mask = n>>31;
	return (n+mask)^mask;
}

int main(){
	string line;
  
  	while(getline(cin,line)){
  		stringstream ss(line);
  		int num;
  		bool isFirst = true;
  		for(int i = 0; i < 9; i++){
  			ss >> num;
  			if(num==0){
  				if(i==8&&isFirst){
  					cout << num;
  				}
  				continue;
  			}
  				/*sign*/
  			if(isFirst){
  				if(i==8){
  					cout << num;
  					break;
  				}
  				if(num < 0) cout << "-";
  				isFirst = false;
  			}else{
  				cout << (num > 0 ? " + " : " - ");
  			}
  				/*coef*/
  			num = myabs(num);
  			if(num!=1 || i==8){
  				cout << num;
  			}
  				/*exponent*/
  			if(i==7){
  				cout << "x";
  			}else if(i < 7){
  				cout << "x^" << 8-i;
  			}
  		}
  		cout << endl;
  	}
  	return 0;
}

/*
0 0 0 1 22 -333 0 1 -1
0 0 0 0 0 0 -55 5 0
-1 0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1
0 0 1 0 0 1 0 -1 0
0 -999 100 0 -500 1 0 -1 0
9 8 7 6 5 4 3 2 1
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 -7 30 66
0 0 0 0 0 0 1 -3 0
0 0 0 0 0 -1 1 3 -1
-5 0 0 0 -243 0 0 0 -9
-0 -1 -1 -1 -1 -1 -1 -1 -1
*/
