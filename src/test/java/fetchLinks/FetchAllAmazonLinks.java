package fetchLinks;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FetchAllAmazonLinks {

	public static void main(String[] args) {
		try(Playwright pw = Playwright.create()){
			
			Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			Page pg =browser.newPage();
			//navigate to the amazon
			pg.navigate("https://www.amazon.in/");
			
			List<String>amazonLinksList=pg.locator("a:has-text('Amazon')").allInnerTexts();
			
			//stream concept for iteartion
			amazonLinksList.stream().forEach(e->System.out.println(e));
			
			pg.close();
			browser.close();
		}

	}

}
