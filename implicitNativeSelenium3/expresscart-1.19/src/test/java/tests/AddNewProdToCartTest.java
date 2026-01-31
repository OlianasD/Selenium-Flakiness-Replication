package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.CartSidebar;
import po.Home;




public class AddNewProdToCartTest extends BaseTest {


	@Test
	public void testExpressCartAddNewProdToCart() throws Exception {
		int item_id = 1;
		goToHome();
		Home home = new Home(driver)
				.goToProduct(item_id)
				.addToCart()
				.goHome();
		assertEquals(1, home.getCartCount());
		CartSidebar cart = home.openCart();
		assertEquals("NewProduct000", cart.getIthItem(item_id));
		
	}



}
