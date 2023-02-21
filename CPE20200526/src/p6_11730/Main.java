package p6_11730;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	public int number;
	public int depth;
	public Node(int n, int d) {number = n; depth = d;}
}
public class Main {
	public static boolean[] prime = new boolean[1001];
	public static boolean[] visited;
	public static boolean isPrime(int n) {
		for(int i = 2; i < n/2; i++) {
			if(n%i==0)return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Node> queue;
		int n=1,S,T,now,next,step;
		boolean flag;
		
		//initial prime array (isPrime -> true)
		prime[2] = true;
		for(int i = 3; i < prime.length; i+=2) {
			if(isPrime(i))prime[i] = true;
		}
		
		while(true) {
			S = sc.nextInt();
			T = sc.nextInt();
			if(S==T&&S==0)break;
			queue = new LinkedList<>();
			queue.add(new Node(S,0));
			visited = new boolean[1001];
			visited[S] = true;
			flag = false;
			while(!queue.isEmpty()) {
				now = queue.element().number;
				step = queue.element().depth;
				queue.remove();
				if(now==T) {
					flag = true;
					System.out.printf("Case %d: %d\r\n", n++, step);
					break;
				}
				for(int i = 2; i < now; i++) {//2~now-1 (exclude 1 now)
					if(prime[i]&&now%i==0) {
						next = now + i;
						if(next<=T && !visited[next]) {
							visited[next] = true;
							queue.add(new Node(next,step+1));
						}
					}
				}
//				if(flag)break;
			}
			if(!flag) {
				System.out.printf("Case %d: -1\r\n", n++);
			}
		}
		sc.close();
	}
}
