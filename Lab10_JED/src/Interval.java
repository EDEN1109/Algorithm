public class Interval implements Comparable<Interval>{
	private int intervalNum;
	private int sTime;
	private int eTime;
	
	public Interval(int jobnum, int sTime, int eTiem) {
		this.intervalNum = jobnum;
		this.sTime = sTime;
		this.eTime = eTiem;
	}
	
	@Override
	public String toString() {
		return "Interval [intervalNum=" + intervalNum + ", sTime=" + sTime + ", eTiem=" + eTime + "]";
	}

	public int getIntervalNum() {
		return intervalNum;
	}
	public void setIntervalNum(int intervalNum) {
		this.intervalNum = intervalNum;
	}
	public int getsTime() {
		return sTime;
	}
	public void setsTime(int sTime) {
		this.sTime = sTime;
	}
	public int geteTime() {
		return eTime;
	}
	public void seteTime(int eTime) {
		this.eTime = eTime;
	}
	
	public int compareTo(Interval inv) {
		return (this.getsTime() - inv.getsTime());
	}	
}