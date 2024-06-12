package screen;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;

public class TakeScreenshot {

	public static void main(String[] args) {
		
	Playwright pw = Playwright.create();
	
	Page pg = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

	//navigate to the url
	pg.navigate("https://www.amazon.com/");
	
	//normal screenshot
	pg.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screens/initialhomepage.png")));
	//taking fullpage screenshot
	pg.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screens/fullhomepage.png")).setFullPage(true));
	
	//take screenshot of search editbox
	Locator searchBox=pg.locator("id=twotabsearchtextbox");
	searchBox.click();
	searchBox.screenshot(new Locator.ScreenshotOptions()
			 .setPath(Paths.get("./screens/searchbox-init.png")));
			 
		
		
	pw.close();
	
	}

}
