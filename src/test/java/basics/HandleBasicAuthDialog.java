package basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleBasicAuthDialog {

	public static void main(String[] args) {
		try(Playwright playwright = Playwright.create()){
			Browser browser = playwright.chromium().launch();
			
		//handling the basic in browsercontext
			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin","admin"));
			
			//create page object
			Page page = context.newPage();
			
			page.navigate("https://the-internet.herokuapp.com/basic_auth");
			System.out.println(page.locator("h3").textContent());
			System.out.println(page.locator("#content > div > p").textContent());
		}
	}

}
