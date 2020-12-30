import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

public class TeachersignUpHandler extends HttpServlet {

public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{        
	
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String nm = request.getParameter("name");
    String p= request.getParameter("phone_no");
    String em = request.getParameter("email");
    String psw = request.getParameter("psw");
    String ut= request.getParameter("user_type");


    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet TeachersignUpHandler Servlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>Welcome! </p>");
    out.println("Your <i>Email</i> is: "+ em+ " and your <i>Password</i> is:" +psw); 
    out.println("</body>");
    out.println("</html>");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost/login";

    Connection con=DriverManager.getConnection(url, "root", "");

    Statement st=con.createStatement();
     
     String query="insert into profile(email,name,dob,semester,phone_no,user_type) values('"+em+"', '"+nm+"', 'NULL', 0, '"+p+"', '"+ut+"')"; 

     String query1="insert into authentication(email,password,user_type) values('"+em+"', '"+psw+"', '"+ut+"')"; 

     System.out.println(query);
     System.out.println(query1);

      int rs = st.executeUpdate( query );
      int rs1 = st.executeUpdate( query1 );

     if(rs==1 && rs1==1){	
             out.println("<h1>Insertion successful</h1>"); 		
      }
      else{	
             out.println("<h1>You could not Signup</h1>"); 		
      }
     out.println("</body></html>");
     st.close();
     con.close();

    }catch(Exception e){

         out.println(e);
     }	
   }

}