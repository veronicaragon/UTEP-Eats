import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CL1{
	public static void main(String[] args) throws FileNotFoundException {
    File text = new File("food.txt");
    Scanner sc = new Scanner(text);

	Scanner input = new Scanner(System.in);

	int options = 0;
	int items = 0;
	double subtotal = 0.0;
	String food = "";
	String chosenFood = "";
	double price = 0.0;
	int quantity = 0;


	while (options < 4 ) {
		printMenu();

		System.out.println("\nSelect an option from the menu: ");
		options = input.nextInt();

		if (options == 1) { //print menu
			while (sc.hasNextLine()) {
				food = sc.next();
				price = sc.nextDouble();
				System.out.print("\n" + food + " " + "$" + price);
			}

			System.out.println("\n\nPlease type the food you want to add: "); //ask food
			sc = new Scanner(text);
			chosenFood = input.next();

			boolean foundFood = false;

			while (sc.hasNextLine() && foundFood == false) { //find food & price to txt
				food = sc.next();
				price = sc.nextDouble();
				if (food.equals(chosenFood)) {
					foundFood = true;
				}
			}
			sc = new Scanner(text);

			if (foundFood == true) { ////match food & price to txt ask how much
				System.out.println("What quantity?");
				quantity = input.nextInt();
				subtotal += quantity * price;
				items += quantity;
			}
		}	
		else if (options == 2){ // display cart
			System.out.println("\n------------Cart------------");
			System.out.println("Number of items: " + items );
			System.out.println("Total: $" + subtotal);
			System.out.println("----------------------------");
		}
		else if (options == 3){ 
			System.out.println("Are you sure you would like to clear your cart? (1 or 2)\n1. Yes    2. No");
			int clearCart = input.nextInt();
				if (clearCart == 1) {
					quantity = 0;
					items = 0;
					subtotal = 0.0;
					System.out.println("Your cart is now empty." + "\nNumber of items: " + quantity + "\nTotal: " + subtotal);
				}
					else {
						System.out.println("\nCart not changed. Going back to menu.");
					}
		}
		 
		else if (options ==4) {
			System.out.println("Please choose an option below (1 or 2): ");
			System.out.println("1. Pickup    2. Delivery (there is a $5 delivery fee)");
			int delivery = input.nextInt();
			subtotal *= 1.0725;
				if (delivery == 2) {
					subtotal += 5.0;
					System.out.println("\nEnter an address for delivery: ");
					input.nextLine();
					String address = input.nextLine();
				}
			System.out.println("\nOrder Information" + "\nNumber of items: " + quantity + "\nTotal: " + subtotal);
			System.out.println("Please enter your 16 digit card number to complete the order: ");
			long cardNumber = input.nextLong();

			System.out.println("\nSuccess! Thank you for shopping with UTEP Eats");
			System.out.println("\n---------Receipt------------");
			System.out.println("Number of items: " + items );
			System.out.println("Total: $" + subtotal);
			System.out.println("---------Receipt------------");
		}
		else if (options == 5){ // display cart
			System.out.println("\nCart abandoned. Goodbye! \nEnding Program.");
		}
		}
		}		
	public static void printMenu() {
		System.out.println("\nWelcome to UTEP Eats!");
		System.out.println("\n------------Menu------------");
		System.out.println("Choose an option (1-5): ");
		System.out.println("1. Add a food \n2. View Cart \n3. Clear Cart \n4. Checkout \n5. Exit");
		System.out.println("----------------------------");
	}
}
