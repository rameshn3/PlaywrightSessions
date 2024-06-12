package basics;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;
public class HandlingDropdowns {

	public static void main(String[] args) {
		//create playwright, launch browser and new page
		Page page = Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		//launch the application
		page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		//get the daylocator
		Locator daydropdown = page.locator("select#select-demo");
		
		//select an option by label
		daydropdown.selectOption(new SelectOption().setValue("Saturday"));
		
		Locator selectedValue = page.locator(" p.selected-value.text-size-14");
		System.out.println(selectedValue.textContent());
		assertThat(selectedValue).containsText("Saturday");
		
		//select an option by value
		daydropdown.selectOption("Monday");
		System.out.println(selectedValue.textContent());
		assertThat(selectedValue).containsText("Monday");
		
				
		//select an option by index
		daydropdown.selectOption(new SelectOption().setIndex(3));
		System.out.println(selectedValue.textContent());
		assertThat(selectedValue).containsText("Tuesday");
		
		
		//Select multi selection dropdown
		Locator statesMsdropdown=page.locator("select[name='States']");
		statesMsdropdown.selectOption(new String[] {"California","New Jersey","Washington"});
		
		//fetching all the dropdown options
		Locator optionsList=statesMsdropdown.locator("option");
		System.out.println(optionsList.count());
		List<String>optionsinnerTexts=optionsList.allInnerTexts();
		
		optionsinnerTexts.forEach(option ->System.out.println(option));
		
		/*
		 * //Jquery dropdown handling page.navigate(
		 * "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo")
		 * ;
		 * 
		 * Locator country=page.
		 * locator("span[class='select2-selection select2-selection--single'][css='1']"
		 * ); country.click();
		 */
		
		
		 // Navigate to the URL
        page.navigate("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");

        // Click the dropdown to open it
        page.click("span.select2-selection.select2-selection--single");

        // Wait for the dropdown options to be visible
        page.waitForSelector("ul.select2-results__options");

     
        // Select the desired value by clicking on it
        page.click("li.select2-results__option:has-text('Australia')");
		
        //selecting another option
        // Click the dropdown to open it
        page.click("span.select2-selection.select2-selection--single");

        // Wait for the dropdown options to be visible
        page.waitForSelector("ul.select2-results__options");

        // Select the desired value by clicking on it
       page.click("li.select2-results__option:has-text('India')");
		
        
        
		//page.close();
	}

}
