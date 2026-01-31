package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AddUserTest.class,
	AddEmptyUserTest.class,
	LoginUserTest.class,
	AddExistingUserFailsTest.class,
	AddProductTest.class,
	AddEmptyProductTest.class,
	AddNewProdToCartTest.class,
	SearchProductTest.class,
	AddReviewTest.class,
	AddEmptyReviewTest.class,
	SeeReviewTest.class,
	AddDiscountCodeAmountTest.class,
	AddDiscountCodePercentTest.class,
	AddEmptyDiscountCodeTest.class,
	UseDiscountCodeAmountTest.class,
	UseDiscountCodePercentTest.class,
	AddProductTagTest.class,
	SearchProductTagTest.class,
	AddMenuTest.class,
	OpenMenuTest.class,
	DeleteDiscountCodeAmountTest.class,
	DeleteDiscountCodePercentTest.class,
	DeletedDiscountCodeFailsAmountTest.class,
	DeletedDiscountCodeFailsPercentTest.class,
	DeleteUserTest.class,
	LoginDeletedUserFailsTest.class,
	DeleteReviewTest.class,
	DeleteProductTagTest.class,
	SearchDeletedProductTagFailsTest.class,
	DeleteProductTest.class,
	SearchDeletedProductFailsTest.class,
})

public class TestSuite {}