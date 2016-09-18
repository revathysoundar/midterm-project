package java_shop;

import java.util.ArrayList;
import java.util.List;

public class ProductClass {
	
	public String productCode;
	public String productName;
	public String productDescription;
	public String price;
	

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductName() {
		return productName;
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

	public  void displayAllProducts()
	{
		ProductTextClass prd = new ProductTextClass();
		List<ProductClass> productList = new ArrayList<>();
		productList = prd.readFromFile();
		if(productList == null){
			System.out.println("\n Unable to get products from file \n");
		}else
		{
			for(ProductClass p : productList)
			{
				p.getProductCode();
				p.getProductName();
				p.getProductDescription();
				p.getPrice();
				System.out.println(p.getProductName() + "\t\t" + p.getProductDescription()
				+ "\t\t" + p.getPrice());
			}
			
			
		}
	}
}
