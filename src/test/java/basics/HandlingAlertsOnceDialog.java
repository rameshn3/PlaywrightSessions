package basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingAlertsOnceDialog {

	public static void main(String[] args) {
		try(Playwright playwright = Playwright.create()){
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			
			//navigate to the url
			page.navigate("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
			
			//fetch all the 3 buttons
			Locator buttons = page.locator("text='Click Me'");
			
			//setup a one time listenr to handle single dialog events
			page.onceDialog(dialog ->{
				System.out.println("dialog message :"+dialog.message());
				//click on ok button
				dialog.accept();
			});
			
			//trigger multiple dialogs
			buttons.first().click(); //trigger simple alert
			
			//set up another listenr event for confirmation dialog
			page.onceDialog(dialog ->{
				System.out.println("dialog message :"+dialog.message());
				//click on ok button
				dialog.accept();
			});
			
			
			buttons.nth(1).click(); //trigger another confirmations dialog
			System.out.println("confirmation msg after  ok confirm event trigger:"+page.locator("#confirm-demo").textContent());
			
			
			//setup another listenr event for prompt dialog
			//set up another listenr event for confirmation dialog
			page.onceDialog(dialog ->{
				System.out.println("dialog message :"+dialog.message());
				//click on ok button
				dialog.dismiss();
			});
			buttons.nth(1).click(); //trigger another confirmations dialog
			System.out.println("confirmation msg after cancel confirm event trigger:"+page.locator("#confirm-demo").textContent());
			
			
			//setup a lister for prompt dialog
			page.onceDialog(dialog ->{
				System.out.println("dialog message :"+dialog.message());
				//click on ok button
				dialog.accept("playwright");
			});
			
				
			buttons.last().click(); //trigger another prompt dialog
			
			System.out.println("prompt ok event:"+page.locator("#prompt-demo").textContent());
			
			
			//setup a lister for prompt dialog
			page.onceDialog(dialog ->{
				System.out.println("dialog message :"+dialog.message());
				//click on ok button
				dialog.dismiss();
			});
			
				
			buttons.last().click(); //trigger another prompt dialog
			
			System.out.println("prompt cancel event:"+page.locator("#prompt-demo").textContent());
		}

	}

}
