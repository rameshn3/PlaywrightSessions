package menu;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class MenuHandlingTest {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		BrowserType browserType = pw.chromium();
		
		LaunchOptions headless= new BrowserType.LaunchOptions().setHeadless(false);
		
		Browser browser = browserType.launch(headless);

		Page page=browser.newPage();
		
		//navigate to the url
		page.navigate("https://jqueryui.com/menu/");
		
		//switch to the iframe
		
	FrameLocator frme=	page.frameLocator("iframe.demo-frame");

	//mouse hover on the music element to open the submenu
	frme.locator("#ui-id-9").hover();
	
	//wait for the submenu
	frme.locator("#ui-id-10").waitFor();
	
	//mouseover on the Rock
	frme.locator("#ui-id-10").hover();
	
	//wait for the classic submenu
	frme.locator("#ui-id-12").waitFor();
	
	//click on the classic
	frme.locator("#ui-id-12").click();
	
	//close the playwright object
	pw.close();
	
	}

}
