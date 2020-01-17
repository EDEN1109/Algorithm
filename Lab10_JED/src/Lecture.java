public class Lecture implements Comparable<Lecture>{
	private int lecnum;
	private int sTime;
	private int eTime;
	
	public Lecture(int lecnum, int sTime, int eTime) {
		super();
		this.lecnum = lecnum;
		this.sTime = sTime;
		this.eTime = eTime;
	}

	public int getLecnum() {
		return lecnum;
	}

	public void setLecnum(int lecnum) {
		this.lecnum = lecnum;
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

	@Override
	public String toString() {
		return "Lecture [lecnum=" + lecnum + ", sTime=" + sTime + ", eTime=" + eTime + "]";
	}
	
	public int compareTo(Lecture lec) {
		return (this.getsTime() - lec.getsTime());
	}
}