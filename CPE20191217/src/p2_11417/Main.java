package p2_11417;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,sum;
		
		while(true) {
			N = sc.nextInt();
			if(N==0)break;
			sum = 0;
			for(int i = 1; i < N; i++) {
				for(int j = i+1; j <= N; j++) {
					sum += gcd(i,j);
				}
			}
			System.out.println(sum);
		}
	}
	public static int gcd(int a, int b) {
		if(a%b==0)return b;
		return gcd(b,a%b);
	}
}
