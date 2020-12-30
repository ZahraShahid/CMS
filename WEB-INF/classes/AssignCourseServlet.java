import java.io.*;
import java.util.*;
import java.lang.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import javax.swing.*;
import java.net.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

 
public class AssignCourseServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

         String c = request.getParameter("c_id");
         String em = request.getParameter("email");

        out.println("<html>");
        out.println("<head><title>Assign Course Servlet</title></head>");
        out.println("<body bgcolor=\"white\">");

       int cc = Integer.parseInt(c);

       try{
                 UsersDAO userDAO = new UsersDAO();   
                 String a = userDAO.assignCourse(cc,em); 
                 out.println("<h3>"+ a +"</h3>");
                
         }catch (SQLException e){
               out.println(e);    
         }
           out.println("</body></html>");

    /*public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{

    }*/

        
 }
}
