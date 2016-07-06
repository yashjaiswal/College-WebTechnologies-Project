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
public class customsearch extends HttpServlet {
   
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
           String[] teams=request.getParameterValues("team");
           String selectruns=request.getParameter("runs");
           String selectwickets=request.getParameter("wickets");
           
         out.println("<table><tr><th>NAME</th><th>TEAM</th><th>RUNS</th><th>WICKETS</th></tr>");  
    int length=teams.length;       
        
           
              
if(selectruns.equals("Nill") && selectwickets.equals("Nill"))
{
    for(int i=0;i<length;i++)
    {
        String sql;    
    sql="select * from cricket where team like '"+teams[i]+"';";
           
        
           ResultSet rs;
            rs = stmt.executeQuery(sql);
        
          
        
    
        while(rs.next())
           {
               
               String name=rs.getString("name");
               String team=rs.getString("team");
               int runs=rs.getInt("runs");
               int wickets=rs.getInt("wickets");
               out.println("<tr><td>"+name+"</td><td>"+team+"</td><td>"+runs+"</td><td>"+wickets+"</td></tr>");
     
           }
    }
          out.println("</table>");
        
}
else if(selectruns.equals("Nill") && selectwickets.equals("Nill")==false)
        {
            for(int i=0;i<length;i++)
    {
        String sql;    
    sql="select * from cricket where team like '"+teams[i]+"' and wickets"+selectwickets+";";
           ResultSet rs=stmt.executeQuery(sql);
           int count=0;
        
    
        while(rs.next())
           {
               
               String name=rs.getString("name");
               String team=rs.getString("team");
               int runs=rs.getInt("runs");
               int wickets=rs.getInt("wickets");
               out.println("<tr><td>"+name+"</td><td>"+team+"</td><td>"+runs+"</td><td>"+wickets+"</td></tr>");
     
           }
        }

        }
else if(selectruns.equals("Nill")==false && selectwickets.equals("Nill"))
{
    for(int i=0;i<length;i++)
    {
        String sql;    
    sql="select * from cricket where team like '"+teams[i]+"' and runs"+selectruns+";";
           ResultSet rs=stmt.executeQuery(sql);
           
        
    
        while(rs.next())
           {
               
               String name=rs.getString("name");
               String team=rs.getString("team");
               int runs=rs.getInt("runs");
               int wickets=rs.getInt("wickets");
               out.println("<tr><td>"+name+"</td><td>"+team+"</td><td>"+runs+"</td><td>"+wickets+"</td></tr>");
     
           }
        }

}
else if(selectruns.equals("Nill")==false && selectwickets.equals("Nill")==false)
{
    for(int i=0;i<length;i++)
    {
        String sql;    
    sql="select * from cricket where team like '"+teams[i]+"' and runs"+selectruns+" and wickets"+selectwickets+";";
           ResultSet rs=stmt.executeQuery(sql);
           
        
    
        while(rs.next())
           {
               
               String name=rs.getString("name");
               String team=rs.getString("team");
               int runs=rs.getInt("runs");
               int wickets=rs.getInt("wickets");
               out.println("<tr><td>"+name+"</td><td>"+team+"</td><td>"+runs+"</td><td>"+wickets+"</td></tr>");
     
           }
        }

}
        }
    
           
        
        catch(Exception e)
        {
        out.println(e);    
        }

        }
    }



































