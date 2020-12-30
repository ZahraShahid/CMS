import java.io.*;
import java.util.*;

public class Admin{
                String email;
                String name;
                String phone_no;
                int user_type;

                public Admin(String em, String nm, String p_n,int u_t) {
                         email = em;
                         name = nm;
                         phone_no = p_n;
                         user_type = u_t;
                  }

                  public String getEmail( ) {
                             return  email;
                  }

                  public String getName( ) {
                             return  name;
                  }

                  public String getPhone( ) {
                             return  phone_no;
                  }
                  public int getUser( ) {
                             return  user_type;
                  }
              
                  public String toString( ) {
                             return "Email: " + email + "<br>"+ " Name: " + name +"<br>"+ " Phone: " + phone_no;
                  }

  }