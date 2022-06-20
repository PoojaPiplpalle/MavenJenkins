package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountpage;
	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable credTable) {
		List<Map<String,String>>  credlist=credTable.asMaps();
		String username=credlist.get(0).get("username");
		String password=credlist.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountpage=loginPage.doLogin(username,password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	String title=accountpage.getAccountsPageTitle();
	System.out.println("Accounts page title is :"+title);
	
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionstable) {
		List<String>  expAccountSectionsList=sectionstable.asList();
		System.out.println("Expected Accounts section list:"+expAccountSectionsList);
		
		List<String> actualAccountSectionslist=accountpage.getAccountsSectionslist();
		System.out.println("Actual Accounts section list:"+actualAccountSectionslist);
		
		Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionslist));
		
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer ExpectedSectioncount) {
	    Assert.assertTrue(accountpage.getAccountsSectionCount()==ExpectedSectioncount);
	}

}
