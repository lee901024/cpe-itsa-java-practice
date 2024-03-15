/*
https://vjudge.net/problem/UVA-12546
*/
#include <algorithm>
#include <iostream>
#include <vector>
#include <utility>
#include <sstream>

using namespace std;

long long pow(int base, int exponent) {
    long long result = 1;
    for (int i = 0; i < exponent; i++) {
        result *= base;
    }
    return result;
}

static const long long mod = 1000000007LL;

int main(){
    // clock_t start = clock();

    ostringstream oss;
	int T,C;
	cin >> T;
	for(int t = 1; t <= T; ++t){
		cin >> C;
		vector<pair<int, int>> factors; //<pi, ai>
		for(int i = 0; i < C; ++i){
			int p, a;
			cin >> p >> a;
			factors.push_back({p, a});
		}
		
		long long n = 1LL;
		long long sum = 1LL; // sum = f(n) = ∏(pi^0 + pi^1 + ... + (ai + 1)*pi^ai) + n
		for(pair<int, int>& factor : factors){
			n *= pow(factor.first, factor.second);
			long long tmp = 0LL;
			for(int exp = 0; exp < factor.second; ++exp){
				tmp += pow(factor.first, exp);
			}
			tmp += (long long)(factor.second + 1) * pow(factor.first, factor.second);
			sum *= tmp;
		}
		sum += n;
        oss << "Case " << t << ": " << (sum % mod) << endl;
	}
    cout << oss.str();
    
    // clock_t end = clock();
    // double duration = (double)(end - start) / (__clock_t)1000;
    // std::cout << std::endl << "Exicution Time: " << duration << " ms" << std::endl;

	return 0;
}
/*
15
2
2 1
3 1
2
2 2
3 1
1
5 1
1
5 4
2
2 3
3 3
2
2 4
3 4
3
5 2
2 2
3 2
3
2 3
3 3
5 3
3
2 4
3 4
5 4
4
2 2
3 3
5 2
7 3
4
2 3
3 4
5 3
7 4
5
2 2
3 2
5 3
7 3
11 3
5
2 4
3 4
5 2
7 3
11 4
5
2 4
3 4
5 4
7 4
11 4
5
11 4
3 4
5 4
7 4
2 4
*/

/*
15
2
5 1
3 1
2
5 2
3 1
1
11 1
1
11 4
2
2 3
5 3
2
2 4
5 4
3
7 2
2 2
3 2
3
2 3
5 3
7 3
3
2 4
3 4
11 4
4
2 3
3 3
5 2
7 2
4
2 3
3 3
5 4
7 4
5
2 2
3 2
5 2
7 3
11 3
5
2 4
3 3
5 2
7 3
11 4
5
2 3
3 4
5 4
7 4
11 4
5
11 4
3 4
5 4
7 4
2 3
*/