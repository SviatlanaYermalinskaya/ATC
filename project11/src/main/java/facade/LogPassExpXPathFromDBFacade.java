package facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class LogPassExpXPathFromDBFacade 
{
	private static final Logger logger = Logger.getLogger(LogPassExpXPathFromDBFacade.class);
	
    private static final String URL = "jdbc:mysql://localhost:3306/testautomation?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD_DB = ",tcrjytxyjcnm8";
	
	private String id;
    private String login;
    private String password;
    private String expectedXPath; 
    private boolean isLogPassExpXPathSet;
    
    public LogPassExpXPathFromDBFacade(String id)
    {
    	this.id = id;
    	isLogPassExpXPathSet = false;
    }

	public String getLogin() 
	{
		checkConnection("login");
		return login;
	}

	public String getPassword() 
	{
		checkConnection("password");
		return password;
	}

	public String getExpectedXPath() 
	{
		checkConnection("expectedXPath");
		return expectedXPath;
	}
	
	private void checkConnection(String field)
	{
		if (!isLogPassExpXPathSet)
		{
			logger.debug("Database connection...");
			isLogPassExpXPathSet = setLoginPasswordExpFromDB();
			if (isLogPassExpXPathSet)
			{
				logger.debug("Login, password and expectedXpath are successfully extracted from database");
			}
			else
			{
				logger.error("Error with DB connection: " + field + " is not extracted");
			}
		}
	}
    
    private boolean setLoginPasswordExpFromDB()
    {  
        String query = "SELECT * FROM testautomation.users WHERE id = " + id;
       //Class.forName("com.mysql.cj.jdbc.Driver");
       try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD_DB);
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
           return true;
       }
       catch (SQLException ex)
       {
    	   logger.error(getClass().getName() + " SQLException: " + ex.getMessage());
    	   return false;
       }
       catch (Exception ex)
       {
    	   logger.error(getClass().getName() + " Exception: " + ex.getMessage());
    	   return false;
    	   
       }
    } 

}
