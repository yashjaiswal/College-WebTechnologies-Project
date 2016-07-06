import java.io.*;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
public class Searchaustralia extends HttpServlet {
   
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            
    {

       response.setContentType("text/html");
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL="jdbc:mysql://localhost:3306/study";
        String USER ="root";
        String PASS ="jaimatadi";
        Connection conn;
   java.io.PrintWriter out= response.getWriter(); 
        try
        {
   Class.forName(JDBC_DRIVER);
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
           Statement stmt = conn.createStatement();
           String sql;
           sql="select * from cricket where team like 'Australia';";
           ResultSet rs=stmt.executeQuery(sql);
           out.println("<table><tr><th>NAME</th><th>TEAM</th><th>RUNS</th><th>WICKETS</th></tr>");
           while(rs.next())
           {
        
               String name=rs.getString("name");
               String team=rs.getString("team");
               int runs=rs.getInt("runs");
               int wickets=rs.getInt("wickets");
               out.println("<tr><td>"+name+"</td><td>"+team+"</td><td>"+runs+"</td><td>"+wickets+"</td></tr>");
          
           }
          out.println("</table>");
           
         
           rs.close(); stmt.close(); conn.close();
        }
        catch(Exception e)
        {
        out.println(e);    
        }

        }
}

































