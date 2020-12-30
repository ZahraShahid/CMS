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

 
public class CreateCourseServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

         String c = request.getParameter("c_id");
         String cn = request.getParameter("c_n");
         String sem = request.getParameter("sem");

        out.println("<html>");
        out.println("<head><title>Create Course Servlet</title></head>");
        out.println("<body bgcolor=\"white\">");


       int cc = Integer.parseInt(c);
       int csem = Integer.parseInt(sem);
       try{
                 UsersDAO userDAO = new UsersDAO();   
                 String a = userDAO.createCourse(cc,cn,csem); 
                 out.println("<h3>"+ a +"</h3>");
                
         }catch (SQLException e){
               out.println(e);    
         }
           out.println("</body></html>");

    /*public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{

    }*/

        
 }
}
