package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	AddNewProduct.class,
	AddEmptyProduct.class,
	EditProduct.class,
	AddNewState.class,
	AddEmptyState.class,
	AddNewProductWithTax.class,
	AddNewProductWithTax10.class,
	AddNewFeatures.class,
	AddEmptyFeature.class,
	AddNewAttribute.class,
	AddEmptyAttribute.class,
	AddNewAddress.class,
	AddEmptyAddress.class,
	AddNewCategory.class,
	AddEmptyCategory.class,
	EditCategory.class,
	AddNewManufacturer.class,
	AddEmptyManufacturer.class,
	EditManufacturer.class,
	AddNewSupplier.class,
	AddEmptySupplier.class,
	RemoveSupplier.class,
	RegisterEmployee.class,
	RegisterEmployee_NoName.class,
	RegisterEmployee_NoEmail.class,
	RegisterEmployee_NoPassword.class,
	OutOfStockValidity.class,
	AddTag.class,
	AddEmptyTag.class,
	AddCurrency.class,
	AddEmptyCurrency.class,
	EditAddress.class,
	EditEmployee.class,
})
public class TestSuite {}
