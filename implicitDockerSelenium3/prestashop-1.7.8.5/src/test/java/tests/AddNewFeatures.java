package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.FeaturesPage;
import po.PrestaLogin;

public class AddNewFeatures extends BaseTest {

		 @Test()
		 public void test_add_features(){
			FeaturesPage features = new PrestaLogin(driver)
					.loginToPresta(adminMail, adminPsw)
					.goToFeatures()
					.goToFeaturesTab()
					.clickAddFeature()
					.addName("Strong")
					.submitFeature();
			 assertTrue(features.getSuccessMessage().contains("Successful creation"));
		 }
	}
