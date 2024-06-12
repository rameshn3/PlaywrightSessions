package basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleIframe {

	public static void main(String[] args) throws InterruptedException {
		try(Playwright playwright = Playwright.create()){
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			
			//navigate to the url
			page.navigate("https://jqueryui.com/autocomplete/");
			
			//locate the frame using locator
		FrameLocator iframe =	page.frameLocator(".demo-frame");
			
			//type the value in the tags editbox
		iframe.locator("#tags").fill("playwright");
		
		Thread.sleep(2000);
		//close the browser
		browser.close();
		}
	}

}
