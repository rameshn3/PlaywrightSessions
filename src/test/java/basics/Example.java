package basics;

import com.microsoft.playwright.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://demo.playwright.dev/todomvc/");
      page.navigate("https://demo.playwright.dev/todomvc/#/");
      page.getByPlaceholder("What needs to be done?").click();
      page.getByPlaceholder("What needs to be done?").fill("learnplaywright");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByLabel("Toggle Todo").check();
      page.getByLabel("Delete").click();
    }
  }
}