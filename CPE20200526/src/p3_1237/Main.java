package p3_1237;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Product{
	public String name;
	public int low,high;
	public Product(String _name, int _low, int _high) {
		name = _name; low = _low; high = _high;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T,D,L,H,Q,P,index = -1,num;
		String s;
		String[] ss;
		List<Product> DB;
		
		T = sc.nextInt();
		while(T--!=0) {
			DB = new ArrayList<>();
			D = sc.nextInt();sc.nextLine();
			for(int i = 0; i < D; i++) {
				s = sc.nextLine();
				ss = s.split("\\s+");
				DB.add(new Product(ss[0],Integer.parseInt(ss[1]),Integer.parseInt(ss[2])));
			}
			Q = sc.nextInt();
			for(int i = 0; i < Q; i++) {
				P = sc.nextInt();
				num = 0;
				for(int j = 0; j < DB.size()&&num<2; j++) {
					Product p = DB.get(j);
					if(P>=p.low && P<=p.high) {
						index = j;
						num++;
					}
				}
				if(num==1) {
					System.out.println(DB.get(index).name);
				}else {
					System.out.println("UNDETERMINED");
				}
			}
			if(T!=0) {
				System.out.println();
			}
		}
	}
}
/*
1
4
HONDA 10000 45000
PEUGEOT 12000 44000
BMW 30000 75900
CHEVROLET 7000 37000
4
60000
7500
5000
10000

*/