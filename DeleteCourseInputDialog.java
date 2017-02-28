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
				nameList.addItem("��"+changeToWord(time.getDay())+" ��"+time.getStartTime()+"�� �� ��"+time.getEndTime()+"�� ��"+course.getName());
			}
		}
		setTitle("ɾ���γ�");
		setModal(true);
		setSize(500,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel jp = new JPanel ();
		jp.setLayout(null);
		JLabel jl = new JLabel ("ɾɶ�ΰ���");
		jp.add(jl);
		jp.add(nameList);
		JButton jb1 = new JButton ("ȷ��");
		JButton jb2 = new JButton ("ȡ��");
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
		case 1: ans="һ";break;
		case 2: ans="��";break;
		case 3: ans="��";break;
		case 4: ans="��";break;
		case 5: ans="��";break;
		case 6: ans="��";break;
		case 7: ans="��";break;
		}
		return ans;
	}
	
}
