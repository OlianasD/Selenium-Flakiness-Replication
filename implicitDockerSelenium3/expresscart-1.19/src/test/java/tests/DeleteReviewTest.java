package tests;


import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.AdminLoginPage;
import po.ReviewsPage;


public class DeleteReviewTest extends BaseTest {

	@Test
	public void testExpressCartDeleteReview() throws Exception {
		goToAdminHome();
		ReviewsPage reviews = new AdminLoginPage(driver)
			.setEmail("owner@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.doLogin()
			.reviews()
			.deleteFirstReview()
			.reviews();
		assertFalse(reviews.containsReview("Review000"));

	}


}
