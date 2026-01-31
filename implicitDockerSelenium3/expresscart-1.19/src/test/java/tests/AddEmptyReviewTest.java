package tests;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.Home;
import po.ReviewForm;



public class AddEmptyReviewTest extends BaseTest {


	@Test
	public void testExpressCartAddEmptyReview() throws Exception {
		goToHome();
		ReviewForm product = new Home(driver)
			.account()
			.setEmail("test@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.loginAndGoHome(appUrl)
			.goToProduct("NewProduct000")
			.addReview()
			.addReviewError();
			
		assertEquals("Please supply a review title", product.getAlertMessage());
	}



}
