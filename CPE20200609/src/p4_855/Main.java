package p4_855;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int S,A,F,cost,mincost,mps=0,mpa=0;
		int[] street,avenue;
		
		while(T--!=0) {
			S = sc.nextInt();
			A = sc.nextInt();
			F = sc.nextInt();
			street = new int[F];
			avenue = new int[F];			
			for(int i = 0; i < F; i++) {
				street[i] = sc.nextInt();
				avenue[i] = sc.nextInt();			
			}
			mincost = 9999999;
			for(int s = 1; s <= S; s++) {
				for(int a = 1; a <= A; a++) {
					cost = 0;
					for(int j = 0; j < F; j++) {
						cost += Math.abs(street[j]-s);
						cost += Math.abs(avenue[j]-a);							
					}
					if(cost < mincost) {
						mincost = cost;
						mps = s;
						mpa = a;						
					}
				}
			}
			System.out.printf("(Street: %d, Avenue: %d)\r\n",mps,mpa);
		}
		sc.close();
	}
}
/*
2
2 2 2
1 1
2 2
7 7 11
1 2
1 7
2 2
2 3
2 5
3 4
4 2
4 5
4 6
5 3
6 5
  
 */
