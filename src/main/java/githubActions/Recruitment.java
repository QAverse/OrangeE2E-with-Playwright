package githubActions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class Recruitment {
    Page page;
    public Recruitment(Page page){
        this.page=page;
    }

    void addCandidate(){
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > button");
        //name
        page.fill("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div > div > div.--name-grouped-field > div:nth-child(1) > div:nth-child(2) > input","ron");
        //middle name
        page.fill("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div > div > div.--name-grouped-field > div:nth-child(2) > div:nth-child(2) > input","thomas");
        //last name
        page.fill("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div > div > div.--name-grouped-field > div:nth-child(3) > div:nth-child(2) > input","elva");
        //selecting option from the rendered dropdown

        page.locator("div.oxd-select-text").click();

        // Optional: Pause for debugging
        // page.pause();

        // Step 2: Wait and click the option by visible text
        page.locator("div[role='option'] >> text=Senior QA Lead").click();

        // Optional validation
        String selected = page.locator("div.oxd-select-text-input").innerText();
        System.out.println("Selected: " + selected);

        //email
        page.fill("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(3) > div > div:nth-child(1) > div > div:nth-child(2) > input","ronthomas@gmail.com");
        //contact number
        page.fill("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(3) > div > div:nth-child(2) > div > div:nth-child(2) > input","1234567890");

        // to test the upload file functionality
        // Locate the <input type="file"> element
        Locator fileInput = page.locator("input[type='file']");

        // Upload the file (ensure this file exists in your project directory)
        fileInput.setInputFiles(Paths.get("C:\\Users\\Mughda Bansal\\OneDrive\\Desktop\\Software Testing Notes.docx"));

        // Optional: Validate "No file selected" becomes filename
        String fileText = page.locator("div.oxd-file-input-div").innerText();
        System.out.println("File upload text: " + fileText);

        //keywords
        page.fill("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(5) > div > div.oxd-grid-item.oxd-grid-item--gutters.orangehrm-save-candidate-page-full-width > div > div:nth-child(2) > input","abc,def,ghi");

        // adding date
        // Set the date value directly using the placeholder selector
        Locator dateInput = page.locator("input[placeholder='yyyy-dd-mm']");
        dateInput.fill("2025-20-07");

        // Optional: Verify the value was set
        String value = dateInput.inputValue();
        System.out.println("Date entered: " + value);

        //notes
        page.fill("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(6) > div > div > div > div:nth-child(2) > textarea","notes are here!");
page.waitForLoadState();

//        // Locate checkbox input                 ---------------> bug
//        boolean isChecked = page.locator("input[type='checkbox']").isChecked();
//        System.out.println("Is checkbox checked? " + isChecked);


        //click on submit button
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
        System.out.println("candidate is added!");

    }

    void shortlistCandidate(){
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div.orangehrm-card-container > form > div.orangehrm-recruitment > div.orangehrm-recruitment-actions > button.oxd-button.oxd-button--medium.oxd-button--success");
        page.waitForLoadState();
        // save button
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
     System.out.println("candidate is shortlisted"); //-----------> //bug while shortlisting candidate
    }
    void RejectCandidate(){
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div.orangehrm-card-container > form > div.orangehrm-recruitment > div.orangehrm-recruitment-actions > button.oxd-button.oxd-button--medium.oxd-button--danger");
        page.waitForLoadState();
        page.click("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
        System.out.println("candidate is rejected! "); //---------------> //bug while rejecting candidate
    }
}


