package p7_10583_ex;
import java.util.Scanner;

public class Main {
	public static int[] ReliRoots;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m,Case=1,x,y,reliNum;
		
		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();
			if(n==m&&n==0)break;
			ReliRoots = new int[n+1];
			reliNum = n;
			for(int i = 1; i <= n; i++) {
				ReliRoots[i] = i;
			}
			for(int i = 0; i < m; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				x = findRoot(x);
				y = findRoot(y);
				if(x!=y) {
					reliNum--;
					ReliRoots[x] = y;
				}
			}
			System.out.printf("Case %d: %d\r\n",Case++,reliNum);
		}
		sc.close();
	}
	public static int findRoot(int n) {
		if(ReliRoots[n]==n) {
			return n;
		}
		ReliRoots[n] = findRoot(ReliRoots[n]);
		return ReliRoots[n];
	}
}
/*
10 9
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
10 4
2 3
4 5
4 8
5 8
0 0

*/