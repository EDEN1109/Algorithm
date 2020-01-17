import java.util.Arrays;
import java.util.Random;

public class JobScheduling {
	private int[] jobTime;
	private boolean[] slots;
	private Job[] job_list;
	private final Random rand = new Random();
	
	public JobScheduling(int total) {
		job_list = new Job[total];
		jobTime = new int[total];
		slots = new boolean[total];
		for(int i = 0; i<total ; i++) {
			slots[i] = false;
		}
		getInput();
		printInput();
		scheduleJobs();
		printSolution();
	}
	
	public void scheduleJobs() {
		Arrays.sort(job_list);
		for(int i=0;i<job_list.length;i++) {
			for(int j=Math.min(i, job_list[i].getDeadline()-1);j>=0;j--) {
				if(slots[j] == false) {
					jobTime[j] = i;
					slots[j] = true;
					break;
				}
			}
		}
	}
	public void printSolution() {
		System.out.println("Optimal Solution");
		int totprofit=0;
		for(int i=0;i<job_list.length;i++) {
			if(slots[i]) {
				totprofit = totprofit + job_list[jobTime[i]].getProfit();
				System.out.println(job_list[jobTime[i]].toString());
			}
		}
		System.out.println("Total profit = " + totprofit);
	}
	public void getInput() {
		int profit;
		int deadline;
		
		for(int i=0;i<job_list.length;i++) {
			profit = 1+rand.nextInt(50);
			deadline = 1+rand.nextInt(10);
			job_list[i] = new Job(i, deadline, profit);
		}
	}
	
	public void printInput() {
		for(int i=0;i<job_list.length;i++) {
			System.out.println(job_list[i].toString());
		}
		System.out.print("\n");
	}
}
