package courseSheet;


public class Time{
	private int startTime,endTime,day;
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Time (int day,int startTime,int endTime){
		this.day=day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	boolean checkYourself(){
		if (startTime<=endTime&&startTime>=1&&endTime<=11){
			return true;
		}else {
			return false;
		}
	}
}

