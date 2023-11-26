import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner userInput = new Scanner(System.in);
	    
	    // MENU!!!!!!
		System.out.println("Welcome to Expense Tracker");
		System.out.println("What do you want to do?");
		System.out.println("1. Add Record");
		System.out.println("2. View Record");
		System.out.println("3. Exit");
		System.out.print(": ");
		int menuChoose = userInput.nextInt();
		
		//if statement decider of previous input "menuChoose" : D
		if(menuChoose == 1){
		    userInput.nextLine();
		    //date input---------------------
		    System.out.println("Input the date: ");
		    String date = userInput.nextLine();
		    
		    //expense input----------------------
		    System.out.println("Input your Expense: ");
		    //essentialszzzzzz
		    //food---------------------
		    System.out.print("Food: ");
		    int food = userInput.nextInt();
		    //transportation--------------------
		    System.out.print("Transportation: ");
		    int transport = userInput.nextInt();
		    //electricity-----------------------
		    System.out.print("Electricity: ");
		    int electricity = userInput.nextInt();
		    System.out.print("Housing: ");
		    int housing = userInput.nextInt();
		    
		    //for total essential
		    totalEssential t = new totalEssential();
		    int essential = t.add(food, transport, electricity, housing);
		    
		    System.out.print("Others: ");
		    int nonEssential = userInput.nextInt();
		    
		    expense e = new expense(essential, nonEssential, date);
		    
		    //System.out.printf("%d %d %s", e.getEssential(), e.getNonEssential(), e.getDate());
		    
		}
	}
}
