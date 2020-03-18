import java.util.ArrayList;
import java.util.List;

public class AutoPark {
	private List<SubscribedVehicle> subscribedVehicles = new ArrayList<>();
	private List<ParkRecord> parkRecords = new ArrayList<>();
    private double hourlyFee;
    private double incomeDaily;
    private int capacity;
    public AutoPark(double hourlyFee, int capacity) {
        this.hourlyFee=hourlyFee;
        this.capacity=capacity;
        this.incomeDaily=0;
    }
	public List<SubscribedVehicle> getSubscribedVehicles() {
		return subscribedVehicles;
	}
	public void setSubscribedVehicles(List<SubscribedVehicle> subscribedVehicles) {
		this.subscribedVehicles = subscribedVehicles;
	}
	public List<ParkRecord> getParkRecords() {
		return parkRecords;
	}
	public void setParkRecords(List<ParkRecord> parkRecords) {
		this.parkRecords = parkRecords;
	}
	public double getHourlyFee() {
		return hourlyFee;
	}
	public void setHourlyFee(double hourlyFee) {
		this.hourlyFee = hourlyFee;
	}
	public double getIncomeDaily() {
		return incomeDaily;
	}
	public void setIncomeDaily(double incomeDaily) {
		this.incomeDaily = incomeDaily;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public SubscribedVehicle searchVehicle(String aPlate) {
    	for(SubscribedVehicle sv: subscribedVehicles) {
    		if(sv.getPlate().equals(aPlate)) {
    			return sv;
    		}
    	}
    	return null;
    }
    public boolean isParked(String aPlate) {
    	for(ParkRecord pr: parkRecords) {
    		if(pr.getVehicle().getPlate().equals(aPlate)) {
    			return true;
    		}
    	}
    	return false;
    }
    public boolean addVehicle(SubscribedVehicle aSubscribedVehicle) {
    	for(SubscribedVehicle sv: subscribedVehicles) {
    		if(sv.getPlate().equals(aSubscribedVehicle.getPlate())) {
    			return false;
    		}
    	}
    	subscribedVehicles.add(aSubscribedVehicle);
    	return true;
    }
    public boolean vehicleEnters(String aPlate, Time enter, boolean isOfficial) {
    	if(this.isParked(aPlate)) {
    		return false;
    	}
    	for(SubscribedVehicle sv: subscribedVehicles) {
    		if(sv.getPlate().equals(aPlate)) {
    			parkRecords.add(new ParkRecord(enter,null,sv));
    			return true;
    		}
    	}
    	if(!isOfficial) {
    		RegularVehicle rv = new RegularVehicle(aPlate);
    		parkRecords.add(new ParkRecord(enter,null,rv));
    		return true;
    	}
    	return true;
    }
    public boolean vehicleExits(String aPlate, Time exit) {
    	if(searchVehicle(aPlate)!=null) {
    		SubscribedVehicle sv = searchVehicle(aPlate);
    		if(sv.getSubscription().isValid()) {
    			return false;
    		}
    	}
    	for(ParkRecord pr: parkRecords) {
    		if(pr.getVehicle().getPlate().equals(aPlate)) {
    			pr.setExitTime(exit);
    			int hours = (int)pr.getParkingDuration()/60;
    			incomeDaily+=hours*hourlyFee;
    			return true;
    		}
    	}
		return false;
    }
	@Override
	public String toString() {
		return "AutoPark [subscribedVehicles=" + subscribedVehicles + ", parkRecords=" + parkRecords + ", hourlyFee="
				+ hourlyFee + ", incomeDaily=" + incomeDaily + ", capacity=" + capacity + "]";
	}
}
