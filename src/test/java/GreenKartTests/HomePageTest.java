package GreenKartTests;

import NetSuitePages.Constants;
import NetSuitePages.CustomersPage;
import NetSuitePages.LoginPage;
import Technics.Technic;
import org.junit.Assert;
import org.junit.Test;


public class HomePageTest extends BaseTest {

    @Test
    public void CustomersPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CustomersPage customers = new CustomersPage(driver);
        driver.get(Constants.CUSTOMERS_URL);
        loginPage.login();
        loginPage.chooseAnAccount();
        loginPage.verification();
        customers.customersPage(1);
        customers.serviceRequester(Technic.ARTUR_MADOYAN);
        Assert.assertTrue(driver.findElement(customers.assertTicketCreated)
                .getText().contains(Constants.TICKET_CREATED_MESSAGE));
    }
    @Test
    public void TestGeneration() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://demo.automationtesting.in/Register.html");
        Thread.sleep(2500);
        loginPage.codeGeneration();
    }
}
//driver.navigate().to(url);