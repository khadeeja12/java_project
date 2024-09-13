//Smart City Guide
/* Admin can add all the details to the system like places and its entities like hotel, tousrist attraction and can also add details about specific spots
Customers can login and can check for details in specific areas such as transportation, hotels, resturants, tourists spots etc 
Customers can edit their information as well*/
import java.io.*;
import java.util.*;
import java.sql.*;
class mainpage
{
    public static void main(String args[])
    {
        int ch=0,c=0;
        Connection conn;
        Statement st;
        ResultSet rs;
        String name,pass,str;
        Scanner s=new Scanner(System.in);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity_db?characterEncoding=UTF-8", "root", "");
            st=conn.createStatement();
            do
            {
                System.out.println("\n\t     SMART CITY GUIDE");
                System.out.println("\t**************************");
                System.out.println("\n\t ------------------------");
                System.out.println("\t|   1.Login               |\n\t|   2.Register/Sign Up    |\n\t|   3.Exit                |");
                System.out.println("\t ------------------------");
                System.out.print("Enter your choice : ");
                ch=s.nextInt();
                switch(ch)
                {
                   case 1 :  System.out.println("\n\t\t  LOGIN");
                            System.out.println("______________________________________");
                             System.out.print("|  Enter Username : ");
                             s.nextLine();
                             name=s.nextLine();
                             System.out.println("\n|                                      |");
                            //  s.nextLine();
                            //  name=s.nextLine();
                             System.out.print("|  Enter password : ");
                             pass=s.nextLine();
                             System.out.println("\n|                                      |");
                              
                              System.out.println("______________________________________");
                             str="Select * from login where username= '";
                             str=str+name+"' and password ='"+pass+"'";
                             // System.out.println(str);
                             rs=st.executeQuery(str);
                             if(rs.next())
                             {
                                String id=rs.getString("id");
                                switch (rs.getString("usertype")) 
                                {
                                    case "admin" :  do
                                                    {
                                                      System.out.println("\n\t*********************");
                                                      System.out.println("\n\t   WELCOME ADMIN");
                                                      System.out.println("\t*********************");
                                                    
                                                        System.out.println("\n\t1. Add Area/Place\n\t2. Add Entity\n\t3. Add Spots\n\t4. Log Out");
                                                        System.out.print("\nEnter your choice : ");
                                                        c=s.nextInt();
                                                        adminpage ad =new adminpage();
                                                        switch(c)
                                                        {
                                                            case 1 : ad.addplace();break;
                                                            case 2 : ad.addentity();break;
                                                            case 3 : ad.addspot();break;
                                                            case 4 : break;
                                                            default : System.out.println("Invalid choice");
                                                        }
                                                    }while(c!=4);
                                                  
                                        
                                        break;
                                    
                                    case "customer" : custpage cobj=new custpage();
                                                     do
                                                      {
                                                         System.out.println("\n\t*********************");
                                                         System.out.println("\n\t   WELCOME "+rs.getString("username").toUpperCase());
                                                         System.out.println("\t*********************");
                                                         System.out.println("\n\n\t\t _______________________________________");
                                                         System.out.println("\t\t| \t\t\t\t\t|");
                                                         System.out.println("\t\t|  1.SMART CITY GUIDE\t\t\t|\n\t\t|  2.EDIT PROFILE\t\t\t|\n\t\t|  3.LOGOUT\t\t\t\t|");
                                                         System.out.println("\t\t _______________________________________");
                                                         System.out.print("\nEnter your choice : ");
                                                         c=s.nextInt();
                                                         switch(c)
                                                         {
                                                            case 1 : cobj.menu(); break;
                                                            case 2 : cobj.edit(id);break;
                                                            case 3 : break;
                                                            default : System.out.println("Invalid choice..try again");
                                                         }

                                                      }while(c!=3);
                                        break;
                                
                                    default: System.out.println("Error");
                                        break;
                                }
                             }
                             else
                                System.out.println("\n\tInvalid username or password..Please Login Again");break;

                     case 2 :  System.out.println("\n\t______________________________________");
                               System.out.println("\t         REGISTER/SIGN UP ");
                               System.out.println("\t______________________________________");
                               System.out.println("Enter a username : ");
                               s.nextLine();
                               name=s.nextLine();
                               System.out.println("Enter a password : ");
                               pass=s.nextLine();
                               System.out.println("Confirm password : ");
                               String cpass=s.nextLine();
                               if(pass.equals(cpass))
                               {
                                  str="insert into login(username,password,usertype) values('";
                                  str=str+name+"','"+pass+"','customer')";
                                  st.executeUpdate(str);
                                  System.out.println("\t"+name+" REGISTERED SUCESSFULLY...Please Login now");
                               }
                               else
                               System.out.println("Password Mismatch!! TRY AGAIN");
                               break;
                     case 3 : System.exit(0);
                }
            }while(ch!=3);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}