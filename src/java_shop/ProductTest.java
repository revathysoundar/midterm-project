package java_shop;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
	
	@Test
	public void whenChange10Expect_5_76()
	{
		Order o = new Order();
		String change = o.modeOfPayment(1, 4.24);
		Assert.assertEquals("$5.76", change);
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
	

}
