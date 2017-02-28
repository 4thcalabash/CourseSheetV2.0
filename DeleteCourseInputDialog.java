package courseSheet;
//import java.awt.GridLayout;
//import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
public class DeleteCourseInputDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseSheet coursesheet;
	public DeleteCourseInputDialog(CourseSheet coursesheet){
		this.coursesheet = coursesheet;
		JComboBox <String>nameList = new JComboBox<String>();
		for (Course course :coursesheet.getSheet().getAllCourses()){
			for (Time time : course.getTimeList()){
				nameList.addItem("周"+changeToWord(time.getDay())+" 第"+time.getStartTime()+"节 到 第"+time.getEndTime()+"节 ："+course.getName());
			}
		}
		setTitle("删除课程");
		setModal(true);
		setSize(500,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel jp = new JPanel ();
		jp.setLayout(null);
		JLabel jl = new JLabel ("删啥课啊？");
		jp.add(jl);
		jp.add(nameList);
		JButton jb1 = new JButton ("确认");
		JButton jb2 = new JButton ("取消");
		jb1.addActionListener(new jb1ActionListener(this,nameList));
		jb2.addActionListener(new jb2ActionListener(this));
		jp.add(jb1);
		jp.add(jb2);
		jl.setLocation(40,20);
		nameList.setLocation(150,30);
		jb1.setLocation(150,100);
		jb2.setLocation(300,100);
		jl.setSize(80,50);
		nameList.setSize(300,30);
		jb1.setSize(60,30);
		jb2.setSize(60, 30);
		add(jp);
	}
	public class jb1ActionListener implements ActionListener{
		private DeleteCourseInputDialog dd;
		private JComboBox <String>nameList;
		public jb1ActionListener(DeleteCourseInputDialog dd,JComboBox<String> nameList){
			this.dd=dd;
			this.nameList=nameList;
		}
		public void actionPerformed(ActionEvent ev){
			if (nameList.getSelectedItem()==null){
				dd.dispose();
				return;
			}
			String selected=nameList.getSelectedItem().toString();
			dd.coursesheet.getSheet().deleteCourse(selected);
			dd.dispose();
		}
	}
	public class jb2ActionListener implements ActionListener{
		private DeleteCourseInputDialog dd;
		public jb2ActionListener (DeleteCourseInputDialog dd){
			this.dd=dd;
		}
		public void actionPerformed(ActionEvent ev){
			dd.dispose();
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
		case 7: ans="日";break;
		}
		return ans;
	}
	
}
