
public class Job implements Comparable<Job>{
	private int jobnum;
	private int deadline;
	private int profit;

	
	public Job() {

	}
	
	public Job(int jobnum, int deadline, int profit) {
		this.jobnum = jobnum;
		this.deadline = deadline;
		this.profit = profit;
	}

	public Job(Job job) {
		this.jobnum = job.jobnum;
		this.deadline = job.deadline;
		this.profit = job.profit;
	}
	
	@Override
	public String toString() {
		return "Job [jobnum=" + jobnum + ", deadline=" + deadline + ", profit=" + profit + "]";
	}

	public int getJobnum() {
		return jobnum;
	}
	public void setJobnum(int jobnum) {
		this.jobnum = jobnum;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	
	public int compareTo(Job job) {
		return (int)(job.getProfit() - this.getProfit());
	}

}
