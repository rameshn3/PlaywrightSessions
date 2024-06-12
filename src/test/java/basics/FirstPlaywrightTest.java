package basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstPlaywrightTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright pw = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		Browser browser= pw.chromium().launch(lp);
		
		//	browser = pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		
		page.navigate("https://linkedin.com");
		
		String t=page.title();
		System.out.println("title is:"+t);
		
		String url=page.url();
		System.out.println("url is:"+url);
		
		browser.close();
		
		pw.close();
		
	}

}
