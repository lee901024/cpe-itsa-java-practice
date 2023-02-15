package p1_10268;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,n,y;
		String s;
		String[] ss;

		while(sc.hasNext()) {
			x = sc.nextInt();sc.nextLine();
			s = sc.nextLine();
			ss = s.split("\\s+");
			n = ss.length-1;
			y = 0;
			for(int i = 0; i < n; i++) {
				y += Integer.parseInt(ss[i])*(n-i)*(int)Math.pow(x, n-i-1);
			}
			System.out.println(y);
		}
		sc.close();
	}
}
