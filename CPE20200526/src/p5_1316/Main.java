package p5_1316;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Prod{
	public int p;
	public int d;
	public Prod(int _p, int _d) {
		p = _p; d = _d;
	}
}
public class Main {
	public static int[] day;
	public static int find(int i) {
		if(day[i]==-1) {
			return i;
		}else {
			day[i] = find(day[i]);
			return day[i];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,ans,max;
		
		List<Prod> products;
		
		while(sc.hasNext()) {
			n = sc.nextInt();
			products = new ArrayList<>();			
			for(int i = 0; i < n; i++) {
				products.add(new Prod(sc.nextInt(), sc.nextInt()));
			}
			max = 0;
			for(Prod p : products) {
				if(p.d>max)max = p.d;
			}
			day = new int[max+1];
			for(int i = 0; i < max+1; i++) {
				day[i] = -1;
			}
			Collections.sort(products, new Comparator<Prod>() {
				@Override
				public int compare(Prod a, Prod b) {
					return b.p - a.p;
				}
			});
			ans = 0;
			for(int i = 0; i < n; i++) {
				int sd = find(products.get(i).d);//sold out day(choose latest one)
				if(sd!=0) {
					ans += products.get(i).p;
					day[sd] = sd-1;
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
/*
4 50 2 10 1 20 2 30 1
7 20 1 2 1 10 3 100 2 8 2 5 20 50 10

https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva1316a.php
https://cpe.cse.nsysu.edu.tw/cpe/file/attendance/problemPdf/testData/uva1316b.php
*/