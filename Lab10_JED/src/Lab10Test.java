
public class Lab10Test {

	public static void main(String[] args) {
		// Huffman
		testHuff();
		System.out.println();
		
		// Scheduling with deadline
		testJob();
		System.out.println();
		
		// Interval Scheduling
		testInterval();
		System.out.println();
		
		// Interval partitioning
		testLecture();
		System.out.println();
	}
	
	private static void testHuff() {
		Huffman hm = new Huffman("Hell World!");
	}
	
	private static void testJob() {
		JobScheduling jb = new JobScheduling(5);
	}
	
	private static void testInterval() {
		IntervalScheduling iv = new IntervalScheduling(5);
	}
	
	private static void testLecture() {
		LectureScheduling lt = new LectureScheduling(5);
	}
}
