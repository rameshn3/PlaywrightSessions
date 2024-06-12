package basics;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;
public class PwTestWithRecord {

	public static void main(String[] args) {
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://demo.playwright.dev/todomvc/");
		      page.navigate("https://demo.playwright.dev/todomvc/#/");
		      page.getByPlaceholder("What needs to be done?").fill("learn playwright");
		      page.getByPlaceholder("What needs to be done?").press("Enter");
		      page.getByPlaceholder("What needs to be done?").fill("practice more examples with java");
		      page.getByPlaceholder("What needs to be done?").press("Enter");
		      page.getByPlaceholder("What needs to be done?").fill("work with javascript frist then typescript");
		      page.getByPlaceholder("What needs to be done?").press("Enter");
		    }

	}

}
