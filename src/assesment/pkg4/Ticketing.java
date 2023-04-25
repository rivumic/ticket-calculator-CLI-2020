package assesment.pkg4;
import java.util.Scanner;//importing Scanner to obtain user inputs

public class Ticketing {
    Scanner scan = new Scanner(System.in);//new scanner object
    double[] typeCost = {18, 36, 32.5};//array holds the prices of each category
    String[] typeName = {"Child", "Adult", "Senior"};//array holds the name of each category
    
    public int typeSlct(int type) {//method handles the ticket quantity select for a given ticket type
        
        System.out.println("You have selected " + typeName[type] + "\nHow many " + typeName[type] + 
        " tickets would you like to purchase?");//informs the user what ticket type have been selected and prompts them for a quantity selection
        int ticketNum = scan.nextInt();//accepts quantity selection
        
        System.out.println("You are purchasing "+ticketNum+" "+typeName[type]+" tickets at $"+typeCost[type]+
        " each, totalling $"+(ticketNum*typeCost[type])+"\nDo you want to confirm this selection? Y/N");//prompts the user for confirmation of selection, prints no. of selected tickets as their combined cost
        String slctCnfm = scan.next();//accepts confirmation selection; "Y" or "N"
        if (slctCnfm.equals("N")){//checks selection
            ticketNum = 0;//resets ticket quantity selection if user selected "N" to the confirmation
        }
        return ticketNum;//returns ticket quantity selection, to be saved in a type-specific variable, *ticketType*Count
    }
    public void fnlDisplay(int childCount, int adultCount, int seniorCount){//method handles the display of final cost and ticket category totals
        double totalCost = (childCount*typeCost[0])+(adultCount*typeCost[1])+(seniorCount*typeCost[2]);//calculates grand total cost
        int totalTickets = childCount+adultCount+seniorCount;//calculates total number of tickets across categories
        
        System.out.println("You have purchased:\n");
        if (totalTickets>0) {//why totalTickets was created before: if 0 tickets were purchased then none of the folowing should be shown
            if (childCount>0){//prints no. of tickets of this category and total for the category if there were any selected
                System.out.println(childCount+" Child tickets at $18 each, totalling $"+(childCount*typeCost[0])+"\n");
            }
            if (adultCount>0){//prints no. of tickets of this category and total for the category if there were any selected
                System.out.println(adultCount+" Adult tickets at $36 each, totalling $"+(adultCount*typeCost[1])+"\n");
            }
            if (seniorCount>0){//prints no. of tickets of this category and total for the category if there were any selected
                System.out.println(seniorCount+" Senior tickets at $32.50 each, totalling $"+(seniorCount*typeCost[2])+"\n");
            }
            System.out.println("Total Overall Cost: $"+totalCost);//prints grand total cost
        }
        else{//in case 0 tickets were selected
            System.out.println("0 Tickets");
        }
        
    }
}
