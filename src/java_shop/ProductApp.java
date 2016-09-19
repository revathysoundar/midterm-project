package java_shop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
		int menuChoice = 0;
		double qty, gTotal,sum=0;
		String total,selectMenu, price="",ch = "y";
		List<Order> orderList = new ArrayList<>();
		//ProductClass o = new Order();
		Order o = new Order();
		System.out.println("Welcome to Java Shop!");
		System.out.println("*********************");
		System.out.println();
		while(ch.equalsIgnoreCase("y"))
		{
			
			o.displayAllProducts();
			System.out.println("\nOrder by\n");
			System.out.println("1.ProductCode");
			System.out.println("2.ProductName");
			System.out.println("\nEnter Option ");
			try
			{
				menuChoice = sc.nextInt();
			}catch(InputMismatchException ex)
				{
					System.out.println("Invalid Choice");
					System.out.println("\nEnter Correct Option");
					menuChoice = sc.nextInt();
				}
			try{
				if ( menuChoice != 1 && menuChoice != 2)
				{
					throw new IllegalArgumentException("Invalid Choice");
				}
			
			}catch(IllegalArgumentException ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("\nEnter Correct Option");
				menuChoice = sc.nextInt();
			}
				
				System.out.println("\nEnter your Order here");
				selectMenu = sc.next();
					
				System.out.println("Quantity:");
				qty = sc.nextDouble();
				o.setQuantity(qty);
			
				switch(menuChoice)
				{
					case 1:	 try
							{
							 price = o.searchOrderByNumber(selectMenu);
							 selectMenu = o.searchForProduct(selectMenu);
							}catch(NullPointerException ex)
							{
								System.out.println("Product not Found");
							}
							break;
							 
					case 2: try
							{
							price = o.searchOrderByName(selectMenu);
							}catch(NullPointerException ex)
							{
								System.out.println("Product not Found");
							}
							break;
				}
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
		
		o.modeOfPayment(sc,payType,sum);
		printReceipt(orderList,o.formatTotal(sum));
		
		System.out.println();
		System.out.println("Thank You...Have a Good Day!\n");
		
		}
		
	}
		
		
		
		public static void printReceipt(List<Order> orderList,String sum)
		{
			
			System.out.println("Your Receipt");
			System.out.println("++++++++++++");
			System.out.println("Item\tPrice\tQuantity\tSales_Tax\tTotal");
			System.out.println("~~~~\t~~~~~\t~~~~~~~~\t~~~~~~~~~~\t~~~~~");
			for (Order o : orderList)
			{
				
				System.out.println(o.getpName() + "\t" +o.getPrice()+"\t"+ o.getQuantity() +"\t"
								+"\t6%\t\t" + o.getGrandTotal());
			}
			
			System.out.println("\nBilling Amount: "+ sum + "\n");
		}
		

	

}
