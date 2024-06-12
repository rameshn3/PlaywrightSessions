package handleTables;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleTableData {

	public static void main(String[] args) {
		try (Playwright pw = Playwright.create()) {

			Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			// create a page
			Page pg = browser.newPage();

			// navigate to the url
			pg.navigate("https://the-internet.herokuapp.com/tables");

			Locator rows = pg.locator("#table1 tr");

			rows.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));

			// Get the due amount from the second row
			String dueAmountrow2 = rows.nth(1).locator("td").nth(3).textContent();
			System.out.println("The due amount in the second row of the first table is: " + dueAmountrow2);

			// Wait for the 3rd row to be visible
			// Get the due amount from the second row
			String dueAmountrow3 = rows.nth(2).locator("td").nth(3).textContent();
			System.out.println("The due amount in the 3rd row of the first table is: " + dueAmountrow3);

		}

	}

}
