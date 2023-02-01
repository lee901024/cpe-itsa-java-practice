package p1_11498;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K,N,M,X,Y;
		while(true) {
			K = sc.nextInt();
			if(K==0)break;
			N = sc.nextInt();
			M = sc.nextInt();
			while(K--!=0) {
				X = sc.nextInt();
				Y = sc.nextInt();
				if(X-N<0 && Y-M>0) {
					System.out.println("NO");
				}else if(X-N>0 && Y-M>0) {
					System.out.println("NE");
				}else if(X-N>0 && Y-M<0) {
					System.out.println("SE");
				}else if(X-N<0 && Y-M<0) {
					System.out.println("SO");
				}else {
					System.out.println("divisa");
				}
			}
		}
		sc.close();
	}
}

/*
3
2 1
10 10
-10 1
0 33
4
-1000 -1000
-1000 -1000
0 0
-2000 -10000
-999 -1001
10
0 0
0 0
0 -1
0 1
1 0
-1 0
1 1
-1 0
-1 1
1 -1
-1 -1
5
5 97
88 -21
5 -44
4 -20
55 2
40 -77
5
-24 -10
-24 99
-10 69
-37 35
-90 -40
75 -21
5
-72 71
-26 93
-19 -39
96 7
-61 -78
-42 53
10
8445 -167
8138 8586
7476 847
-1243 7232
-2014 2815
-9316 -5751
8445 -4514
-276 1228
5023 1562
-8611 4626
-6253 -9562
10
-7115 6361
-4931 6361
-7115 -8496
-3956 6361
-1017 8359
-269 6361
-7115 6361
-7115 -5057
-7115 3007
-7115 6361
8443 -1110
12
7475 4481
-1625 -7044
3142 -3245
2262 4481
3919 -9421
7858 7716
7475 -1857
-9294 4481
-3486 2564
-329 6544
6881 4481
-1234 1234
6666 7777
0

*/