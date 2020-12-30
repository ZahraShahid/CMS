import java.io.*;
import java.util.*;

public class Student{
                String email;
                String name;
                String dob;
                int semester;
                String phone_no;
                int user_type;

                public Student(String em, String nm, String d, int s,String p_n,int u_t) {
                         email = em;
                         name = nm;
                         dob = d;
                         semester = s;
                         phone_no = p_n;
                         user_type = u_t;
                  }

                  public String getEmail( ) {
                             return  email;
                  }

                  public String getName( ) {
                             return  name;
                  }

                  public String getDob( ) {
                             return  dob;
                  }

                  public int getSemester( ) {
                             return  semester;
                  }

                  public String getPhone( ) {
                             return  phone_no;
                  }

                  public int getUser( ) {
                             return  user_type;
                  }
              
                  public String toString( ) {
                             return "Email: " + email + "<br>"+ " Name: " + name +"<br>"+ " D.O.B: " + dob +"<br>"+ " Semester: " + Integer.toString(semester) +"<br>"+ " Phone: " + phone_no;
                  }

  }