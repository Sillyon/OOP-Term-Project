public class Subscription {
    private Date begin;
    private Date end;
    private SubscribedVehicle vehicle;
    public Subscription(Date begin,Date end, String plate) {
        this.begin=begin;
        this.end=end;
        
    }
	public Date getBegin() {
		return begin;
	}
	public Date getEnd() {
		return end;
	}
	public SubscribedVehicle getVehicle() {
		return vehicle;
	}
    public void setBegin(Date begin) {
		this.begin = begin;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public void setVehicle(SubscribedVehicle vehicle) {
		this.vehicle = vehicle;
	}
	public boolean isValid() {
    	if(this.vehicle.isSpecial()) {
    		return true;
    	}
    	if(begin.isBeforeThan(Date.getToday()) && (end.isAfterThan(Date.getToday()))) {
    		return true;
    	}
    	return false;
    }
}
