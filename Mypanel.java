package courseSheet;
import javax.swing.*;
import java.awt.*;
public class Mypanel extends JPanel{
	private CourseSheet coursesheet;
	final int delta =19;
//	private ColorBase colorbase;
	private static final long serialVersionUID = 11L;
	public Mypanel (CourseSheet coursesheet){
		this.coursesheet=coursesheet;
//		colorbase = new ColorBase ();
	}
	public void paintComponent(Graphics g){
		removeAll();
		setLayout(null);
		Color mycolor;
		mycolor = new Color(255,255,255);
		g.setColor(mycolor);
		g.fillRect(0, 0, 525+delta, 580);
		mycolor = new Color(0,0,0);
		g.setColor(mycolor);
		g.drawRect(0, 0, 525+delta, 580);
		for (int i=0;i<3;i++){
			g.drawRect(105+delta+i*140, 0, 70, 580);
		}
		g.drawRect(0, 0, 35+delta, 580);
		for (int i=0;i<6;i++){
			g.drawRect(0, 30+100*i, 525+delta, 50);
		}
		for (int i=1;i<=7;i++){
			JPanel dayPanel = new JPanel ();
			dayPanel.setSize(69,29);
			dayPanel.setLocation(70*i-35+1+delta, 0+1);
			dayPanel.setBackground(new Color (86,180,241));
			JLabel jl = new JLabel ("星期"+changeToWord(i));
			if (i==7){
				jl = new JLabel ("星期日");
			}
			jl.setSize(68, 28);
			dayPanel.add(jl);
			add(dayPanel);
		}
		for (int i=1;i<=11;i++){
			JPanel numPanel = new JPanel ();
			numPanel.setSize(35+delta-1,50-1);
			numPanel.setLocation(0+1, 50*i-20+1);
			numPanel.setBackground(new Color (255,128,128));
			JLabel jl = new JLabel ("第\n"+changeToWord(i)+"\n节");
			jl.setSize(35+delta-2, 50-2);
			numPanel.add(jl);
			add(numPanel);
		}
		for (Course course : coursesheet.getSheet().getAllCourses()){
//			System.out.println(course.getName());
//			JLabel jl = new JLabel(course.getName());
//			jl.setFont();
//			g.setColor(course.getColor());
			for (Time time :course.getTimeList()){
				JLabel jl = new JLabel(course.getName());
				JPanel namePanel = new JPanel ();
				namePanel.setLayout(null);
				jl.setSize(69,49);
				namePanel.add(jl);
				jl.setLocation(10,10);
				namePanel.setSize(70-1,(time.getEndTime()-time.getStartTime()+1)*50-1);
				namePanel.setBackground(course.getColor());
				add(namePanel);
				namePanel.setLocation(70*time.getDay()-35+delta+1,50*time.getStartTime()-20+1);
//				jl.setLocation(70*time.getDay()-35,50*time.getStartTime()-20);
//				g.fillRect(70*time.getDay()-35, 50*time.getStartTime()-20, 70, (time.getEndTime()-time.getStartTime()+1)*50);

			}
		}
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
		case 7: ans="七";break;
		case 8: ans="八";break;
		case 9: ans="九";break;
		case 10: ans="十";break;
		case 11: ans="十一";break;
		}
		return ans;
	}
}
