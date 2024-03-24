/*
https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/10161.pdf
*/
/*
another solutions:
https://zerojudge.tw/ShowProblem?problemid=c048
*/
#include <iostream>
#include <sstream>
#include <cmath>
//#include <bits/stdc++.h>

using namespace std;

int main(){
    clock_t start = clock();
    ostringstream oss;

    int N;
    while(true){
        cin >> N;
        if(N==0) break;

        /*find the largest perfect square number(mid) which mid*mid <= N*/
        //method 1
        // int left = 1, right = N;
        long long mid,tmp;
        // while (left <= right) {
        //     mid = (left + right) / 2;
        //     tmp = mid*mid;
        //     if(tmp > N){
        //         right = mid - 1;
        //     }else if(tmp < N){
        //         left = mid + 1;
        //     }else{
        //         break;
        //     }
        // }
        // if(tmp > N){
        //     mid -= 1;
        // }
        //method 2
        double sqrtN = sqrt(N);
        mid = (long long) sqrtN;
        /*
        An odd perfect square number(1,9,25,...) is at (sqrt(N), 1).
        An even perfect square number(4,16,36,...) is at (1, sqrt(N)).
        If sqrt(N) is odd, then up(1), right(sqrt(N)), down(sqrt(N)) steps.
        If sqrt(N) is even, then right(1), up(sqrt(N)), left(sqrt(N)) steps.
        */
        int x = 1, y = 1;
        tmp = mid * mid;
        if(mid&1){//odd
            y = mid;
            if(tmp < N){
                ++y;
                ++tmp;
            }
            for(int i = 0; tmp < N && i < mid; ++i){
                ++x;
                ++tmp;
            }
            for(int i = 0; tmp < N && i < mid; ++i){
                --y;
                ++tmp;
            }            
        }else{//even
            x = mid;
            if(tmp < N){
                ++x;
                ++tmp;
            }
            for(int i = 0; tmp < N && i < mid; ++i){
                ++y;
                ++tmp;
            }
            for(int i = 0; tmp < N && i < mid; ++i){
                --x;
                ++tmp;
            }
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

/*https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva10161a.php
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

/*https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva10161b.php
16
28
76
87
120
128
111
121
1341
12234
14589
926485
2589746
86238342
8754793
73734
9788377
227996540
55776611
77289652
283898399
1276373727
882323344
882877333
2000000000
0
*/