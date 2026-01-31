package tests;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.Home;
import po.ProductPage;



public class AddReviewTest extends BaseTest {


	@Test
	public void testExpressCartAddReview() throws Exception {
		goToHome();
		ProductPage product = new Home(driver)
			.account()
			.setEmail("test@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.loginAndGoHome(appUrl)
			.goToProduct("NewProduct000")
			.addReview()
			.setTitle("Review000")
			.setDescr("Description000")
			.setRating("5")
			.addReview()
			.recentReviews();
		
		assertEquals(product.getReviewTitle(), "Title: Review000");
		assertEquals(product.getReviewDescription(), "Description: Description000");
		assertEquals(product.getReviewRating(), "Rating: 5");
	}



}
