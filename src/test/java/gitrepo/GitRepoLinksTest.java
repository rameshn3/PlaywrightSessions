package gitrepo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;;
public class GitRepoLinksTest {

	public static void main(String[] args) {
try(Playwright pw = Playwright.create()){
			
			Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			//create a page
			Page pg=browser.newPage();
			
			//navigate to the url
			pg.navigate("https://letcode.in/elements");
			//Type and Enter your Git username
			pg.getByPlaceholder("Enter your git user name eg., ortonikc").fill("rameshn3");
			
			//click on search button
			pg.locator("#search").click();
			//Assert that user has image
			//assertThat(pg.locator("img[alt='Placeholder image']").isVisible(),"User image is not visible"));
			
			//Print the user name & other informations
			System.out.println(pg.locator("p.title is-4").textContent());
			
			//fetch all the 
		}
	}

}
