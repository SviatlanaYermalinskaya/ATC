package core;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/testautomation?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = ",tcrjytxyjcnm8";

         String query = "SELECT * FROM testautomation.users";
        //Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query))
        {
            while(rs.next()) // return result
            {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +
                		rs.getString(3) + " " + rs.getString(4));
            }
            rs.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();

        }
    }
}