package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.Home;
import po.ProductPage;



public class SeeReviewTest extends BaseTest {

	@Test
	public void testExpressCartSeeReview() throws Exception {
		goToHome();
		ProductPage product = new Home(driver)
			.goToProduct("NewProduct000")
			.recentReviews();
		
		assertEquals(product.getReviewTitle(), "Title: Review000");
		assertEquals(product.getReviewDescription(), "Description: Description000");
		assertEquals(product.getReviewRating(), "Rating: 5");
		
		
	}


}
