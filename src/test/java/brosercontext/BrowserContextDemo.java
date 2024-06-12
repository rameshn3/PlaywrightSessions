package brosercontext;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;

public class BrowserContextDemo {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		BrowserType browserType = pw.webkit();
		
		LaunchOptions headless= new BrowserType.LaunchOptions().setHeadless(false);
		
		Browser browser = browserType.launch(headless);
		
		BrowserContext context = browser.newContext();
		
		Page page=context.newPage();
		
		 page.navigate("https://www.saucedemo.com/");
	      page.locator("[data-test=\"login-credentials\"]").click();
	      page.locator("[data-test=\"username\"]").click();
	      page.locator("[data-test=\"username\"]").fill("standard_user");
	      page.locator("[data-test=\"password\"]").click();
	      page.locator("[data-test=\"password\"]").fill("secret_sauce");
	      page.locator("[data-test=\"login-button\"]").click();
			/*
			 * page.getByRole(AriaRole.BUTTON, new
			 * Page.GetByRoleOptions().setName("Open Menu")).click();
			 * page.locator("[data-test=\"logout-sidebar-link\"]").click();
			 */
		
	      //openning new Tab
	      BrowserContext context2 = browser.newContext();
	      Page newwindow=context2.newPage();
			
	      newwindow.navigate("https://www.saucedemo.com/");
	     newwindow.locator("[data-test=\"login-credentials\"]").click();
	      
	     page.bringToFront();
	     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
	      
	     //context.close();
		//pw.close();
	}

}
