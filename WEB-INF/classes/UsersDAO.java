import java.io.*;
import java.util.*;
import java.sql.*; 
import java.sql.Connection.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.http.*;
import javax.servlet.*;

public class UsersDAO{
 
             Connection con = null;
             Statement st = null;
             ResultSet rs = null;

          public UsersDAO(){

                     try{
                          Class.forName("com.mysql.jdbc.Driver");
                          String url = "jdbc:mysql://localhost/login";
                          con=DriverManager.getConnection(url, "root", "");
                          st=con.createStatement();

                        }catch(Exception e){
                                    System.out.println(e);
                         }

             }
              

      //method studentMain
      public Student studentMain(String email) throws SQLException
      {
                
                            Student user_s = null;
             
                            String query="Select * from  profile  where email='"+email+"' ";
   
                            rs = st.executeQuery( query );
   
                           if(rs.next()){
  	                     String em = rs.getString("email");
    	                     String nm = rs.getString("name");
    	                     String d = rs.getString("dob");
    	                      int s = rs.getInt("semester");
    	                     String p = rs.getString("phone_no");
    	                      int t = rs.getInt("user_type");
                                     user_s = new Student(em,nm,d,s,p,t); 
                            }
                            //rs.beforeFirst();
                              
                           return user_s;
   }
   //method teacherMain
      public Teacher teacherMain(String email) throws SQLException
      {
                
                            Teacher user_t = null;
             
                            String query="Select * from  profile  where email='"+email+"' ";
   
                            rs = st.executeQuery( query );
   
                           if(rs.next()){
  	                     String em = rs.getString("email");
    	                     String nm = rs.getString("name");
    	                     String p = rs.getString("phone_no");
    	                      int t = rs.getInt("user_type");
                                     user_t = new Teacher (em,nm,p,t); 
                            }
                            //rs.beforeFirst();
                              
                           return user_t;
   }
//method adminMain
      public Admin adminMain(String email) throws SQLException
      {
                
                            Admin user_a = null;
             
                            String query="Select * from  profile  where email='"+email+"' ";
   
                            rs = st.executeQuery( query );
   
                           if(rs.next()){
  	                     String em = rs.getString("email");
    	                     String nm = rs.getString("name");
    	                     String p = rs.getString("phone_no");
    	                      int t = rs.getInt("user_type");
                                     user_a = new Admin(em,nm,p,t); 
                            }
                            //rs.beforeFirst();
                              
                           return user_a;
   }
//method studentCourses
      public String[] studentCourses(int semester) throws SQLException
      {
                          
                            String query="Select * from  course  where semester='"+semester+"' ";
                            rs = st.executeQuery( query );

                            String[] c = new String[3] ;
                            int j =0;

                           while(rs.next()){   	                     
    	                     c[j] = rs.getString("course_name");
  	                     int s = rs.getInt("semester");
                                      j++;
                            }
 
                           return c;
                                                                        
   }
//method teacherCourses
      public String[] teacherCourses(String email) throws SQLException
      {
                          
                            String query="Select * from  course_assignment  where email='"+email+"' ";
                            rs = st.executeQuery( query );

                            String[] c = new String[2] ;
                           int j =0;

                           while(rs.next()){   	                     
    	                     c[j] = rs.getString("course_id");
                                      j++;
                            }
 
                           return c;
                                                                        
   }
//method createCourse
      public String createCourse(int c_id, String c_n, int sem) throws SQLException
      {
             
                            String query="insert into course(course_id,course_name,semester) values('"+c_id+"', '"+c_n+"', '"+sem+"')";  
                            //rs = st.executeUpdate( query );
                            st.executeUpdate( query );

                            String s = "Course Created Successfully"; 		
                            return s;
   }
//method assignCourse
      public String assignCourse(int c_id, String email) throws SQLException
      {
             
                            String query="insert into course_assignment(course_id,email) values('"+c_id+"', '"+email+"')";  
                            //rs = st.executeUpdate( query );
                            st.executeUpdate( query );

                            String s= "Course Assigned Successfully"; 		       
                             return s;
   }
}