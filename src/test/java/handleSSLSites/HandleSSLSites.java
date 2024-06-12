package handleSSLSites;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleSSLSites {

	public static void main(String[] args) {
		
		try (Playwright pw = Playwright.create()){
			
			Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));
			
			Page pg = context.newPage();
			
			//trigger the listener event
			pg.onDialog(dialog->{
				dialog.dismiss();
			});
			
			//navigate to the url
			pg.navigate("https://self-signed.badssl.com/");
			System.out.println("page title is:"+pg.title());
			System.out.println("page url is:"+pg.url());
			
			pg.close();
			context.close();
			browser.close();
		}

	}

}
