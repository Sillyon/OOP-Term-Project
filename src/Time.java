public class Time {
    private int hour;
    private int minute;
    public Time(int hour, int minute) {
        this.hour=hour;
        this.minute=minute;
    }
    public int getHour() {
    	return hour;
    }
    public int getMinute() {
    	return minute;
    }
    public void setHour(int hour) {
		this.hour = hour;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getDifference(Time other) {
    	int hourDifference;
    	hourDifference=this.hour-other.hour;
    	int minuteDifference;
    	minuteDifference=this.minute-other.minute;
    	return 60*hourDifference+minuteDifference;
    }
}
