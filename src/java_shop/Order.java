package java_shop;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

public class Order extends ProductClass{
	
	
	
	private static final double SALES_TAX = 0.06;
	public String pName;
	public String price;
	public double quantity = 1;
	public double tax;
	public double total;
	public double grandTotal;
	List<Order> order = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	String pNotFound = "Product Not Found";
	
	public Order()
	{
		
	}
	
	public Order(String pName, String price, double qty, double gTotal)
	{
		this.pName = pName;
		this.price = price;
		this.quantity = qty;
		this.grandTotal = gTotal;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getQuantity() {
		return quantity;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String searchOrderByName(String oName )  throws  NullPointerException
	{
		List<ProductClass>productList = getAll();
		for (ProductClass p : productList){
			if(p.getProductName().equals(oName))
				return p.getPrice();
		}
		return pNotFound;
	}
	
	public String searchForProductName(String oName )  throws  NullPointerException
	{
		List<ProductClass>productList = getAll();
		for (ProductClass p : productList){
			if(p.getProductName().equals(oName))
				return p.getProductName();
		}
		return pNotFound;
	}
	
	public String searchOrderByNumber(String oCode ) throws  NullPointerException
	{
		List<ProductClass>productList = getAll();
		for (ProductClass p : productList){
			if(p.getProductCode().equals(oCode))
				return p.getPrice();
		}
		return pNotFound;
	}
	
	public String searchForProduct(String oCode ) throws  NullPointerException
	{
		List<ProductClass>productList = getAll();
		for (ProductClass p : productList){
			if(p.getProductCode().equals(oCode))
				return p.getProductName();
		}
		return pNotFound;
	}
	
	
	public String calculateTotal(String price) throws  NullPointerException
	{
		double dprice = 0.0;
		try
		{
			 dprice = Double.parseDouble(price);
		}catch(NumberFormatException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		total = dprice * quantity;
		tax = total * SALES_TAX;
		grandTotal = tax   + total;
		return formatTotal(grandTotal);
	}
	
	public String formatTotal(double grandTotal)
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String billAmount = currency.format(grandTotal);
		return billAmount;
	}
	
	public String modeOfPayment(int payType,double sum) 
	{
		switch(payType)
		{
			case 1:	System.out.println("Enter the dollars");
					double change = sc.nextDouble();
					if(change < sum)
					{
						System.out.println("Insufficient Dollars... Please enter again");
						change = sc.nextDouble();
					}
					change = change - sum;
					System.out.println("Change: "+formatTotal(change)+"\n");
					return formatTotal(change);
					
			
				
			case 2:	System.out.println("Enter the credit card details");
					long cardNumber = sc.nextInt();
					int cvv = sc.nextInt();
					
					break;
			
				
			case 3:	System.out.println("Enter the check number...");
					String check = sc.next();
					break;
		}
		return null;
	}
	

}
