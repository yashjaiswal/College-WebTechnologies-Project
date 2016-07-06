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
public class ranking extends HttpServlet {
   
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
           
           
           String rankingtype=request.getParameter("ranking");
        if(rankingtype.equals("batting"))
        {
            Statement stmt=conn.createStatement();
            String sql="select * from cricket order by runs desc limit 10;";
            ResultSet rs=stmt.executeQuery(sql);
            int i=1;
            out.println("<table align='center' border=1><tr><th>RANKING</th><th>NAME</th><th>TEAM</th><th>RUNS</th><th>WICKETS</th></tr>");
            while(rs.next())
           {
           
               String name=rs.getString("name");
               String team=rs.getString("team");
               int runs=rs.getInt("runs");
               int wickets=rs.getInt("wickets");
               out.println("<tr><td>"+i+"</td><td>"+name+"</td><td>"+team+"</td><td>"+runs+"</td><td>"+wickets+"</td></tr>");
          i++;
           }
        }
        else
        {
            Statement stmt=conn.createStatement();
            String sql="select * from cricket order by wickets desc limit 10;";
            ResultSet rs=stmt.executeQuery(sql);
            int i=1;
            out.println("<table align='center' border=1><tr><th>RANKING</th><th>NAME</th><th>TEAM</th><th>RUNS</th><th>WICKETS</th></tr>");
            while(rs.next())
           {
           
               String name=rs.getString("name");
               String team=rs.getString("team");
               int runs=rs.getInt("runs");
               int wickets=rs.getInt("wickets");
               out.println("<tr><td>"+i+"</td><td>"+name+"</td><td>"+team+"</td><td>"+runs+"</td><td>"+wickets+"</td></tr>");
          i++;
           }
        }
            
          
        
           
              
         
         
        
        
        
        
        }
        catch(Exception e)
        {
        out.println(e);    
        }

        }
}

































