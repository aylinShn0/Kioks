import java.util.Random;
public class Bus {
    private String type;
    private int model, age, capacity, remainingCapacity;
    private boolean[][] seats;
    
    public Bus(String type, int model, int age, int capacity, int remainingCapacity) {
        this.type=type;
        this.model=model;
        this.age=age;
        this.capacity=capacity;
        this.remainingCapacity=remainingCapacity;
        this.seats = new boolean[capacity/model][model];
        this.fillSeatsRandomly((capacity - remainingCapacity));
    //constructor creats an array for seats and fills them randomly
    }
    
    public String toString() {
        String str = "\t\tBus Information:" + "\n\t\tBus: " + type + "\n\t\tType: "+ model
                           + "\n\t\tAge: "+ age+ "\n\t\tCapacity: "+ capacity+ " seats"+"\n\t\tRemaining Capacity: "+ remainingCapacity;
        return str;
    }
    public void fillSeatsRandomly(int x) { // this method gets a n x number to fill seats randomly
        Random generator = new Random();
        for(int loop=0; loop<x; loop++){
        if(model>3){  //in this loop if model is a 2+2 int i gets a random number between 0 - capacity/model
            int i = generator.nextInt((capacity/4));
            int j = generator.nextInt(4);  // beacuse of the model being 2+2 int j gets a random number in [0,4)
            seats[i][j] = true; //filling seats as true beause this array is a boolean array
        }
        else {
            int i = generator.nextInt((capacity/3)); //does the same for 2+1 model
            int j = generator.nextInt(3);
            seats[i][j] = true;
        }
       }
    }
    public void printSeats() {
        if(model>3) {  //for 2+2 models prints seats. Uf a seat is taken in array it means true and if it is true program print "T". If not it means it is false and prints "."
        System.out.println("  ABCD");
        for(int i = 0; i<seats.length; i++){
            System.out.print((i+1)+" ");
            for(int j=0; j<seats[i].length; j++){                
                if(seats[i][j]==true)
                System.out.print("T");
                else
                System.out.print(".");                
                }
            System.out.println();
        }
    }
        else
        {  //does the same for 2+1 model 
        System.out.println("  ABC");
        for(int i = 0; i<seats.length; i++){
            System.out.print((i+1)+" ");
            for(int j=0; j<seats[i].length; j++){
                if(seats[i][j]==true)
                System.out.print("T");
                else
                System.out.print(".");
                }
            System.out.println();
        }
    }
    }
    
    public int numberOfEmptySeats(){
        return remainingCapacity;
    }
    
