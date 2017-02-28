package courseSheet;
import java.util.ArrayList;
import java.awt.Color;
public class Course {
	private ArrayList <Time> timeList;
	private String name;
	private Color color;
	public Course(String name,Color color){
		this.name=name;
		this.color = color;
		timeList = new ArrayList <Time> ();
	}
	
	boolean checkYourself(Time newTime){
		for (Time time : timeList){
			if (time.getStartTime()==newTime.getStartTime()&&time.getEndTime()==newTime.getEndTime()&&time.getDay()==newTime.getDay()){
				return false;
			}
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Time> getTimeList() {
		return timeList;
	}

	public void setTimeList(ArrayList<Time> timeList) {
		this.timeList = timeList;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
