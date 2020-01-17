import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LectureScheduling {
	private Lecture[] lecture_list;
	private final Random rand = new Random();

	public LectureScheduling(int total) {
		lecture_list = new Lecture[total];
		getInput();
		printInput();
		lectureScheduling();
	}

	public void getInput() {
		int sTime;
		int eTime;

		for(int i=0;i<lecture_list.length;i++) {
			sTime = rand.nextInt(10);
			eTime = sTime+rand.nextInt(10)+1;
			lecture_list[i] = new Lecture(i, sTime, eTime);
		}
	}

	public void printInput() {
		for(int i=0;i<lecture_list.length;i++) {
			System.out.println(lecture_list[i].toString());
		}
		System.out.print("\n");
	}

	public void lectureScheduling() {
		Arrays.sort(lecture_list);

		ArrayList<Room> totalRooms = new ArrayList<Room>();
		ArrayList<Room> queue = new ArrayList<Room>();

		Room first = new Room(lecture_list[0]);	
		queue.add(first);	
		totalRooms.add(first);	

		for(int i=1; i<lecture_list.length; i++){		
			Room currentRoom = queue.get(queue.size()-1);		
			Lecture currentLecture = lecture_list[i];	
			
			if(currentLecture.getsTime() >= currentRoom.getLastEnd()){		
				currentRoom.addLecture(currentLecture);		
				queue.remove(queue.size()-1);
				queue.add(currentRoom);	
			}
			else{
				Room newRoom = new Room(currentLecture);
				queue.add(newRoom);
				totalRooms.add(newRoom);
			}
		}
		
		System.out.println("Solution");
		for(int i=0; i<totalRooms.size(); i++) {
			System.out.println("Room number"+(i+1));
			for(int j=0; j<totalRooms.get(i).getLectures().size(); j++) {
				System.out.println(totalRooms.get(i).getLectures().get(j).toString());
			}
		}
		System.out.println("Minimum number of rooms = "+totalRooms.size());
	}
}
