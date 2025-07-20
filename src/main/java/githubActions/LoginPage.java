package githubActions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginPage {

    public static void main(String[]args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.fill("[name='username']", "Admin");
        page.fill("[name='password']", "admin123");
        page.click("button[type='submit']");
        // page load duration
        long startTime = System.currentTimeMillis();  //start
        page.waitForLoadState();

            String dashboardUrl = page.url();
            if(dashboardUrl.equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
                System.out.println(" Logged in");
            }
            else{
                System.out.println("error occurred!");
            }
        long endTime = System.currentTimeMillis();    //️ End

        long loadTime = endTime - startTime;

        System.out.println("Page Load Time: " + loadTime + "ms");

        if (loadTime <= 2000) {
            System.out.println(" Page loaded in under 2 seconds.");
        } else {
            System.out.println(" Page took more than 2 seconds to load.");
        }

//            // calling dashboard class
//        Dashboard d = new Dashboard(page);
//            d.dashboard_verify();

        // calling PIM module
//        PIM pim = new PIM(page);
//        pim.addNewEmployee();
//        pim.firstName();
//        pim.middleName();
//        pim.deleteData();

        //calling Recruitment module
        Recruitment rc = new Recruitment(page);
        rc.addCandidate();
//        rc.shortlistCandidate();
            rc.RejectCandidate();
    }

}
