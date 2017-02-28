package courseSheet;
import java.util.ArrayList;
import java.awt.Color;
public class Sheet {
	private ArrayList <Course> allCourses;
	private ColorBase colorBase;
	private Mypanel panel;
	private ArrayList <String> nameList;
	public Mypanel getPanel() {
		return panel;
	}
	public Sheet(Mypanel panel){
		allCourses = new ArrayList <Course> ();
		colorBase = new ColorBase();
		nameList = new ArrayList <String> ();
		this.panel=panel;
	}
	public ArrayList<Course> getAllCourses() {
		return allCourses;
	}
	public void setAllCourses(ArrayList<Course> allCourses) {
		this.allCourses = allCourses;
	}
	
	public String addCourse(String name,Time time){
		for (Course course : allCourses){
			if (course.getName().equals(name)){
				if (course.checkYourself(time)){
					course.getTimeList().add(time);
					panel.repaint();
					return "Successfully Add A Courses One More Time";
				}else{
					return "The Same Course Has Already Exists";
				}
			}
		}
		Color newColor=colorBase.getColorList().get(0);
		colorBase.getColorList().remove(0);
		Course course = new Course(name,newColor);
		course.getTimeList().add(time);
		allCourses.add(course);
		nameList.add(name);
		panel.repaint();
		return "Successfully Add A New Course";
	}
	public String deleteCourse(String temp){
		for (Course course : allCourses){
			for (Time time : course.getTimeList()){
				String ans="周"+changeToWord(time.getDay())+" 第"+time.getStartTime()+"节 到 第"+time.getEndTime()+"节 ："+course.getName();
				if (ans.equals(temp)){
					course.getTimeList().remove(time);
					if (course.getTimeList().isEmpty()){
						colorBase.getColorList().add(0, course.getColor());
						allCourses.remove(course);
					}
//					panel.removeAll();
					panel.repaint();
					return "Successfully Delete "+temp;
				}
			}
		}
		return "";
	}
	String changeToWord(int day){
		String ans = "";
		switch(day){
		case 1: ans="一";break;
		case 2: ans="二";break;
		case 3: ans="三";break;
		case 4: ans="四";break;
		case 5: ans="五";break;
		case 6: ans="六";break;
		case 7: ans="日";break;
		}
		return ans;
	}
	
}
