package shadowdom;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingShadowDomElements {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page pg = browser.newPage();
		
		/*
		 * pg.navigate("https://selectorshub.com/xpath-practice-page/");
		 * 
		 * pg.locator("div#userName input#kils").fill("rameshn3");
		 */
			pg.navigate("https://books-pwakit.appspot.com/");
			
			
		pg.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
		
		String txt = pg.locator("book-app[apptitle='BOOKS'] div.books-desc").textContent();
		System.out.println(txt);
		
		
		  pg.close(); browser.close(); pw.close();
		 
		
	}

}
