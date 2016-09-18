package java_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int menuChoice;
		double qty, gTotal,sum=0;
		String total,selectMenu, price,ch = "y";
		List<Order> orderList = new ArrayList<>();
		ProductClass p = new ProductClass();
		Order o = new Order();
		
		System.out.println("Welcome to Java Shop!");
		System.out.println("*********************");
		System.out.println();
		while(ch.equalsIgnoreCase("y"))
		{
			
			p.displayAllProducts();
			System.out.println();
			System.out.println("Order by");
			System.out.println("1.Number");
			System.out.println("2. Name");
			System.out.println("Enter Option ");
			menuChoice = sc.nextInt();
			System.out.println("Enter your Order here");
			selectMenu = sc.next();
			System.out.println("Quantity:");
			qty = sc.nextDouble();
			o.setQuantity(qty);
		switch(menuChoice)
		{
			case 1:	 price = o.searchOrderByNumber(selectMenu);
					 selectMenu = o.searchForProduct(selectMenu);
					 total = o.calculateTotal(price);
					 gTotal = Double.parseDouble(total.substring(1));
					 sum += gTotal;
					 orderList.add(new Order(selectMenu, price, qty, gTotal));
					 break;
					 
			case 2: price = o.searchOrderByName(selectMenu);
					total = o.calculateTotal(price);
					gTotal = Double.parseDouble(total.substring(1));
					sum += gTotal;
					orderList.add(new Order(selectMenu, price, qty, gTotal));
					break;
					
			
		}
		System.out.println("Anything else....(Y/N)");
		ch = sc.next();
		
			
		}
		System.out.println("Enter the Mode of Payment Option...");
		System.out.println("1. Cash");
		System.out.println("2. Credit");
		System.out.println("3. Cheque");
		int payType = sc.nextInt();
		o.modeOfPayment(payType);
		printReceipt(orderList,o.formatTotal(sum));
		sc.close();
	}
		
		
		
		public static void printReceipt(List<Order> orderList,String sum)
		{
			
			System.out.println("Your Receipt");
			System.out.println("++++++++++++");
			System.out.println("Item\tPrice\tQuantity\tSales_Tax\tTotal");
			System.out.println("++++\t+++++\t++++++++\t+++++++++\t+++++");
			for (Order o : orderList)
			{
				
				System.out.println(o.getpName() + "\t" +o.getPrice()+"\t"+ o.getQuantity() +"\t"
								+"\t6%\t\t" + o.getGrandTotal());
			}
			System.out.println();
			System.out.println("Billing Amount: "+ sum);
			System.out.println();
			System.out.println("Thank You...Have a Good Day!");
		}
		

	

}
