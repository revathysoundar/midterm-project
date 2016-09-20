package java_shop;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

public class ProductClass {
	/**This product class sets and retrieves product information
	 */
	 
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

	public List<ProductClass> getAll()
	{
		List<ProductClass> productList = new ArrayList<>();
		ProductTextClass prd = new ProductTextClass();
		productList = prd.readFromFile();
		return productList;
	}
	public  void displayAllProducts()
	{
		List<ProductClass>productList = getAll();
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
				System.out.println(p.getProductCode() + "\t\t" + p.getProductName() + "\t\t" + p.getProductDescription()
				+ "\t\t" + p.getPrice());
			}
		}
	}
}
