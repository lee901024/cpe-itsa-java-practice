package p2_10189;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f=0,n,m,cnt;
		String s;
		char[][] map;
		int[] dx = {-1,0,1,1,1,0,-1,-1};
		int[] dy = {-1,-1,-1,0,+1,+1,+1,0};
		
		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();sc.nextLine();
			if(n==m&&n==0)break;
			f++;
			map = new char[n][m];
			for(int i = 0; i < n; i++) {
				s = sc.nextLine();
				for(int j = 0; j < m; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j]=='*')continue;
					cnt = 0;
					for(int k = 0; k < 8; k++) {
						if(i+dx[k]>=0 && i+dx[k]<n && j+dy[k]>=0 && j+dy[k]<m) {
							if(map[i+dx[k]][j+dy[k]]=='*') {
								cnt++;
							}
						}
					}
					map[i][j] = Character.forDigit(cnt, 10);
					//map[i][j] = (char)(cnt + '0');
				}
			}
			if(f==1) {
				System.out.printf("Field #%d:\r\n",f);
			}else {
				System.out.println();
				System.out.printf("Field #%d:\r\n",f);
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}
}

/*
4 4
*...
....
.*..
....
3 5
**...
.....
.*...
0 0

 */