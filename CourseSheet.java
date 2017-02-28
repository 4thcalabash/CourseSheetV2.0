package courseSheet;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class CourseSheet {
	private Sheet sheet;
	private JFrame frame;
	private Mypanel panel;
		
	public CourseSheet(){
		sheet = new Sheet(panel);	
	}
	
	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public static void main(String args[]){
		CourseSheet coursesheet = new CourseSheet ();
		coursesheet.go(coursesheet);
		
	}
	
	public class AddActionListener implements ActionListener{
		private CourseSheet coursesheet;
		public AddActionListener(CourseSheet coursesheet){
			this.coursesheet = coursesheet;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AddCourseInputDialog(coursesheet).setVisible(true);
		} 
		
		
	}
	
	public class SaveItemListener implements ActionListener{
		private CourseSheet coursesheet;
		public SaveItemListener(CourseSheet coursesheet){
			this.coursesheet=coursesheet;
		}
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileSave = new JFileChooser ();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile(),coursesheet);
		}
	}
	
	public void saveFile(File file,CourseSheet coursesheet){
		try{
			BufferedWriter writer = new BufferedWriter (new FileWriter(file));
			writer.write(Integer.toString(coursesheet.getSheet().getAllCourses().size()));
			writer.newLine();
			for (Course course : coursesheet.getSheet().getAllCourses()){
				writer.write(course.getName());
				writer.newLine();
//				writer.write(course.getColor().getRed()+"/"+course.getColor().getGreen()+"/"+course.getColor().getBlue());
//				writer.newLine();
				int i=course.getTimeList().size();
				writer.write(Integer.toString(i));
//				System.out.println(i);
				writer.newLine();
				for (Time time : course.getTimeList()){
					writer.write(Integer.toString(time.getDay()));
					writer.newLine();
					writer.write(Integer.toString(time.getStartTime()));
					writer.newLine();
					writer.write(Integer.toString(time.getEndTime()));
					writer.newLine();
				}
			}
			writer.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public class LoadItemListener implements ActionListener{
		private CourseSheet coursesheet;
		public LoadItemListener(CourseSheet coursesheet){
			this.coursesheet=coursesheet;
		}
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileOpen = new JFileChooser ();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile(),coursesheet);
		}
	}
	
	public void loadFile(File file,CourseSheet coursesheet){
		try{
			BufferedReader reader = new BufferedReader (new FileReader(file));
			String line =null;
			int ans = reader.readLine().charAt(0)-48;
			for (int i=1;i<=ans;i++){
				line=reader.readLine();
				int num=reader.readLine().charAt(0)-48;
				for (int j=1;j<=num;j++){
					int day=reader.readLine().charAt(0)-48;
					int startTime = reader.readLine().charAt(0)-48;
					int endTime = reader.readLine().charAt(0)-48;
					Time time = new Time (day,startTime,endTime);
					coursesheet.getSheet().addCourse(line, time);
				}
			}
			reader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}	
	}
	public class DeleteActionListener implements ActionListener{
		private CourseSheet coursesheet;
		public DeleteActionListener (CourseSheet coursesheet){
			this.coursesheet=coursesheet;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new DeleteCourseInputDialog(coursesheet).setVisible(true);
		}
	}
	
	public void go(CourseSheet coursesheet){
		frame = new JFrame("CourseSheet");
		panel = new Mypanel(coursesheet);
		this.sheet = new Sheet (panel);
		panel.setSize(1200,600);
		frame.add(panel);
		frame.setLayout(null);
		frame.add(panel);
		JButton Add = new JButton ("ADD");
		Add.setSize(80, 40);
		Add.setLocation(600,20);
		Add.addActionListener(new AddActionListener (coursesheet));
		JButton Delete = new JButton ("DELETE");
		Delete.setSize(80,40);
		Delete.setLocation(600,70);
		Delete.addActionListener(new DeleteActionListener (coursesheet));
		frame.add(Add);
		frame.add(Delete);
		
		JMenuBar menuBar = new JMenuBar ();
		JMenu fileMenu = new JMenu ("File");
		JMenuItem saveItem = new JMenuItem("save");
		saveItem.addActionListener(new SaveItemListener(coursesheet));
		fileMenu.add(saveItem);
		JMenuItem loadItem = new JMenuItem("load");
		loadItem.addActionListener(new LoadItemListener(coursesheet));
		fileMenu.add(loadItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		
		frame.setSize(700, 700);
		frame.setVisible(true);
	}
}
