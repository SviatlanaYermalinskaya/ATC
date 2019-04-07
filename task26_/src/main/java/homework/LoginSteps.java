package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps
{
    private static final String MAIN_URL = "http://mail.ru";
    
    private LoginPage loginPage;
    private WebDriver webDriver;
    private String login;
    private String password;
    private String expectedXPath; 
    
    private String url = "jdbc:mysql://localhost:3306/testautomation?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String passwordDB = ",tcrjytxyjcnm8";

    public LoginSteps()
    {
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
    }

    @Given("^I am on main application page$")
    public void loadMainPage()
    {
        webDriver.get(MAIN_URL);
    }

    @When("^I login as user with \"([^\"]*)\"$")
    public void loginAsUserWithCredentials(String id)
    {
    	getLoginPasswordExpFromDB(id);
        loginPage.enterLoginAndPass(login, password);
        loginPage.clickEnterButton();
    }

    @Then("I see expected element")
    public void seeLogoutLink()
    {
        Assert.assertTrue(loginPage.isLogLinkPresents(expectedXPath));
    }

    public void getLoginPasswordExpFromDB(String id)
    {  
        String query = "SELECT * FROM testautomation.users WHERE id = " + id;
       //Class.forName("com.mysql.cj.jdbc.Driver");
       try (Connection con = DriverManager.getConnection(url, user, passwordDB);
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery(query))
       {
           if(rs.next()) // return result
           {
           	login = rs.getString(2);
           	password = rs.getString(3);
           	expectedXPath = rs.getString(4);
           }
           rs.close();
       }
       catch (SQLException ex)
       {
           ex.printStackTrace();

       }
    }
    
    @After
    public void afterClass()
    {
        webDriver.quit();
    }
}
