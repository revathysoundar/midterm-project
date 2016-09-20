package java_shop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**The ProductApp displays menu information for the user and retrieves request from the user 
*/
public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String nextPerson = "y";
		while(nextPerson.equalsIgnoreCase("y")){
		int menuChoice = 0;
		double qty=0, gTotal,sum=0;
		String total,selectMenu="", price="",ch = "y";
		List<Order> orderList = new ArrayList<>();
		String pFound = "Product Not Found";
		//ProductClass o = new Order();
		Order o = new Order();
		System.out.println("Welcome to Java Shop!");
		System.out.println("*********************");
		System.out.println();
		while(ch.equalsIgnoreCase("y"))
		{
			
			o.displayAllProducts();
			System.out.println("\nOrder by\n");
			System.out.println("1.Product Code");
			System.out.println("2.Product Name\n");
			String prompt = "Enter Option :";
			menuChoice = Validator.getInt(sc, prompt, 1, 2);
			switch(menuChoice)
				{
					case 1:	while(true)
							{
								System.out.println("\nEnter your Order here");
								selectMenu = sc.next();
								pFound = o.searchForProduct(selectMenu);
								if (pFound.equalsIgnoreCase("Product Not Found"))
								{
									System.out.println("Invalid Product Code. Please Try again...");
									continue;
								}
								else
										break;
							}	 
						
						
						try
							{
							 price = o.searchOrderByNumber(selectMenu);
							 selectMenu = o.searchForProduct(selectMenu);
							}catch(NullPointerException ex)
							{
								System.out.println("Product not Found");
							}
							break;
							 
					case 2: while(true)
							{
								System.out.println("\nEnter your Order here");
								selectMenu = sc.next();
								pFound = o.searchForProductName(selectMenu);
								if (pFound.equalsIgnoreCase("Product Not Found"))
								{
									System.out.println("Invalid Product Name. Please Try again...");
									continue;
								}
								else
										break;
							}	 
						
							try
							{
							price = o.searchOrderByName(selectMenu);
							}catch(NullPointerException ex)
							{
								System.out.println("Product not Found");
							}
							break;
				}
				 System.out.println("Quantity:");
				 qty = sc.nextDouble();
				 o.setQuantity(qty);
				 total = o.calculateTotal(price);
				 gTotal = Double.parseDouble(total.substring(1));
				 sum += gTotal;
				 orderList.add(new Order(selectMenu, price, qty, gTotal));
			
		System.out.println("Anything else....(Y/N)");
		ch = sc.next();
		
		}
		int payType;
		System.out.println("\nBilling Amount: "+ o.formatTotal(sum) + "\n");
		
		System.out.println("\nEnter the Mode of Payment Option...");
		System.out.println("1. Cash");
		System.out.println("2. Credit");
		System.out.println("3. Check");
		payType = sc.nextInt();
		try
		{
		 
		if ( payType != 1 && payType != 2 && payType != 3)
		{
			throw new IllegalArgumentException("Invalid Choice");
		}
		}catch(IllegalArgumentException ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("\nEnter Correct Option");
			payType = sc.nextInt();
		}
		
		o.modeOfPayment(payType,sum);
		printReceipt(orderList,o.formatTotal(sum));
		
		System.out.println();
		System.out.println("Thank You...Have a Good Day!\n");
		System.out.println("Next Person in line... Y/N");
		nextPerson = sc.next();
		}
		
	}
		
	/**This method displays and prints the user receipt
		*/
		public static void printReceipt(List<Order> orderList,String sum)
		{
			
			System.out.println("Your Receipt");
			System.out.println("++++++++++++");
			System.out.println("\nItem\tPrice\tQuantity\tSales_Tax\tTotal");
			System.out.println("~~~~\t~~~~~\t~~~~~~~~\t~~~~~~~~~~\t~~~~~");
			for (Order o : orderList)
			{
				
				System.out.println(o.getpName() + "\t" +o.getPrice()+"\t"+ o.getQuantity() +"\t"
								+"\t6%\t\t" + o.getGrandTotal());
			}
			
			System.out.println("\nBilling Amount: "+ sum + "\n");
		}
		
		

	

}
