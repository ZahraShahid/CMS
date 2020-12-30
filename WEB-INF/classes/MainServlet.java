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

 
public class MainServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

         String em = request.getParameter("email");
         String t = request.getParameter("user_type");

        out.println("<html>");
        out.println("<head><title>Student Main Servlet</title></head>");
        out.println("<body bgcolor=\"white\">");

       try{
                 UsersDAO userDAO = new UsersDAO();

                 if(t.equals("1")){
                 Admin user_a = userDAO.adminMain(em);         
                 String a = user_a.toString();
                 out.println("<h1>" + "Information of the Admin : "+"</h1>");
                 out.println("<h3>"+ a +"</h3>");
                 out.println("<p>"+"<a href=\"http://localhost:8085/Login/CreateCourse.html\" style=\"color:dodgerblue;  font-size: 2.1em;\">Create Course</a>"+"</p>");
                 out.println("<p>"+"<a href=\"http://localhost:8085/Login/AssignCourse.html\" style=\"color:dodgerblue; font-size: 2.1em;\">Assign a Course to Teacher</a>"+"</p>");
                 out.println("<br>"+"<p>"+"<a href=\"http://localhost:8085/Login/SignIn.html\" style=\"color:red; font-size: 1.1em;\">Logout</a>"+"</p>");

                 }else if(t.equals("2")){
                 Teacher user_t = userDAO.teacherMain(em);         
                 String tc = user_t.toString();
                 out.println("<h1>" + "Information of the Teacher : "+"</h1>");
                 out.println("<h3>"+ tc +"</h3>");
                 String[] cn =userDAO.teacherCourses(em);
                  out.println("<h3>"+"List of Courses in by this Teacher"+"</h3>");
                 out.println("-------------------------------------------"+"<br>");
                 for (int i = 0; i < cn.length; i++) {
                             out.println( cn[i]+ "<br>");     
                 }  
                 out.println("<br>"+"<p>"+"<a href=\"http://localhost:8085/Login/SignIn.html\" style=\"color:red; font-size: 1.1em;\">Logout</a>"+"</p>");

                 }else if(t.equals("3")){
                 Student user_s = userDAO.studentMain(em);         
                 String s = user_s.toString();
                 int sem = user_s.getSemester();
                 out.println("<h1>" + "Information of the Student : "+"</h1>");
                 out.println("<h3>"+ s +"</h3>");
                 String[] cn =userDAO.studentCourses(sem);
                  out.println("<h3>"+"List of Courses in this Semester"+"</h3>");
                 out.println("-------------------------------------------"+"<br>");
                 for (int i = 0; i < cn.length; i++) {
                             out.println( cn[i]+ "<br>");     
                 }  
                 out.println("<br>"+"<p>"+"<a href=\"http://localhost:8085/Login/SignIn.html\" style=\"color:red; font-size: 1.1em;\">Logout</a>"+"</p>");
                 }

         }catch (SQLException e){
               out.println(e);    
         }
           out.println("</body></html>");

    /*public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{

    }*/

        
 }
}
