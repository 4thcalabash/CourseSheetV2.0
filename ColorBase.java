package courseSheet;
import java.awt.*;
import java.util.ArrayList;
public class ColorBase {
	private ArrayList <Color> colorList;
	public ColorBase(){
		colorList = new ArrayList <Color> ();
		colorList.add(new Color (0,255,128));//��
		colorList.add(new Color (253,60,88));//��
		colorList.add(new Color (86,68,251));//��
		colorList.add(new Color (55,241,251));//��
		colorList.add(new Color (255,87,242));//��
		colorList.add(new Color (210,60,203));//��
		colorList.add(new Color (250,172,41));//��
		colorList.add(new Color (249,249,45));//��
		colorList.add(new Color (45,240,176));//����
		colorList.add(new Color (82,75,209));//�������ɫ
		colorList.add(new Color (162,51,189));//�������ɫ
		colorList.add(new Color (163,167,176));//���̻�
		colorList.add(new Color (255,179,199));//���ɫ
	}
	public ArrayList<Color> getColorList() {
		return colorList;
	}
}
