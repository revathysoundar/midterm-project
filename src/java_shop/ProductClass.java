package java_shop;

public class ProductClass {
	
	public String productName;
	public String productDescription;
	//public String productCategory;
	public String price;
	
	public double grandtotal;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public double subTotal;
	public String formOfPayment;
	
	
	/**
	 * Calculate SubTotal, GrandTotal, SalesTax
	 */
	public void calculateTotal()
	{
		
	}
	
	/**
	 * 
	 * Format to 2 decimal places
	 * @param total
	 * @return
	 */
	public String formatTotal(double total)
	{
		return null;
	}
	
	
	/**
	 * Mode of payment, to pay the receipt
	 * @param formOfPayment
	 */
	public void paymentType(String formOfPayment)
	{
		
	}
	
	
	/**
	 * Display the receipt to the User
	 */
	public void displayReceipt()
	{
		
	}

	
	
	
	

}
