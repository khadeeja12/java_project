import java.sql.ResultSet;
import java.util.Scanner;

public class custpage {
    Scanner s;
    String place,str;
    connection c;
    ResultSet rs;
    custpage()throws Exception
    {
       s=new Scanner(System.in);
       c=new connection();
    }
    public void menu()throws Exception
    {
        String id;
        int ch;
        System.out.print("Enter the place you want to search : ");
        place=s.nextLine();
        str="Select * from places where area='";
        str=str+place+"'";
        rs = c.st.executeQuery(str);
        if(rs.next())
        {
             id=rs.getString("id");
            //  System.out.println(id);
             str="select * from entity";
             rs = c.st.executeQuery(str);
             while(rs.next())
             {
                System.out.println(rs.getString("id")+". "+rs.getString("entity_name"));
             }
             System.out.print("\n\tEnter the entity you want : ");
             ch=s.nextInt();
             str="Select * from spot where placeid=";
             str=str+id+" and entityid ="+ch;
            //  System.out.println(str);
             rs = c.st.executeQuery(str);
             if(rs.next())
             {
             do
             {
                System.out.println("\n\t\t######################################");
                System.out.println("\t\t"+rs.getString("name"));
                System.out.println("\t\tAddress : "+rs.getString("address"));
                System.out.println("\t\tRating : "+rs.getString("rating"));
                System.out.println("\t\tTiming : "+rs.getString("timing"));
                // System.out.println("*********************************");
             }while(rs.next());
             System.out.println("\n\t\t######################################");
            }
            else
            {
                System.out.println("\n\n\tNo information available...");
            }



        }
        else
        {
            System.out.println("\nLocation not found in the system...!!");
        }
    }
    public void edit(String id)throws Exception
    {
           String uname,pas="",name="";
           System.out.println("\t\t1. Edit username\n\t\t2. Edit password");
           System.out.print("Your choice : ");
           int ch=s.nextInt();
           str="Select * from login where usertype='customer' and id=";
           str=str+id;
           rs = c.st.executeQuery(str);
           if(rs.next())
           {
            name=rs.getString("username");
            pas=rs.getString("password");
           }
           switch(ch)
           {
            case 1 : System.out.print("\n\n\tEnter current username : ");
                     s.nextLine();
                     uname=s.nextLine();
                     if(uname.equalsIgnoreCase(name))
                     {
                        System.out.print("\n\tEnter new username : ");
                        uname=s.nextLine();
                        str="update login set username='";
                        str=str+uname+"' where id ="+id;
                        c.st.executeUpdate(str);
                        System.out.println("\n\t\tUSERNAME UPDATED SUCCESSFULLY");
                     }
                     else
                        System.out.println("\nYou have entereed wrong username");
                    break;
            case 2 : System.out.print("\n\n\tEnter current password : ");
                     s.nextLine();
                     uname=s.nextLine();
                     if(uname.equalsIgnoreCase(pas))
                     {
                        System.out.print("\n\tEnter new password : ");
                        uname=s.nextLine();
                        System.out.print("\n\t\tConfirm password :  ");
                        name=s.nextLine();
                        if(uname.equals(name))
                        {
                            str="update login set password='";
                            str=str+uname+"' where id ="+id;
                            c.st.executeUpdate(str);
                            System.out.println("\n\t\tPASSWORD UPDATED SUCCESSFULLY");
                        }
                        else
                        {
                            System.out.println("\n\n\tPassword Mismatch..try again");
                        }
                        
                     }
                     else
                        System.out.println("\nYou have entereed wrong password");
                    break;
                     


           }
    }
}
