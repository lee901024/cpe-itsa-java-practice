package p6_10130;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T,N,G,total;
		int[] P,W,MW;
		int[][] V;
		
		T = sc.nextInt();
		while(T--!=0) {
			N = sc.nextInt();
			P = new int[N+1];
			W = new int[N+1];
			for(int i = 1; i <= N; i++) {
				P[i] = sc.nextInt();
				W[i] = sc.nextInt();
			}
			G = sc.nextInt();
			MW = new int[G];
			for(int i = 0; i < G; i++) {
				MW[i] = sc.nextInt();
			}
			total = 0;
			for(int k = 0; k < G; k++) {
				V = new int[P.length][MW[k]+1];
				for(int i = 1; i < P.length; i++) {
					for(int j = 1; j <= MW[k]; j++) {
						if(j>=W[i] && V[i-1][j-W[i]]+P[i]>V[i-1][j]) {
							V[i][j] = V[i-1][j-W[i]]+P[i];
						}else {
							V[i][j] = V[i-1][j];
						}
					}
				}
				total += V[P.length-1][MW[k]];
			}
			System.out.println(total);
		}
		sc.close();
	}
}
/*
2
3
72 17
44 23
31 24
1
26
6
64 26
85 22
52 4
99 18
39 13
54 9
4
23
20
20
26

*/