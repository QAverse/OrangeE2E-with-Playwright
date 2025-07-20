package githubActions;

import com.microsoft.playwright.Page;

public class PIM {
    Page page;
    public PIM(Page page){
        this.page=page;
    }
    void addNewEmployee(){
          page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        // validating the url
        String currentUrl = page.url();
        if(currentUrl.equals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList")){
            System.out.println("PIM page!");
        }
        else{
            System.out.println("error occurred");
        }

        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > button");
        page.waitForLoadState();
        String addEmployeeUrl = page.url();
        if(addEmployeeUrl.equals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee")){
            System.out.println(" add employee form is opened ");
        }
        else {
            System.out.println("the form is not opened!");
        }
    }
    //verifying that first name is a required field
    void firstName(){
        page.waitForLoadState();
//        page.fill("[name = 'firstName']","rihana");
        page.fill("[name='middleName']", "thomas");
        page.fill("[name='lastName']", "ella");
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
        page.waitForLoadState();
        if(page.url().equals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/168")){
            System.out.println("form is successfully submitted");
        }
        else{
            System.out.println("form is not submitted! first name is a required field.");
        }
    }
    //verify that middle name is not a required field
    void middleName(){
        page.waitForLoadState();
        page.fill("[name = 'firstName']","rihana");
        page.fill("[name='lastName']", "ella");
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
        page.waitForLoadState();
        page.waitForURL("**/viewPersonalDetails/**");
        System.out.println("personal details form is opened successfully!");
    }

    //deleting  employee data from the list
    void deleteData(){
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        if(page.url().equals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList")){
            System.out.println("employee list page is opened");
        }
        else{
            System.out.println(" error occurred");
        }
        //clicking on delete button
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div > div:nth-child(6) > div > div > div.card-header-slot > div.card-item.card-header-slot-content.--right > div > div > button:nth-child(2)");
        page.waitForLoadState();
        //giving the confirmation of deleting by clicking on yes
        page.click("#app > div.oxd-overlay.oxd-overlay--flex.oxd-overlay--flex-centered > div > div > div > div.orangehrm-modal-footer > button.oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin");
    }



}
