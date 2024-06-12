package basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingAlertsOnDialog {

	public static void main(String[] args) {
		try(Playwright playwright = Playwright.create()){
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			
			//navigate to the url
			page.navigate("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
			
			//fetch all the 3 buttons
			Locator buttons = page.locator("text='Click Me'");
			
			//write a listenr for all dialog events
			page.onDialog(dialog ->{
				System.out.println("dialog message :"+dialog.message());
				//click on ok button
				dialog.accept("playwright");
			});
			
			//trigger multiple dialogs
			buttons.first().click(); //trigger simple alert
			buttons.nth(1).click(); //trigger another confirmations dialog
			buttons.last().click(); //trigger another prompt dialog
		}

	}

}
