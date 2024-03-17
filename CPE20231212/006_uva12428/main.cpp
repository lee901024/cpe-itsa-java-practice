/*
https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/12428.pdf
*/
#include <iostream>
#include <sstream>

using namespace std;

int main(){
    clock_t start = clock();

    ostringstream oss;
	int T;
	long long N, M;
	cin >> T;
	while(T--){
		cin >> N >> M; //We have M edges to allocate
		long long critical = N - 1; //First, allocate N-1 edges into the Graph and get N-1 critical edges
		//when e ==1 we need to sacrifice 2 critical edges, so I let e start from 0
		for(int e = 0; M > N-1; ++e){ // e : the num of edges to allocate in each iterate
			M -= e; //allocate
			critical -= 1;
		}
		oss << critical << endl;
    }
    cout << oss.str();

    clock_t end = clock();
    double duration = (double)(end - start) / (__clock_t)1000;
    std::cout << std::endl << "Exicution Time: " << duration << " ms" << std::endl;
	return 0;
}
/*https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva12428a.php
22
4 4
4 3
4 6
9 35
7 18
8 25
7 21
8 22
9 28
9 29
4 5
10 40
169 10947
670 77426
905 397824
172 5870
489 66875
66791 1968272196
74541 2622791774
76616 2668331179
53720 589083940
58305 876189551
*/


/*https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva12428b.php
20
10 40
7 19
10 45
8 25
5 8
7 15
7 16
10 38
5 7
9 30
688 165572
328 26403
304 37775
832 159935
305 46260
50518 879600803
78038 2969287894
63178 1104795149
52509 914298077
73565 2431932229
*/