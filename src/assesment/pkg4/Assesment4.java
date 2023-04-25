package assesment.pkg4;
import java.util.Scanner;//importing Scanner to obtain user inputs

public class Assesment4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);//new scanner object
        menuText textLib = new menuText();
        //the text for the main menu is long so it is stored separate from the Main method
        Ticketing ticket = new Ticketing();
        //initialising object for access to methods that hand the ticket selection and final order display
        int userChoice;//holds the ticket category that the user selects, gets updated with each cycle of the ticket selection loop
        int childCount = 0;//no of child tickets that have been selected
        int adultCount = 0;//no of adult tickets that have been selected
        int seniorCount = 0;//no of senior tickets that ahve been selected
        do {
            textLib.menuText();//prints the Main Menu, prompting user inpur
            userChoice=scan.nextInt();//receives user input
            // the following "if" statements determine which option has been chosen; 1=Child, 2=Adult, 3=Senior
            if (userChoice == 1){
                //calls typeSlct method which is passed the userChoice and will return the number of tickets selected by the user
                childCount = ticket.typeSlct(userChoice-1);//userChoice has 1 subtracted from it so that it will match array indexing standards (first entry indexed as the 0th entry)
            }
            if (userChoice == 2){
                adultCount = ticket.typeSlct(userChoice-1);
            }
            if(userChoice ==3){
                seniorCount = ticket.typeSlct(userChoice-1);
            }
            
            if (userChoice!=0){//if statement here makes sure that if 0 is selected at the main menu without buying any tickets that the confirmation message is not shown
                textLib.additionalTxt();//prints text asking if a purchase from another category is desired
                String fnlCnfm = scan.next();//Accepts user response; "Y" or "N" 
                if (fnlCnfm.equals("N")){//if statement will terminate the while loop if "N" is inputted 
                     userChoice= 0;
                }
            }
            
        } while (userChoice!=0);
        ticket.fnlDisplay(childCount, adultCount, seniorCount);//calls fnlDisplay method - displays total ticket selections/prices
    }
}//end