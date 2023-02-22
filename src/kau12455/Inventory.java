/*Assignment_1-Inventory class
Kiranjot Kaur
991669735
*/

package kau12455;

import java.util.Scanner;

//hello
public class Inventory {
	Scanner input = new Scanner(System.in);
	private String id = "ABC-1234";
	private String name = "New item";
	private int qoh = 0;
	private int rop = 25;
	private double sellPrice = 0.0;

	//no-arg constructor
	public Inventory(){
	}

	//adding a constructor
	public Inventory(String id, String name, int qoh, int rop, double sellPrice) {
		this.id = id;
		this.name = name;
		this.qoh = qoh;
		this.rop = rop;
		this.sellPrice = sellPrice;
	}

	//method to get the Id
	public String getId() {
		return id;
	}

	//method to set the Id
	public void setId(String id) {   	
		if (id.matches("[a-zA-Z]{3}-[0-9]{4}")) {
			this.id = id;
		} else { 
			System.out.println("Inventory ID must be in the form of ABC-1234");
			System.out.print("Enter input in the format 'abc-1234': ");
			id = input.nextLine();
			setId(id);
		}
	}

	//method to get the Name
	public String getName() {
		return name;
	}

	//method to set the Name
	public void setName(String name) {
		while (name == null || name.trim().equals("")) {
			System.out.println("Error: you must enter an item name");
			System.out.print("Enter item name: ");
			name = input.nextLine();
		}
		this.name = name;
	}

	//method to get the Quantity on hand
	public int getQoh() {
		return qoh;
	}

	//method to set the Quantity on hand
	public void setQoh(int qoh) {
		while(qoh < 0) {
			System.out.println("Error: the qoh must be 0 or more");
			System.out.print("Qty on hand: ");
			qoh = input.nextInt();
		} 
		this.qoh = qoh;
	}

	//method to get the Re-order point
	public int getRop() {
		return rop;
	}

	//method to set the Re-order point
	public void setRop(int rop) {
		if(rop <= 0) {
			System.out.println("Error: ROP must be greater than 0");
			System.out.print("Re-Order Point: ");
			rop = input.nextInt();
			setRop(rop);
		}else 
			this.rop = rop;
	}

	//method to get the Selling Price
	public double getSellPrice() {
		return sellPrice;
	}

	//method to set the Selling Price
	public void setSellPrice(double sellPrice) {
		while(sellPrice < 0) {
			System.out.println("Error: Selling Price must be greater than 0");
			System.out.print("Selling Price: ");
			sellPrice = input.nextDouble();
		}
		this.sellPrice = sellPrice;
	}

	//method to print everything
	public String toString(){
		if (qoh <= rop) {
			return getId() + " (" + getName() + "), QOH: " + getQoh() +" , you need to order more " + name ; 
		} else 
			return getId() + " (" + getName() + "), QOH: " + getQoh() + ", Price: $" + getSellPrice(); 	
	}
}