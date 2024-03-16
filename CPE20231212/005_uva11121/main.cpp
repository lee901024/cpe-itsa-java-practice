/*
https://vjudge.net/problem/UVA-11121
*/
#include <iostream>
#include <bits/stdc++.h>
#include <sstream>
// #include <vector>
#include <string>

using namespace std;

int main() {
    // clock_t start = clock();

    ostringstream oss;
    int N;
    int b = -2;
    cin >> N;
    for (int tc = 1; tc <= N; ++tc) {
        int dec;
        cin >> dec;
        string bits;
        int tmp, q, r;
        while (true) {
            tmp = dec % b;
            q = (tmp < 0 ? dec / b + 1 : dec / b);
            r = (tmp < 0 ? tmp - b : tmp);
            if (q == 0 && r == 0)
                break;
            bits += static_cast<char>('0' + r);
            dec = q;
        }
        reverse(bits.begin(), bits.end());
        oss << "Case #" << tc << ": " << (bits.empty() ? "0" : bits) << endl;
    }
    cout << oss.str();

    // clock_t end = clock();
    // double duration = (double)(end - start) / (__clock_t)1000;
    // std::cout << std::endl << "Exicution Time: " << duration << " ms" << std::endl;

    return 0;
}

// int main() {
//     clock_t start = clock();
//     ostringstream oss;
//     int N;
//     int b = -2;
//     cin >> N;
//     for (int tc = 1; tc <= N; ++tc) {
//         int dec;
//         cin >> dec;
//         vector<bool> bits;
//         int tmp, q, r;
//         while (true) {
//             tmp = dec % b;
//             q = (tmp < 0 ? dec / b + 1 : dec / b);
//             r = (tmp < 0 ? tmp - b : tmp);
//             if (q == 0 && r == 0)
//                 break;
//             bits.push_back(r);
//             dec = q;
//         }
//         oss << "Case #" << tc << ": ";
//         for (int i = bits.size() - 1; i >= 0; --i) {
//             oss << bits[i];
//         }
//         if (bits.empty())
//             oss << '0';
//         oss << endl;
//     }
//     cout << oss.str();
//     clock_t end = clock();
//     double duration = (double)(end - start) / (__clock_t)1000;
//     std::cout << std::endl << "Exicution Time: " << duration << " ms" << std::endl;
//     return 0;
// }
/*
https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva11121a.php
25
1
7
-2
0
4
8
16
32
64
-4
-8
-16
-32
536870912
-536870912
666666666
-666666666
777777777
-777777777
888888888
-888888888
999999999
-999999999
1000000000
-1000000000
*/
/*
https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva11121b.php
25
65535
0
-0
1
-1
2
-2
3
-3
9
-9
7168
-7168
20231111
-20231111
536870912
-536870912
666666667
-666666667
777777778
-777777778
888888889
-888888889
999999998
-999999998
*/