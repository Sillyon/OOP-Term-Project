import java.util.Calendar;

public class Date {
    private int day;
	private int month;
    private int year;
    public Date(int day, int month, int year) {
        this.day=day;
        this.month=month;
        this.year=year;
    }
	public int getDay() {
		return day;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
    public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
    public boolean isAfterThan(Date other) {
    	if(this.year>other.getYear()) {
    		return true;
    	}
    	else if((this.year==other.getYear()) && (this.month>other.getMonth())) {
    		return true;
    	}
    	else if ((this.year==other.getYear()) && (this.month==other.getMonth()) && (this.day>other.getDay())) {
    		return true;
    	}
    	return false;
    }
    public boolean isBeforeThan(Date other) {
    	if(this.year<other.getYear()) {
    		return true;
    	}
    	else if((this.year==other.getYear()) && (this.month<other.getMonth())) {
    		return true;
    	}
    	else if ((this.year==other.getYear()) && (this.month==other.getMonth()) && (this.day<other.getDay())) {
    		return true;
    	}
    	return false;
    }
    public boolean isEqualsWith(Date other) {
    	if((this.getYear()==other.getYear()) && (this.getMonth()==other.getMonth()) && (this.getDay()==other.getDay())) {
    		return true;
    	}
    	return false;
    }
    public static Date getToday() {
    	Date today = new Date(	Calendar.getInstance().get(Calendar.DATE),
    							Calendar.getInstance().get(Calendar.MONTH),
    							Calendar.getInstance().get(Calendar.YEAR));
    	return today;
    }
}
