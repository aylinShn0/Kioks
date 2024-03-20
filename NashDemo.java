// I could not finish this question and it does not work properly. If input number range is [0,9] code can work. But other numbers are going to cause an error
//Aylin Şahin
import java.utik.Scanner;
public class NashDemo {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter a strategie number for first player:");
        int n = scan.nextInt();
        System.out.println("Please enter a strategie number for second player:");
        int m = scan.nextInt();
        
        String[][] game = new String[n][m];
        
        System.out.println("Please enter your game input as a,b in " + n +" rows and "+ m +" columns;");
        for(int i=0 ; i<n ; i++){
            String input = scan.nextLine();
            for(int j=0; j<m ; j++) {
                String myString = input.substring(0,3);
                game[i][j] = myString;
                if(input.length()>3)
                input = input.substring(4);
            }
            
        }
        NashDemo.NashEquilibra(game[][]);
        
    }
    
    public static void NashEquilibra(String[][] arr){
        
        
        for(int i = 0 ; i<arr.length ; i++) {
            for(int j = 0; j<arr[i].length; j++) {
                int maxJ=-1; 
                String str1 = arr[i][j];
                if(((int)str1.charAt(2)-48)>maxJ){
                    maxJ = (int)str1.charAt(2)-48;
                   
                }
                  
            }
        }
        
    }
}
