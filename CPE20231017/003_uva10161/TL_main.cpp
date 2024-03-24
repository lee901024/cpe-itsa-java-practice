#include <iostream>
#include <sstream>
//#include <bits/stdc++.h>

using namespace std;

int main(){
    clock_t start = clock();
    ostringstream oss;

    int N;
    while(true){
        cin >> N;
        if(N==0) break;
        int x = 1, y = 1, step = 1, stage = 0;
        bool case0upper = true;
        int incriment = 1, cnt1, cnt2;
        bool case1right = true;
        bool case2down = true;
        while(step < N){
            switch(stage){
            case 0:
                if(case0upper){
                    y += 1;
                }else {
                    x += 1;
                }
                case0upper = !case0upper;
                stage = 1;
                cnt1 = 0;
                break;
            case 1:
                if(case1right){
                    x += 1;
                }else{
                    y += 1;
                }
                if(++cnt1==incriment){
                    case1right = !case1right;
                    cnt2 = 0;
                    stage = 2;
                }
                break;
            case 2:
                if(case2down){
                    y -= 1;
                }else{
                    x -= 1;
                }
                if(++cnt2==incriment){
                    case2down = !case2down;
                    ++incriment;
                    stage = 0;
                }
                break;
            }
            ++step;
        }
        oss << x << " " << y << endl;
    }

    cout << oss.str();
    clock_t end = clock();
    double duration = (double)(end - start) / (__clock_t)1000;
    cout << endl << "Exicution Time: " << duration << " ms" << endl;
    return 0;
}
/*
8
20
25
0
*/
/*
8
20
25
1
2
3
4
5
6
7
9
10
14
17
50
89
128
3934
82883
282399
9923882
23882833
23837832
10000000
288776612
1005500000
1108000000
2000000000
0
*/