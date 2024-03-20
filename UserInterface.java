import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) {
        
        Bus bus1 = new Bus("Setra", 2+2, 8, 40, 23); //creates 5 buses
        Bus bus2 = new Bus("Setra", 2+1, 5, 36, 11);
        Bus bus3 = new Bus("Neoplan", 2+1, 2, 48, 38);
        Bus bus4 = new Bus("Travego", 2+2, 15, 36, 14);
        Bus bus5 = new Bus("Setra", 2+1, 15, 36, 8);
        
        Trip trip1 = new Trip("27/11/2022", "Ankara", "Istanbul", "00:15", "06:30", bus1); //creates 5 trips
        Trip trip2 = new Trip("27/11/2022", "Ankara", "Mersin", "13:00", "20:00", bus2);
        Trip trip3 = new Trip("27/11/2022", "Istanbul", "Ankara", "07:00", "13:30", bus3);
        Trip trip4 = new Trip("27/11/2022", "Mersin", "Ankara", "17:00", "00:00", bus4);
        Trip trip5 = new Trip("27/11/2022", "Istanbul", "Mersin", "00:15", "12:30", bus5);
        
        
        System.out.println("To make a bus reservation please enter 1"); //ask user if they want to make a reservation or cancel one
        System.out.println("To cancel a reservation please enter 2");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        trip1.printTrip();                     //prints all the bus and trip informations
        System.out.println(bus1.toString());
        trip2.printTrip();
        System.out.println(bus2.toString());
        trip3.printTrip();
        System.out.println(bus3.toString());
        trip4.printTrip();
        System.out.println(bus4.toString());
        trip5.printTrip();
        System.out.println(bus5.toString());
        System.out.print("Please select a trip between 1-5: ");  //ask user to select a trip
        int tripNo = scan.nextInt();
        String blank = scan.nextLine();
        
        if (input==1) {   //this part happens if the user wants to make a reservation
            if(tripNo==1){ // then depends on the trip no program takes a seat number 
                bus1.printSeats();
                while(true){
                System.out.println("Please enter the seat number you want: ");
                String number = scan.nextLine();
                boolean exits = bus1.doesSeatExist(number); //checks if seat exits and empty
                boolean empty = bus1.isSeatEmpty(number);
                if(exits){
                    if(empty){
                    String pnr = bus1.calculatePNR(number); //if seat exits and empty calculates a PNR and prints it
                    boolean fill = bus1.fillSeat(number);
                    System.out.println(pnr);
                    break;
                    }
                   }
                else
                    System.out.println("Select another seat");
               }
               bus1.printSeats();
               }
            if(tripNo==2){
                bus2.printSeats();
                while(true){
                System.out.println("Please enter the seat number you want: ");
                String number = scan.nextLine();
                boolean exits = bus2.doesSeatExist(number);
                boolean empty = bus2.isSeatEmpty(number);
                if(exits){
                    if(empty){
                    String pnr = bus2.calculatePNR(number);
                    boolean fill = bus2.fillSeat(number);
                    System.out.println(pnr);
                    break;
                    }
                   }
                else
                    System.out.println("Select another seat");
                }
                bus2.printSeats();
                }
            if(tripNo==3){
                bus3.printSeats();
                while(true){
                System.out.println("Please enter the seat number you want: ");
                String number = scan.nextLine();
                boolean exits = bus3.doesSeatExist(number);
                boolean empty = bus3.isSeatEmpty(number);
                if(exits){
                    if(empty){
                    String pnr = bus3.calculatePNR(number);
                    boolean fill = bus3.fillSeat(number);
                    System.out.println("Your PNR number:"+pnr);
                    break;
                    }
                   }
                else
                    System.out.println("Select another seat");
                }
                bus3.printSeats();
                }
            if(tripNo==4){
                bus4.printSeats();
                while(true){
                System.out.println("Please enter the seat number you want: ");
                String number = scan.nextLine();
                boolean exits = bus4.doesSeatExist(number);
                boolean empty = bus4.isSeatEmpty(number);
                if(exits){
                    if(empty){
                    String pnr = bus4.calculatePNR(number);
                    boolean fill = bus4.fillSeat(number);
                    System.out.println(pnr);
                    break;
                    }
                   }
                else
                    System.out.println("Select another seat");
                }
                bus4.printSeats();
                }
            if(tripNo==5){
                bus5.printSeats();
                while(true){
                System.out.println("Please enter the seat number you want: ");
                String number = scan.nextLine();
                boolean exits = bus5.doesSeatExist(number);
                boolean empty = bus5.isSeatEmpty(number);
                if(exits){
                    if(empty){
                    String pnr = bus5.calculatePNR(number);
                    boolean fill = bus5.fillSeat(number);
                    System.out.println(pnr);
                    break;
                    }
                   }
                else
                    System.out.println("Select another seat");
                }
                bus5.printSeats();
                }
            
            }
        if (input==2){ //if user want to cancel a reservation this part happens
            if(tripNo==1){
                bus1.printSeats();
                while(true){
                    System.out.print("Please enter your pnr: "); //ask user for their pnr
                    String pnr = scan.nextLine();
                    String seatNumber = bus1.PNRtoSeatNumber(pnr); //turns pnr to seat number
                    boolean exits = bus1.doesSeatExist(seatNumber); //checks if it is empty and exits
                    boolean empty = bus1.isSeatEmpty(seatNumber);
                    if(exits){
                        if(!empty){
                        boolean fill = bus1.emptySeat(seatNumber); //then empty the seat
                        break;
                        }
                    }
                    else
                        System.out.println("Invalid PNR."); //if pnr is wrong ask user to enter pnr again
                } 
                bus1.printSeats();                  
            }
            
            if(tripNo==2){
                bus2.printSeats();
                while(true){
                    System.out.print("Please enter your pnr: ");
                    String pnr = scan.nextLine();
                    String seatNumber = bus2.PNRtoSeatNumber(pnr);
                    boolean exits = bus2.doesSeatExist(seatNumber);
                    boolean empty = bus2.isSeatEmpty(seatNumber);
                    if(exits){
                        if(!empty){
                        boolean fill = bus2.emptySeat(seatNumber);
                        break;
                        }
                    }
                    else
                        System.out.println("Invalid PNR.");
                }      
                bus2.printSeats();             
            }
            
            if(tripNo==3){
                bus3.printSeats();
                while(true){
                    System.out.print("Please enter your pnr: ");
                    String pnr = scan.nextLine();
                    String seatNumber = bus3.PNRtoSeatNumber(pnr);
                    boolean exits = bus3.doesSeatExist(seatNumber);
                    boolean empty = bus3.isSeatEmpty(seatNumber);
                    if(exits){
                        if(!empty){
                        boolean fill = bus3.emptySeat(seatNumber);
                        break;
                        }
                    }
                    else
                        System.out.println("Invalid PNR.");
                } 
                bus3.printSeats();                  
            }
            
            if(tripNo==4){
                bus4.printSeats();
                while(true){
                    System.out.print("Please enter your pnr: ");
                    String pnr = scan.nextLine();
                    String seatNumber = bus4.PNRtoSeatNumber(pnr);
                    boolean exits = bus4.doesSeatExist(seatNumber);
                    boolean empty = bus4.isSeatEmpty(seatNumber);
                    if(exits){
                        if(!empty){
                        boolean fill = bus4.emptySeat(seatNumber);
                        break;
                        }
                    }
                    else
                        System.out.println("Invalid PNR.");
                }  
                bus4.printSeats();                 
            }
            
            if(tripNo==5){
                bus5.printSeats();
                while(true){
                    System.out.print("Please enter your pnr: ");
                    String pnr = scan.nextLine();
                    String seatNumber = bus5.PNRtoSeatNumber(pnr);
                    boolean exits = bus5.doesSeatExist(seatNumber);
                    boolean empty = bus5.isSeatEmpty(seatNumber);
                    if(exits){
                        if(!empty){
                        boolean fill = bus5.emptySeat(seatNumber);
                        break;
                        }
                    }
                    else
                        System.out.println("Invalid PNR.");
                }
                bus5.printSeats();                   
            }
	}
    }
}            
            
            
            
            
            
