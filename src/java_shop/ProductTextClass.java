
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

	private List<ProductClass> products = new ArrayList<>();
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
			checkForFile();
			File file = filePath.toFile();
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			
			while((line = bufferedReader.readLine()) != null)
			{
				String[] columns = new String[5];
				columns = line.split(FIELD_SEP);
				String productCode = columns[0];
				String productName = columns[1];
				String productDescription = columns[2];
				String price = columns[3];
				
				ProductClass p = new ProductClass();
				p.setProductCode(productCode);
				p.setProductName(productName);
				p.setProductDescription(productDescription);
				p.setPrice(price);
				products.add(p);
			}
			bufferedReader.close();
		}catch(IOException ex)
		{
			throw new RuntimeException("Unable to read the file"+ex.getMessage());
		}catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("The Product File is empty");
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
			checkForFile();
			File file = filePath.toFile();
			FileWriter fstream = new FileWriter(file,true);
            BufferedWriter fbw = new BufferedWriter(fstream);
            //fbw.write("append txt...");
			//PrintWriter writer = new PrintWriter(
								// new BufferedWriter(
								// new FileWriter(file)));
			
			for(ProductClass prod : product)
			{
				fbw.write(prod.getProductName() + FIELD_SEP);
				fbw.write(prod.getProductDescription() + FIELD_SEP);
				fbw.write(prod.getPrice() + FIELD_SEP);
				fbw.newLine();
				
			}
				//writer.flush();
				fbw.close();
			
			
		}catch(IOException ex)
		{
			throw new RuntimeException("EXCEPTION :Unable to write it into the file" + ex.getMessage());
		}
		
		
	}
		
}
	

