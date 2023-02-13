package p7_10583;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

class pair{
	public int[] stu;
	public boolean flag;
	public pair(int a, int b) {
		stu = new int[2];
		stu[0] = a;
		stu[1] = b;
		flag = false;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 0,n,m,num;
		ArrayList<pair> pairs;
		boolean[] flag;
		Stack<Integer> s = new Stack<>();;
		
		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();
			if(n==m&&n==0)break;
			num = 0;
			pairs = new ArrayList<>();
			flag = new boolean[n];
			for(int k = 0; k < m; k++) {
				pairs.add(new pair(sc.nextInt(),sc.nextInt()));
			}
			for(int k = 0; k < m; k++) {
				if(pairs.get(k).flag)continue;
				s.push(pairs.get(k).stu[0]);
				s.push(pairs.get(k).stu[1]);
				while(!s.isEmpty()) {
					int target = s.pop();
					flag[target-1] = true;
					for(int i = k+1; i < m; i++) {
						if(!pairs.get(i).flag&&pairs.get(i).stu[0]==target) {
							if(!s.contains(pairs.get(i).stu[1])) {
								s.push(pairs.get(i).stu[1]);							
								pairs.get(i).flag = true;
							}						
						}else if(!pairs.get(i).flag&&pairs.get(i).stu[1]==target) {
							if(!s.contains(pairs.get(i).stu[0])) {
								s.push(pairs.get(i).stu[0]);							
								pairs.get(i).flag = true;
							}
						}
					}
				}
				num++;
			}
			for(int i = 0; i < n; i++) {
				if(!flag[i])num++;
			}
			System.out.printf("Case %d: %d\r\n",++c,num);
		}
		sc.close();
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