package basics;

import java.nio.file.Paths;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Page page= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
	
		//navigate to the url
		page.navigate("https://letcode.in/file");
		
		//waiting for the file download
		Download download =	page.waitForDownload(()->{
				page.locator("#xls").click();
			});
	
		//fetch downloaded file temp location
		System.out.println(download.path());
		System.out.println(download.url());
		System.out.println(download.failure());
		System.out.println(download.suggestedFilename());
		//save the file to the project dir location
		download.saveAs(Paths.get(download.suggestedFilename()));
		
		//close the playwright
		playwright.close();
		
	}

}
