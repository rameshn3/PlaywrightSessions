package draganddrop;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;

public class DragAndDropTest {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		BrowserType browserType = pw.chromium();
		
		LaunchOptions headless= new BrowserType.LaunchOptions().setHeadless(false);
		
		Browser browser = browserType.launch(headless);

		Page page=browser.newPage();
		
		//navigate to the url
		page.navigate("https://jqueryui.com/droppable/");
		
		//switch to the iframe
		
	FrameLocator frme=	page.frameLocator("iframe.demo-frame");
	
	Locator src = frme.locator("#draggable");
	Locator tgt = frme.locator("#droppable");
	
	//perform the drag and drop action
	src.dragTo(tgt);
	
	//fetch the text
	String droppableTxt=tgt.textContent();
	System.out.println("Droppable element text:"+droppableTxt);
	
	pw.close();
	
	}

}
