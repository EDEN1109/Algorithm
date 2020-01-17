import java.util.LinkedList;

public class Room {
	private LinkedList<Lecture> lecture_list = new LinkedList<Lecture>();
	private int lastEnd;

	public Room(Lecture lecture){
		addLecture(lecture);
	}

	public int getLastEnd(){
		return lastEnd;
	}

	public LinkedList<Lecture> getLectures(){
		return lecture_list;
	}

	public Lecture getLastLecture(){
		return lecture_list.getLast();
	}

	public void addLecture(Lecture lecture){
		lecture_list.add(lecture);
		lastEnd = (lecture.geteTime());
	}
}
