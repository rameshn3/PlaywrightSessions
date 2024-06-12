package basics;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class UploadFiles {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Page page= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
	
		//navigate to the url
		//page.navigate("https://sendgb.com");
		
		//click on close icon
		//page.locator("#cookiescript_close").click();
		
	//	page.locator("Add File(s)").setInputFiles(Paths.get("sample.xlsx"));
		page.navigate("https://the-internet.herokuapp.com/upload");
		//write an event listener
	FileChooser fileChooser=	page.waitForFileChooser(()->{
			page.locator("id=drag-drop-upload").click();
		});
	fileChooser.setFiles(Paths.get("sample.xlsx"));
		System.out.println(fileChooser.isMultiple());
		/*
		 * if(fileChooser.isMultiple()) { fileChooser.setFiles(new Path[] {
		 * Paths.get("sample.xlsx") }); }
		 */

	}

}
