package p4_10336;
import java.util.Scanner;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int H,W;
	static char[][] map;
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int[] cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 1;
		int N = sc.nextInt();
		String s;
		while(N--!=0) {
			H = sc.nextInt();
			W = sc.nextInt();sc.nextLine();
			map = new char[H][W];
			for(int i = 0; i < H; i++) {
				s = sc.nextLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			cnt = new int[26];
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j]!='0') {
						bfs(i,j);
					}
				}
			}
			System.out.printf("World #%d\r\n", n++);
			int mx = 0;
			for(int i = 0; i < 26; i++) {
				if(cnt[i]>mx)mx=cnt[i];
			}
			while(mx!=0) {
				for(int i = 0; i < 26; i++) {
					if(mx==cnt[i]) {
						System.out.printf("%s: %d\r\n",(char)('a'+i),cnt[i]);
					}
				}
				mx--;
			}
		}
	}
	
	public static void bfs(int x, int y) {
		Vector<Integer> coor = new Vector<Integer>(2);
		coor.add(x); coor.add(y);
		Queue<Vector<Integer>> queue = new LinkedList<Vector<Integer>>();
		queue.add(coor);
		char target = map[x][y];
		map[x][y] = '0';
		while(!queue.isEmpty()) {
			Vector<Integer> now = new Vector<Integer>(2);
			now = queue.poll();
			x = now.elementAt(0);
			y = now.elementAt(1);
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]==target) {
					Vector<Integer> tmp = new Vector<Integer>(2);
					tmp.add(nx); tmp.add(ny);
					queue.offer(tmp);
					map[nx][ny]='0';
				}
			}
		}
		cnt[target-'a']++;
	}
}

/*
2
4 8
ttuuttdd
ttuuttdd
uuttuudd
uuttuudd
9 9
bbbbbbbbb
aaaaaaaab
bbbbbbbab
baaaaacab
bacccccab
bacbbbcab
bacccccab
baaaaaaab
bbbbbbbbb

 */