    public boolean doesSeatExist(String str){ //this method takes a string like 1A or 5D as seat number and tells if it exists or not
       if(str.length() == 2){ 
       char firstchar = str.charAt(0);
       char second = str.charAt(1);
       int first = (int)firstchar-48;
        if(first>0 & first<= (capacity/model) & second == 'A')
            return true;
        if(first>0 & first<= (capacity/model) & second == 'B')
            return true;
        if(first>0 & first<= (capacity/model) & second == 'C')
            return true;
        if(first>0 & first<= (capacity/model) & second == 'D')   
            return true; }
            
       if(str.length()>2){ // if seat number is something like 10C or 15A it holds the characters in seat number and tells if it exists or not
       char firstchar = str.charAt(0);
       char secondchar = str.charAt(1);
       char second = str.charAt(2);
       int first = (int)firstchar-48;
       int secondch = (int)secondchar-48;
       int sum = (10*first)+secondch;
        if(sum>0 & sum<= (capacity/model) & second == 'A')
            return true;
        if(sum>0 & sum<= (capacity/model) & second == 'B')
            return true;
        if(sum>0 & sum<= (capacity/model) & second == 'C')
            return true;
        if(sum>0 & sum<= (capacity/model) & second == 'D')   
            return true; }
            
        return false;  
    }
    public boolean isSeatEmpty(String str){ //this method takes a string like 1A or 5D as seat number and tells if it is empty or not
        if(str.length()==2){
        int i = this.calculateSeatNumberFirstIndex(str);
        int j = this.calculateSeatNumberCharIndex(str);
        if(seats[i][j]== false)
           return true;}
           
        if(str.length()>2){ // if seat number is something like 10C or 15A it tells if it is empty or not
        int sum = ((this.calculateSeatNumberFirstIndex(str)+1)*10)+(this.calculateSeatNumberSecondIntIndex(str)+1);
        int i = sum-1;
        int j = this.calculateSeatNumberCharIndex(str);
        if(seats[i][j]==false)
           return true;       
        }
           
        return false;
    }
    public boolean fillSeat(String str){ //this method takes a string like 1A or 5D as seat number and fills it
        if(str.length()==2){
        int i = this.calculateSeatNumberFirstIndex(str);
        int j = this.calculateSeatNumberCharIndex(str);
        seats[i][j] = true;
        return true;}
        
        if(str.length()>2){ // if seat number is something like 10C or 15A, fills it
        int sum = ((this.calculateSeatNumberFirstIndex(str)+1)*10)+(this.calculateSeatNumberSecondIntIndex(str)+1);
        int i = sum-1;
        int j = this.calculateSeatNumberCharIndex(str);
        seats[i][j] = true;
        return true;
        }
        return false;
    }
    public boolean emptySeat(String str){ //empty the seat, it is similar to fill method
        if(str.length()==2){
        int i = this.calculateSeatNumberFirstIndex(str);
        int j = this.calculateSeatNumberCharIndex(str);
        seats[i][j] = false;
        return true;}
        
        if(str.length()>2){
        int sum = ((this.calculateSeatNumberFirstIndex(str)+1)*10)+(this.calculateSeatNumberSecondIntIndex(str)+1);
        int i = sum-1;
        int j = this.calculateSeatNumberCharIndex(str);
        seats[i][j] = false;
        return true;}
        
        return false;
    }
    private int calculateSeatNumberFirstIndex(String str){ //takes a string as seta number like 1A, 5D or 15C and returns the first character as an int
       char firstchar = str.charAt(0);
       int first = (int)firstchar-48;
        return (first-1);   
    }
    private int calculateSeatNumberCharIndex(String str){ //if seat numbers second char is a char like 6B or 8D this method returns it as an int 
        int secondInt=0;
        char second = str.charAt(str.length()-1);
        if(second == 'A')
            secondInt = 0;
        if(second == 'B')
            secondInt = 1;
        if(second == 'C')
            secondInt = 2;
        if(second == 'D')
            secondInt = 3;
        return secondInt;    
    } 
    private int calculateSeatNumberSecondIntIndex(String str){ //if seat number is something like 14B or 12D takes the second character as a char and returns it as an int
        char secondchar = str.charAt(1);
        int second = (int)secondchar-48;
        return (second-1);  
    }   
    public String calculatePNR(String mystring){ //creates a PNR number depend on bus name, model and seat number
        if(mystring.length()==2){ // calculates for seat number like 7A or 4D
        int secondInt=0;
        String str1 = "S" ;
        char first = mystring.charAt(0);
        int firstInt = (int)first-48;
        char second = mystring.charAt(1);
        if(second == 'A')
            secondInt = 0;
        if(second == 'B')
            secondInt = 1;
        if(second == 'C')
            secondInt = 2;
        if(second == 'D')
            secondInt = 3;
        if(type.equals("Setra"))
            str1 = "S";
        if(type.equals("Neoplan"))
            str1 = "N";
        if(type.equals("Travego"))
            str1 = "T";
        String PNR= ""+ str1 + (model*1000)+((10*firstInt)+secondInt);
        return PNR;
        }
        if(mystring.length()>2){ // calculates for seat numbers like 11C or 15A
        String str1 = "S";
        int lastInt=0;
        char first = mystring.charAt(0);
        int firstInt = (int)first-48;
        char second = mystring.charAt(1);
        int secondInt = (int)second-48;
        char last = mystring.charAt(mystring.length()-1);
        if(last == 'A')
            lastInt = 0;
        if(last == 'B')
            lastInt = 1;
        if(last == 'C')
            lastInt = 2;
        if(last == 'D')
            lastInt = 3;
        if(type.equals("Setra"))
            str1 = "S";
        if(type.equals("Neoplan"))
            str1 = "N";
        if(type.equals("Travego"))
            str1 = "T";
        String PNR= ""+ str1 + (model*1000)+(((10*firstInt+secondInt)*10)+lastInt);
        return PNR;
        }
        return null;
    }
    public String PNRtoSeatNumber(String pnr) { //turns PNR number to seat number 
        if(pnr.length()==8){ //in this program PNR number can have 8 character or 7 character.If ıt has 8 character that means this number is for a seat number like 10D or 14A 
        char last = pnr.charAt(pnr.length()-1);
        char last1 = pnr.charAt(pnr.length()-2);
        char last2 = pnr.charAt(pnr.length()-3);
        
        if(last=='0')
           last = 'A';
        if(last=='1')
           last = 'B';
        if(last=='2')
           last = 'C';
        if(last=='3')
           last = 'D';
           
        int sum = ((int)last1-48) + (((int)last2-48)*10);
        String seatNumber = ""+sum+last;
        return seatNumber;}
        
        if (pnr.length()==7){ // turns PNR number to seat number like 6D or 4A
        char last = pnr.charAt(pnr.length()-1);
        char last1 = pnr.charAt(pnr.length()-2);
        
        if(last=='0')
           last = 'A';
        if(last=='1')
           last = 'B';
        if(last=='2')
           last = 'C';
        if(last=='3')
           last = 'D';
           
        int sum = (int)last1 - 48;
        String seatNumber = ""+sum+last;
        return seatNumber;
        }
        return null;        
    }
 }   
 
 
 
 
 
 
 
 
 
