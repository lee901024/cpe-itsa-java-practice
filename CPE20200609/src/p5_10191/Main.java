package p5_10191;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

class Appointment implements Comparable<Appointment>{
	public int startH,startM,endH,endM;
	public Appointment(int _startH, int _startM, int _endH, int _endM) {
		startH  = _startH;
		startM = _startM;
		endH = _endH;
		endM = _endM;
	}
	@Override
	public int compareTo(Appointment o) {
		// TODO Auto-generated method stub
		if(this.startH<o.startH) {
			return -1;
		}else if(this.startH>o.startH) {
			return 1;
		}else {
			if(this.startM<o.startM) {
				return -1;
			}else if(this.startM>o.startM){
				return 1;
			}else {
				return 0;
			}
		}
	}
}
class Nap{
	public int H,M,time;
	public Nap(int _H, int _M, int _time) {
		H = _H;
		M = _M;
		time = _time;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k=1,s,t,h,m;
		String line;
		String[] part;
		List<Appointment> day;
		List<Nap> nap;
		
		while(sc.hasNext()) {
			s = sc.nextInt();sc.nextLine();
			day = new ArrayList<>();
			nap = new ArrayList<>();
			for(int i = 0; i < s; i++) {
				line = sc.nextLine();
				part = line.split("\\s+");
				day.add(new Appointment(Integer.parseInt(part[0].substring(0,2)),Integer.parseInt(part[0].substring(3,5))
						,Integer.parseInt(part[1].substring(0,2)),Integer.parseInt(part[1].substring(3,5))));
			}
			Collections.sort(day);
			t = (day.get(0).startH-10)*60+(day.get(0).startM-0);
			if(t>0) {
				nap.add(new Nap(10,0,t));
			}
			for(int i = 0; i < day.size(); i++) {
				if(i == day.size()-1) {
					t = (18-day.get(i).endH)*60+(00-day.get(i).endM);
				}else {
					t = (day.get(i+1).startH-day.get(i).endH)*60+(day.get(i+1).startM-day.get(i).endM);
				}
				if(t>0) {
					nap.add(new Nap(day.get(i).endH,day.get(i).endM,t));
				}
			}
			Collections.sort(nap,new Comparator<Nap>() {
				@Override
				public int compare(Nap a, Nap b) {
					return b.time-a.time;
				}
			});
			h = nap.get(0).time/60;
			m = nap.get(0).time%60;
			if(h>0) {
				System.out.printf("Day #%d: the longest nap starts at %2d:%02d and will last for %d hours and %d minutes.\r\n", k++, nap.get(0).H, nap.get(0).M,h,m);
			}else {
				System.out.printf("Day #%d: the longest nap starts at %2d:%02d and will last for %d minutes.\r\n", k++, nap.get(0).H, nap.get(0).M,m);
			}
		}
		sc.close();
	}
}
/*
4
10:00 12:00 Lectures
12:00 13:00 Lunch, like always.
13:00 15:00 Boring lectures...
15:30 17:45 Reading
4
10:00 12:00 Lectures
12:00 13:00 Lunch, just lunch.
13:00 15:00 Lectures, lectures... oh, no!
16:45 17:45 Reading (to be or not to be?)
4
10:00 12:00 Lectures, as everyday.
12:00 13:00 Lunch, again!!!
13:00 15:00 Lectures, more lectures!
15:30 17:15 Reading (I love reading, but should I schedule it?)
1
12:00 13:00 I love lunch! Have you ever noticed it? :)

*/