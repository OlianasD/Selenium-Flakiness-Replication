package mediawiki;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CreateUserTest.class,
	CloseInitialEditorPopupTest.class,
	CreatePageTest.class,
	CreateAndLinkPageTest.class,
	SearchPageTest.class,
	EditPageTest.class,
	CreateTemplateTest.class,
	CreatePageFromSourceTest.class,
	ApplyTemplateTest.class,
	AddCategoryTest.class,
	ProtectPageTest.class,
	AdminEditProtectedPage_GetsWarningTest.class,
	EditProtectedPage_ForbiddenTest.class,
	PromoteToAdminTest.class,
	EditProtectedPage_NewAdmin_SuccessTest.class,
	RevertLastCommitTest.class,
	CreateUserPageTest.class,
	BlockUserTest.class,
	BlockedUser_CantEditTest.class,
	DeletePageTest.class,
	CreateRedirectTest.class,
	FollowRedirectTest.class,
	ChangePassword_TooShortTest.class,
	ChangePassword_TooCommonTest.class,
	ChangePassword_OKTest.class,
	CreateBlankPage_GetsWarningTest.class,
	CreateEmptyUser_Fails.class,
})
public class TestSuite {}