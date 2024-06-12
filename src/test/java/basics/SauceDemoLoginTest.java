package basics;
import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;


public class SauceDemoLoginTest {
	
	
	  public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      //start the trace viwer with different options
	      context.tracing().start(new Tracing.StartOptions()
	    		  .setScreenshots(true)
	    		  .setSnapshots(true)
	    		  .setSources(true));
	      		
	      page.navigate("https://www.saucedemo.com/");
	      page.locator("[data-test=\"login-credentials\"]").click();
	      page.locator("[data-test=\"username\"]").click();
	      page.locator("[data-test=\"username\"]").fill("standard_user");
	      page.locator("[data-test=\"password\"]").click();
	      page.locator("[data-test=\"password\"]").fill("secret_sauce");
	      page.locator("[data-test=\"login-button\"]").click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
	      page.locator("[data-test=\"logout-sidebar-link\"]").click();
	      //stop the trace viewer with zip file
	      context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
	      
	    }
	  }
	}

