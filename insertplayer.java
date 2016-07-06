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
public class insertplayer extends HttpServlet {
   
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
           
           
           String name=request.getParameter("name");
           String team=request.getParameter("team");
           int runs=Integer.parseInt(request.getParameter("runs"));
           int wickets=Integer.parseInt(request.getParameter("wickets"));
           PreparedStatement stmt=conn.prepareStatement("insert into cricket(Name,Team,Runs,Wickets) values (?,?,?,?);");
           stmt.setString(1,name);
           stmt.setString(2,team);
           stmt.setInt(3,runs);
           stmt.setInt(4,wickets);
           int a=stmt.executeUpdate();
         if(a==1)
             out.println("<p>Player successfully updated in database</p>");
         else
             out.println("Wrong information!");
            
     
        
         
         
        }
        catch(Exception e)
        {
       
        out.println("Wrong type of information attempted to be inserted!");
        }

        }
}

































