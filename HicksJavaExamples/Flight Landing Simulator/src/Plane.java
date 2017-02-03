
public class Plane implements Comparable<Plane> {
	//Record class to keep record of data in three string variables
	
	String flightID;
	int arrivalTime;
	int priority;
	int landingTime;
	
	public Plane(String myFlightID, int myArrivalTime, int myPriority) {
		flightID = myFlightID;
		arrivalTime = myArrivalTime;
		priority = myPriority;
		landingTime = -1;
	}
	
	//Override toString method
	//public String toString() {
		
	//}
	
	//Get methods
	public String getFlightID() {
		return flightID;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int getLandingTime()
	{
		return landingTime;
	}
	//Set methods
	public void setLandingTime(int l) {
		landingTime = l;
	}
	
	//Override compareTo method in comparable interface
	@Override
	public int compareTo(Plane o) {
		if (this.getPriority() == o.getPriority()) {
			if(this.getArrivalTime() == o.getArrivalTime()) {
				return 0;
			}
			else if(this.getArrivalTime() > o.getArrivalTime()) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else if(this.getPriority() > o.getPriority()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public String toString() { 
		return flightID + " " + arrivalTime + " " + priority + " " + landingTime;
	}
}