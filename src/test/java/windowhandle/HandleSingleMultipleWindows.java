package windowhandle;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class HandleSingleMultipleWindows {

	public static void main(String[] args) {
	
		Playwright pw = Playwright.create();
		BrowserType browserType = pw.chromium();
		
		LaunchOptions headless= new BrowserType.LaunchOptions().setHeadless(false);
		
		Browser browser = browserType.launch(headless);

		Page page=browser.newPage();
		
		//navigate to the url
		page.navigate("https://letcode.in/windows");
		
		/*
		 * //write event listenr Page popup=page.waitForPopup(()->{
		 * page.locator("id=home").click(); });
		 * 
		 * //wait for the popup page.waitForLoadState();
		 * 
		 * System.out.println("page title:"+popup.title());
		 * System.out.println("page url:"+popup.url());
		 */
		//popup.close();
		//page.close();
		//pw.close();
		
		//handling multiple windows
		page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(p->p.context().pages().size()==3),()->{
			page.locator("id=multi").click();
		});
		
		List<Page>pageList=page.context().pages();
		for(Page tabs:pageList) {
			tabs.waitForLoadState();
			System.out.println(tabs.url());
		}
		
		Page alertpg=pageList.get(1);
		Page dropdownpg=pageList.get(2);
		System.out.println("Alert page heading:"+alertpg.textContent("h1"));
		System.out.println("Dropdown page heading:"+dropdownpg.textContent("h1"));
		pw.close();
	}

}
