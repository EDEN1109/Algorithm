import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class IntervalScheduling {
	private Interval[] interval_list;
	private final Random rand = new Random();

	public IntervalScheduling(int total) {
		interval_list = new Interval[total];
		getInput();
		printInput();
		intervalSchedule();
	}

	public void getInput() {
		int sTime;
		int eTiem;

		for(int i=0;i<interval_list.length;i++) {
			sTime = rand.nextInt(10);
			eTiem = sTime+rand.nextInt(10)+1;
			interval_list[i] = new Interval(i, sTime, eTiem);
		}
	}

	public void printInput() {
		for(int i=0;i<interval_list.length;i++) {
			System.out.println(interval_list[i].toString());
		}
		System.out.print("\n");
	}

	public void intervalSchedule() {
		Arrays.sort(interval_list);

		LinkedList<Interval> intervalsSelected = new LinkedList<Interval>();
		intervalsSelected.add(interval_list[0]);
		Interval lastIntervalAdded = interval_list[0];

		for(int i=1; i<interval_list.length; i++){
			if(interval_list[i].getsTime() >= lastIntervalAdded.geteTime()){
				intervalsSelected.add(interval_list[i]);
				lastIntervalAdded = interval_list[i];
			}
		}

		System.out.println("Solution");
		for(int i=0; i<intervalsSelected.size(); i++) {
			System.out.println(intervalsSelected.get(i).toString());
		}
		System.out.println("Maximum number of mutually compatible jobs = "+intervalsSelected.size());
	}
}