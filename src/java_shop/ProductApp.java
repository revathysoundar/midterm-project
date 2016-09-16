package java_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lab15.CountriesTextFile;

public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int menuChoice;
		
		System.out.println("Welcome to Java Shop!");
		String addProduct;
		ProductClass product = new ProductClass();
		List<ProductClass> productList = new ArrayList<>();
		ProductTextClass ptf = new ProductTextClass();
		String ch = "y";
		while(ch.equalsIgnoreCase("y"))
		{
			
			System.out.println("1 - See the list of Products");
			System.out.println("2 - Add a Product");
			System.out.println("3 - Exit");
			System.out.println("Enter menu number: ");
			menuChoice = sc.nextInt();
		switch(menuChoice)
		{
			case 1:	displayAllProducts();
					break;
			case 2: System.out.println("Entry Product");				
					product.setProductName("Tea");
					product.setProductDescription("Masala Chai");
					product.setPrice("2.50");
					productList.add(product);
					ptf.writeToFile(productList);
					System.out.println("This Product has been saved");
					break;
			case 3: ch = "n";
					sc.close();
					break;
		}
		
		
		}
	}
		
		public static void displayAllProducts()
		{
			
			ProductClass product = new ProductClass();
			ProductTextClass prd = new ProductTextClass();
			ProductClass prod;
			List<ProductClass> productList = new ArrayList<>();
			productList = prd.readFromFile();
			if(productList == null){
				System.out.println("\n Unable to get products \n");
			}else
			{
				StringBuilder sb = new StringBuilder();
				for(ProductClass p : productList)
				{
					prod = p;
					sb.append(prod.getProductName());
					sb.append(prod.getProductDescription());
					sb.append(prod.getPrice());
					sb.append("\n");
				}
				sb.toString();
				
			}
		}

	

}
