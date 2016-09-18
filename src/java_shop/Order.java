package java_shop;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private static final double SALES_TAX = 0.06;
	public String pName;
	public String price;
	public double quantity;
	public double subTotal;
	public double total;
	public double grandTotal;
	List<Order> order = new ArrayList<>();
	
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

	public String searchOrderByName(String oName )
	{
		List<ProductClass> productList = new ArrayList<>();
		ProductTextClass prd = new ProductTextClass();
		productList = prd.readFromFile();
		for (ProductClass p : productList){
			if(p.getProductName().equals(oName))
				return p.getPrice();
		}
		return null;
	}
	
	public String searchOrderByNumber(String oCode )
	{
		List<ProductClass> productList = new ArrayList<>();
		ProductTextClass prd = new ProductTextClass();
		productList = prd.readFromFile();
		for (ProductClass p : productList){
			if(p.getProductCode().equals(oCode))
				return p.getPrice();
		}
		return null;
	}
	
	public String searchForProduct(String oCode )
	{
		List<ProductClass> productList = new ArrayList<>();
		ProductTextClass prd = new ProductTextClass();
		productList = prd.readFromFile();
		for (ProductClass p : productList){
			if(p.getProductCode().equals(oCode))
				return p.getProductName();
		}
		return null;
	}
	
	
	public String calculateTotal(String price)
	{
		double dprice = Double.parseDouble(price);
		total = dprice * quantity;
		subTotal = total * SALES_TAX;
		grandTotal = subTotal   + total;
		return formatTotal(grandTotal);
	}
	
	public String formatTotal(double grandTotal)
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String billAmount = currency.format(grandTotal);
		return billAmount;
	}
	
	public void modeOfPayment(int payType)
	{
		
		
		//use switch case for cash, credit, cheque and do the corresponding actions as per the document
		
	}
	

}
