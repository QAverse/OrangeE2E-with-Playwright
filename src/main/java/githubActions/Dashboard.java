package githubActions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.sql.Time;

public class Dashboard {
    Page page;
    public Dashboard(Page page){
        this.page = page;
    }
    public void dashboard_verify(){
       // checking if all the links are working in dashboard to navigate to different modules

        //admin module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a");
        System.out.println("admin module");
        // Pim module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a");
        System.out.println("pim module");
        //Leave module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(3) > a > span");
        System.out.println("leave module");
        //Time module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(4) > a > span");
        System.out.println("time module");
        // Recruitment module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(5) > a > span");
        System.out.println("recruitment module");
        // My info module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(6) > a");
        System.out.println("my info module");
        // Performance module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(8) > a");
        System.out.println("performance module");
        // dashboard module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(8) > a > span");
        System.out.println("dashboard module");
        // directory module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(9) > a > span");
        System.out.println("directory module");
        // claim module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(11) > a > span");
        System.out.println("claim module");
        // Buzz module
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(12) > a > span");
        System.out.println("Buzz module");

        System.out.println(" all the module links are working!");


    }
}
