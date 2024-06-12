package basics;
import com.microsoft.playwright.*;
public class PlaywrightTestDay1 {

	    public static void main(String[] args) {
	        try (Playwright playwright = Playwright.create()) {
	            Browser browser = playwright.webkit().launch();
	            Page page = browser.newPage();
	            page.navigate("http://playwright.dev");
	            System.out.println(page.title());
	        }
	    }
	}
