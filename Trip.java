public class Trip {
    private String origin, destination, departureTime, arrivalTime, date;
    private Bus assignedBus;
    
    public Trip(String date, String origin, String destination, String departureTime, String arrivalTime, Bus assignedBus) { //creats trip objects
        this.origin = origin;
        this.date = date;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.assignedBus = assignedBus;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public String getDepartureTime() {
        return departureTime;
    }
    
    public String getArrivalTime()  {
        return arrivalTime;
    }
    
    public Bus getAssignedBus() {
        return assignedBus;
    }
    
    public void printTrip() {
    System.out.println("Trip Information: \n" + " \tDate: " + this.getDate() +
        		   "\n\tFrom: " + this.getOrigin() + " to " + this.getDestination() +
        		   "\n\tTrip Time: " + this.getDepartureTime() + " to " + this.getArrivalTime());
    }
    
}    
    
    
    
    
    
    
    
    
    
    
        
    
