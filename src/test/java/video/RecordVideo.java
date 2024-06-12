package video;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RecordVideo {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		BrowserType browserType = pw.chromium();
		
		LaunchOptions headless= new BrowserType.LaunchOptions().setHeadless(false);
		
		Browser browser = browserType.launch(headless);
		
		BrowserContext context = browser.newContext(new NewContextOptions()
								.setRecordVideoDir(Paths.get("videos/"))
								.setRecordVideoSize(1280, 720));
		
		Page page=context.newPage();
		
		 page.navigate("https://www.saucedemo.com/");
	      page.locator("[data-test=\"login-credentials\"]").click();
	      page.locator("[data-test=\"username\"]").click();
	      page.locator("[data-test=\"username\"]").fill("standard_user");
	      page.locator("[data-test=\"password\"]").click();
	      page.locator("[data-test=\"password\"]").fill("secret_sauce");
	      page.locator("[data-test=\"login-button\"]").click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
	      page.locator("[data-test=\"logout-sidebar-link\"]").click();
		context.close();
		pw.close();
	
	}

}
