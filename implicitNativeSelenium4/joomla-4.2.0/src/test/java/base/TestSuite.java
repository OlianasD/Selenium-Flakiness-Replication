package base;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	AdminLoginTest.class,
	BadLogin.class,
	EmptyLogin.class,
	AddUser.class,
	LoginAsNewUser.class,
	BadSiteAdminLogin.class,
	EmptySiteAdminLogin.class,
	AddNewArticle.class,
	AddEmptyArticle.class,
	EditArticle.class,
	DeleteArticle.class,
	AddCategory.class,
	AddEmptyCategory.class,
	AssignCategory.class,
	ChangePassword.class,
	ChangePasswordDontMatch.class,
	AddMenuItem.class,
	AddMenuItem_EmptyTitle.class,
	AddMenuItem_MenuNotSelected.class,
	AddMenuItem_EmptyMenuType.class,
	ArchiveArticle.class,
	SeeArchivedArticle.class,
	AddGroup.class,
	AddEmptyGroup.class,
	AssignUserToGroup.class,
	AddField.class,
	AddEmptyField.class,
	AddFieldGroup.class,
	AddEmptyFieldGroup.class,
	AssignFieldToGroup.class,
	DeleteUserGroup.class,
	DeleteField.class,
	DeleteFieldGroup.class,
	DeleteUser.class,
	DeleteCategory.class,
	
})
public class TestSuite {}