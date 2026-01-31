package base;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AddUserTest.class,
	AddExistingUserFailsTest.class,
	AddEmptyUserFailsTest.class,
	AddProjectTest.class,
	AddExistingProjectFailsTest.class,
	AddCategoryTest.class,
	AddExistingCategoryFailsTest.class,
	AddIssueTest.class,
	AssignIssueTest.class,
	UpdateIssuePriorityTest.class,
	UpdateIssueSeverityTest.class,
	UpdateIssueStatusNewTest.class,
	UpdateIssueStatusFeedbackTest.class,
	UpdateIssueStatusAcknowledgedTest.class,
	UpdateIssueStatusConfirmedTest.class,
	UpdateIssueStatusAssignedTest.class,
	UpdateIssueStatusResolvedTest.class,
	UpdateIssueSummaryTest.class,
	UpdateProjectStatusTest.class,
	UpdateProjectDescriptionTest.class,
	UpdateProjectViewStatusTest.class,
	UpdateCategoryTest.class,
	UpdateCategoryEmptyTest.class,
	UpdateUserTest.class,
	UpdateUserEmptyTest.class,
	DeleteIssueTest.class,
	DeleteCategoryTest.class,
	DeleteProjectTest.class,
	DeleteUserTest.class,
	BadLoginTest.class,
	LogoutTest.class,
	AddMultipleUsersTest.class,
	DeleteMultipleUsersTest.class,
	AddMultipleSubprojectsTest.class,
	UnlinkMultipleSubprojectsTest.class,
	LinkMultipleSubprojectsTest.class,
	DeleteMultipleProjectsTest.class,
})
public class TestSuite {}