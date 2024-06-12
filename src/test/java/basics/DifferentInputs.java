package basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DifferentInputs {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		try(Playwright playwright=Playwright.create()){
			//Playwright playwright=Playwright.create();
			//launch the browser in head mode
			Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
			//crrate a page
			Page page=browser.newPage();
			/*
			 * //navigate to the url page.navigate(
			 * "https://www.lambdatest.com/selenium-playground/simple-form-demo"); //using
			 * type() page.locator("input#user-message").type("Hi Playwright"); //click on
			 * button page.locator("id=showInput").click();
			 * 
			 * //fetch the text String msg = page.locator("#message").textContent();
			 * System.out.println("typed message:"+msg);
			 * 
			 * assertThat(page.locator("#message")).hasText("Hi Playwright");
			 */
			//fill()
			/*
			 * page.navigate(
			 * "https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo"
			 * );
			 * 
			 * page.locator("#textbox").
			 * fill("az group create --name rs-grp-vm-linux-azcli --location eastusaz vm create --resource-group rs-grp-vm-linux-azcli --name linuxvm-using-azcli --image Ubuntu2204 --admin-username azureuser --generate-ssh-keys"
			 * );
			 */
			//get the input field data
			page.navigate("https://letcode.in/edit");
			String inputVal=page.locator("#getMe").inputValue();
			System.out.println("input value is:"+inputVal);
			
			//get the palceholder value
			String placeHoldeVal=page.locator("#fullName").getAttribute("placeholder");
			System.out.println("fulleditbox placeholder value is:"+placeHoldeVal);
			
			//clear the content in editbox
			page.locator("#clearMe").clear();
			
			
			//checkbox
			page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
			
			Locator isAgeCheckbox=page.locator("#isAgeSelected");
			assertThat(isAgeCheckbox).not().isChecked();
			isAgeCheckbox.check();
			assertThat(isAgeCheckbox).isChecked();
			
		}
				
		
	}

}
