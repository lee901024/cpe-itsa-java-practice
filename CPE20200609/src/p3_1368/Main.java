package p3_1368;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int m,n,max,index,err;
		int[] acgt;
		String[] lists;
		char[] cs;
		char tmp;
		
		while(T--!=0) {
			m = sc.nextInt();
			n = sc.nextInt();sc.nextLine();
			lists = new String[m];
			for(int i = 0; i < m; i++) {
				lists[i] = sc.nextLine();
			}
			cs = new char[n];
			err = 0;
			for(int i = 0; i < n; i++) {
				acgt = new int[4];
				for(int j = 0; j < m; j++) {
					tmp = lists[j].charAt(i);
					switch(tmp) {
					case 'A':acgt[0]++;break;
					case 'C':acgt[1]++;break;
					case 'G':acgt[2]++;break;
					case 'T':acgt[3]++;break;
					default:break;
					}
				}
				max = 0;
				index = 0;
				for(int j = 0; j < 4; j++) {
					if(acgt[j]>max) {
						max = acgt[j];
						index = j;
					}
				}
				err += m-max;
				switch(index) {
				case 0:cs[i] ='A';break;
				case 1:cs[i] ='C';break;
				case 2:cs[i] ='G';break;
				case 3:cs[i] ='T';break;
				default:cs[i] ='E';break;
				}
			}
			System.out.println(new String(cs));
			System.out.println(err);
		}
		sc.close();
	}
}
/*
3
5 8
TATGATAC
TAAGCTAC
AAAGATCC
TGAGATAC
TAAGATGT
4 10
ACGTACGTAC
CCGTACGTAG
GCGTACGTAT
TCGTACGTAA
6 10
ATGTTACCAT
AAGTTACGAT
AACAAAGCAA
AAGTTACCTT
AAGTTACCAA
TACTTACCAA

 */
