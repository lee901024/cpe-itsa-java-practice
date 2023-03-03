package p1_11677;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H1,M1,H2,M2,m;
		
		while(true) {
			H1 = sc.nextInt();
			M1 = sc.nextInt();
			H2 = sc.nextInt();
			M2 = sc.nextInt();
			if(H1==0&&M1==0&&H2==0&&M2==0)break;
			m = (H2-H1)*60+(M2-M1);
			if(m<0) {
				m += 24*60;
			}
			System.out.println(m);
		}
	}
}

/*
1 5 3 5
23 59 0 34
21 33 21 10
0 0 0 0

*/