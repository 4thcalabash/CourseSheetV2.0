package courseSheet;
import java.awt.*;
import java.util.ArrayList;
public class ColorBase {
	private ArrayList <Color> colorList;
	public ColorBase(){
		colorList = new ArrayList <Color> ();
		colorList.add(new Color (0,255,128));//绿
		colorList.add(new Color (253,60,88));//红
		colorList.add(new Color (86,68,251));//蓝
		colorList.add(new Color (55,241,251));//青
		colorList.add(new Color (255,87,242));//粉
		colorList.add(new Color (210,60,203));//紫
		colorList.add(new Color (250,172,41));//橙
		colorList.add(new Color (249,249,45));//黄
		colorList.add(new Color (45,240,176));//蓝绿
		colorList.add(new Color (82,75,209));//很深的蓝色
		colorList.add(new Color (162,51,189));//很深的紫色
		colorList.add(new Color (163,167,176));//奶奶灰
		colorList.add(new Color (255,179,199));//胖妞色
	}
	public ArrayList<Color> getColorList() {
		return colorList;
	}
}
