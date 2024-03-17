//Uva 10721
/*
https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/10721.pdf
*/
#include <iostream>
#include <string>
#include <sstream>

using namespace std;

long long nCk(int N, int M) {
    long long ret = 1;
    for(int i = 1; i <= M; ++i) {
        ret *= (N - M + i) / i;
    }
    return ret;
}

int main(){
    clock_t start = clock();
    ostringstream oss;
    string line;
	int n, k, m;
	while(getline(cin, line)){
        if (line.empty()) break;
		stringstream ss(line);
		ss >> n >> k >> m;
		if(n > m*k){
			oss << 0 << endl;
			continue;
		}
		//Use combination with repetition
		/*
		n : balls
		k : boxes
		m : upper bound of each box
		We would like to find the number of integer solutions => x1 + x2 + ... + xk = n (1 <= xi <= m)
		
		First, allocate one ball to every box. Then, remaining n-k balls.
		The equation => y1 + y2 + ... + yk = n-k (0 <= yi <= m-k)
		sol = C(n-k + k-1,k-1) - C(k,1)C(n-k -m +k-1,k-1) + C(k,2)C(n-k -2*m +k-1,k-1) - ... (by principle of inclusion-exclusion)
		*/
		long long ret = nCk(n-1, k-1);
		for(int i = 1; n-k >= i*m; ++i){
			ret += (i%2==0 ? nCk(k,i)*nCk(n-i*m-1,k-1) : (-1)*nCk(k,i)*nCk(n-i*m-1,k-1));
		}
		oss << ret << endl;
	}
    cout << oss.str();
    clock_t end = clock();
    double duration = (double)(end - start) / (__clock_t)1000;
    cout << endl << "Exicution Time: " << duration << " ms" << endl;
    return 0;
}
/* https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva10721a.php
7 4 3
7 4 2
1 1 1
2 1 1
4 3 2
5 4 2
6 5 2
7 3 2
7 5 3
1 50 1
1 1 50
10 6 3
20 5 8
30 10 9
37 14 8
49 15 4
50 30 12
50 10 44
50 50 50
50 30 20
*/
/* https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva10721b.php
7 4 3
7 4 2
1 50 1
1 1 50
3 50 3
3 3 50
40 3 50
30 3 50
30 20 10
20 10 3
45 18 7
38 23 3
9 4 3
9 4 4
50 50 50
50 10 38
47 3 45
12 8 3
50 29 20
43 17 3
*/