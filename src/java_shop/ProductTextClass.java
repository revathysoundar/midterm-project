package java_shop;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Revathy
 *
 * ProductText class will read and write to a text file	
 */

public class ProductTextClass {

	private static  List<ProductClass> products = new ArrayList<>();
	private static final String FIELD_SEP = "\t";
	private Path filePath = Paths.get("C:/Users/Administrator/workspace/midterm-project/src/java_shop/Product.txt");
	
	/**
	 *  Checks for the file in the specified path, if not found creates a new file 
	 */
	public void checkForFile()
	{
		
		if(Files.exists(filePath))
		{
			return;
		}
		
		File file = new File("C:/Users/Administrator/workspace/midterm-project/src/java_shop/Product.txt");
		try
		{
			file.createNewFile();
			System.out.println("File created!");
		}catch(IOException ex)
		{
			throw new RuntimeException(ex.getMessage());
		}
	}

	/**
	 * Read from the text file
	 * 
	 */
	
	public List<ProductClass> readFromFile()
	{
		try
		{
			File file = filePath.toFile();
			//FileReader reads text files
			FileReader fileReader = new FileReader(file);
			//FileReader is usually wrapped up in BufferedReader 
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			
			while((line = bufferedReader.readLine()) != null)
			{
				String[] columns = new String[5];
				columns = line.split(FIELD_SEP);
				String productName = columns[0];
				String productDescription = columns[1];
				String price = columns[2];
				
				ProductClass p = new ProductClass();
				p.setProductName(productName);
				p.setProductDescription(productDescription);
				p.setPrice(price);
				products.add(p);
				//System.out.println(p.getProductName() + FIELD_SEP.toString() + p.getProductDescription()
									//+ FIELD_SEP.toString() + p.getPrice());
				//System.out.println(p.getProductDescription());
				//System.out.println(p.getPrice());
				
				
			}
			bufferedReader.close();
			
			
		}catch(IOException ex)
		{
			throw new RuntimeException("Unable to read the file"+ex.getMessage());
		}
		return products;
	}
	
	/**
	 * Write to the text file
	 * 
	 */
		
	public void writeToFile(List<ProductClass> product)
	{
		try
		{
			File file = filePath.toFile();
			PrintWriter writer = new PrintWriter(
								 new BufferedWriter(
								 new FileWriter(file)),true);
			
			for(ProductClass prod : product)
			{
				writer.print(prod.getProductName() + FIELD_SEP);
				writer.print(prod.getProductDescription() + FIELD_SEP);
				writer.println(prod.getPrice() + FIELD_SEP);
				
			}
				writer.flush();
				writer.close();
			
			
		}catch(IOException ex)
		{
			throw new RuntimeException("EXCEPTION :Unable to write it into the file" + ex.getMessage());
		}
		
		
	}
		
}
	

