package p2_263;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long original_num,n,des,asc,new_num;
		List<Long> orig_num;
		int chain_length;
		List<Integer> digits;
		boolean flag; 
		
		while(true) {
			original_num = sc.nextLong();
			if(original_num==0)break;
			System.out.printf("Original number was %d\r\n", original_num);
			orig_num = new ArrayList<>();
			orig_num.add(original_num);
			chain_length = 0;
			while(true){
				digits = new ArrayList<>();
				n = original_num;
				while(n!=0) {
					digits.add((int) (n%10));
					n/=10;
				}
				des = 0;
				asc = 0;
				Collections.sort(digits,new Comparator<Integer>() {
					@Override
					public int compare(Integer a, Integer b) {
						return a-b;
					}
				});
				for(int i = 0; i < digits.size(); i++) {
					des += (long)digits.get(i)*(long)Math.pow(10, i);
					asc += (long)digits.get(i)*(long)Math.pow(10, digits.size()-i-1);
				}
				new_num = des - asc;
				System.out.printf("%d - %d = %d\r\n", des, asc, new_num);
				chain_length++;
				flag = false;
				for(long l : orig_num) {
					if(new_num==l) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					original_num = new_num;
					orig_num.add(new_num);
				}else {
					System.out.printf("Chain length %d\r\n\r\n",chain_length);
					break;
				}
			}
		}
		sc.close();
	}
}
