package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		Installer.class,
	AddContentTest.class,
	ChangeUrlTest.class,
	ChangePositionTest.class,
	ChangeParentTest.class,
	AddAsDraftTest.class,
	SetStickyPostTest.class,
	DeletePostTest.class,
	AddUserTest.class,
	DisableUserTest.class,
	ChangePasswordTest.class,
	AddSocialsTest.class,
	ChangeHomeTest.class,
	OrderByPositionTest.class,
	AddSiteSocialTest.class,
	SetFooterTest.class,
	ChangeLanguageTest.class,
	DeleteUserTest.class,
	ChangePostDateTest.class,
	BadLoginFailsTest.class,
	AddCategoryTest.class,
	ChangeCategoryUrlTest.class,
	AssignCategoryTest.class,
	SeeCategoryArticlesTest.class,
	DeleteCategoryTest.class,
	EmptyLoginFailsTest.class,
})

public class TestSuite {}