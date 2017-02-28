package courseSheet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddCourseInputDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JTextField jtf1,jtf2,jtf3,jtf4;
	final JLabel jlinfo;
	
	public AddCourseInputDialog (CourseSheet coursesheet){
		setTitle("添加课程");
		setModal(true);
		setSize(300,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		JLabel jl1 = new JLabel ("啥课啊？");
	
		jtf1 = new JTextField (12);
		JLabel jl2 = new JLabel ("哪节上课？");
		jtf2 = new JTextField (2);
		JLabel jl3 = new JLabel ("哪节下课？");
		jtf3 = new JTextField (2);
		JLabel jl4 = new JLabel ("周几？");
		jtf4 = new JTextField (1);
		JPanel jp = new JPanel (new GridLayout (4,2));
		jp.add(jl1);
		jp.add(jtf1);
		jp.add(jl2);
		jp.add(jtf2);
		jp.add(jl3);
		jp.add(jtf3);
		jp.add(jl4);
		jp.add(jtf4);
		JButton jb = new JButton ("确认");
		jlinfo = new JLabel ("信息:",JLabel.CENTER);
		jb.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent e){
				
				String name = jtf1.getText();
				int startTime = changeToInt(jtf2.getText());
				int endTime = changeToInt(jtf3.getText());
				int day = changeToInt (jtf4.getText());
				Time newtime = new Time (day,startTime,endTime);
				String info = coursesheet.getSheet().addCourse(name, newtime);
				jlinfo.setText(info);
				dispose();
			}
		});
		add(jp);
		add(jlinfo,BorderLayout.NORTH);
		add(jb,BorderLayout.SOUTH);
	}
	public int changeToInt (String text){
		int index=0;
		char [] content = text.toCharArray();
		int max = text.length();
		while ((content[index]<48||content[index]>57)&&index<max){
			index++;
		}
		if (content[index]<48||content[index]>57){
			return -1;
		}
		int ans = (int)content[index]-48;
		if (index+1<max&&content[index+1]>=48&&content[index+1]<=57){
			ans=ans*10+(int)content[index+1]-48;
		}
			return ans;
	}
}
