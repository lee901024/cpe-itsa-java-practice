package p4_12918;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(),n,m;
		long ans;
		
		while(T--!=0) {
			n = sc.nextInt();
			m = sc.nextInt();
			ans = (long)((m-n)+(m-1))*(long)n;
			System.out.printf("%d\r\n", ans/2);
		}
		sc.close();
	}
}
/*
3
4 6
1 2
500 900

*/
//https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva12918a.php
//https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva12918b.php