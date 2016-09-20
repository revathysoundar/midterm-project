package java_shop;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
	
	@Test
	public void whengrandTotal2_12()
	{
		Order o = new Order();
		Assert.assertEquals("$2.12",o.calculateTotal("2.00"));
	}
	
	@Test
	public void whengrandTotal3_71()
	{
		Order o = new Order();
		Assert.assertEquals("$3.71",o.calculateTotal("3.50"));
	}
	
	@Test
	public void whenProductCodeC001_ExpectCoffee()
	{
		Order o = new Order();
		String pName = o.searchForProduct("C001");
		Assert.assertEquals("Coffee", pName);
	}
	
	@Test
	public void whenProductNameCookie_ExpectCookie()
	{
		Order o = new Order();
		String price = o.searchOrderByName("Cookie");
		Assert.assertEquals("3.50", price);
		
	}
	
	@Test
	public void whenformatTotal$2_3400()
	{
		Order o = new Order();
		String total = o.formatTotal(2.3400);
		Assert.assertEquals("$2.34", total);
	}
	
	@Test
	public void whenProductCodeC002_ExpectFrapp()
	{
		Order o = new Order();
		String pName = o.searchForProduct("C002");
		Assert.assertEquals("Frapp", pName);
	}

	@Test
	public void whenProductNameMilk_ExpectMilk()
	{
		Order o = new Order();
		String price = o.searchOrderByName("Milk");
		Assert.assertEquals("3.25", price);
		
	}
	
	@Test
	public void whenformatTotal$3_7100()
	{
		Order o = new Order();
		String total = o.formatTotal(3.7100);
		Assert.assertEquals("$3.71", total);
	}
	
		
}

