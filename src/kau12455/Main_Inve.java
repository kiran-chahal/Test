/*Assignment_1-Main_Inve class
Kiranjot Kaur
991669735
*/

package kau12455;

import java.util.Scanner;

public class Main_Inve {
	public static void main(String[] args) {
		
		//creating an object from the inventory class
		Inventory obj0 = new Inventory();
		Scanner input = new Scanner(System.in);

		//prompting the user to enter the inventory id
		System.out.print("Enter Inventory Item ID: ");
		String id = input.nextLine();
		obj0.setId(id);

		//prompting the user to enter the item name
		System.out.print("Enter item name: ");
		String name = input.nextLine();
		obj0.setName(name);

		//prompting the user to enter the quantity on hand
		System.out.print("Qty on hand: ");
		int qoh = input.nextInt();
		obj0.setQoh(qoh);

		//prompting the user to enter the re-order point
		System.out.print("Re-Order Point: ");
		int rop = input.nextInt();
		obj0.setRop(rop);

		//prompting the user to enter the selling Price
		System.out.print("Selling Price: ");
		double sellPrice = input.nextDouble();
		obj0.setSellPrice(sellPrice);

		//printing everything to the console
		System.out.println(obj0.toString());

		//prompting the user to enter the number of units to be bought
		System.out.print("enter # of units to buy: ");
		int units = input.nextInt();
		if (units < 0) {
			System.out.println("Total Cost: $0.00");
		} else {
			double totalValue = (units * sellPrice * 0.13 + units * sellPrice);
			System.out.printf("Total cost: $%.2f", totalValue);
		}
	}
}