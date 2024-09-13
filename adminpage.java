import java.io.*;
import java.sql.*;
import java.util.*;

public class adminpage{
        Scanner s;
        String str;
    public adminpage()throws Exception
    {
            str="";
            s=new Scanner(System.in);
    }
    public void addplace()throws Exception
    {
        connection c=new connection();
        String place,p_desc;
        System.out.println("--------------------------------");
        System.out.print("Enter the place : ");
        place=s.nextLine();
        System.out.println("--------------------------------");
        System.out.print("Enter the description for the place : ");
        p_desc=s.nextLine();
        System.out.println("----------------------------------");
         str="insert into places(area,area_desc) values ('";
        str=str+place+"','"+p_desc+"')";
        c.st.executeUpdate(str);
        System.out.println("\n\t\tPLACE ADDED SUCCESFULLY!!");
    }
    public void addentity()throws Exception //entity means hotel,resturant,tourist place,transportation modes etc
    {
        connection c=new connection();
        String name;
        System.out.println("--------------------------------");
        System.out.print("Enter the entity name : ");
        name=s.nextLine();
         str="insert into entity(entity_name) values ('";
        str=str+name+"')";
        c.st.executeUpdate(str);
        System.out.println("\n\t\tENTITY ADDED SUCCESFULLY!!");
    }
    public void addspot()throws Exception
    {
        connection c=new connection();
        ResultSet rs;
        int p,e;
        String pname,padd,prating,ptime;
        System.out.println("-----------------------------------------------------------");
        System.out.println("ENTER THE DETAILS ABOUT THE SPOT");
        System.out.println("\t\tChoose the location of spot : ");
        str = "select * from Places";
        rs = c.st.executeQuery(str);
        while(rs.next()) {
           System.out.print("\n\t"+rs.getString("id")+". "+rs.getString("area"));
         }
        System.out.print("\n\t\tYour choice : ");
        p=s.nextInt();
        System.out.println("\n----------------------------------------------------------");
        System.out.print("\t\tChoose the type of spot : ");
        str = "select * from entity";
        rs = c.st.executeQuery(str);
        while(rs.next()) {
           System.out.print("\n\t"+rs.getString("id")+". "+rs.getString("entity_name"));
         }
        System.out.print("\n\t\tYour choice : ");
        e=s.nextInt();
        System.out.println("\n----------------------------------------------------------");
        System.out.print("\nSpot name : ");
        s.nextLine();
        pname=s.nextLine();
        System.out.print("\nAddress : ");
        padd=s.nextLine();
        System.out.print("\nRating : ");
        prating=s.nextLine();
        System.out.print("\nTiming : ");
        ptime=s.nextLine();
        str="insert into spot(placeid,entityid,name,address,rating,timing) VALUES (";
        str=str+p+","+e+",'"+pname+"','"+padd+"','"+prating+"','"+ptime+"')";
        c.st.executeUpdate(str);
        System.out.println("\n\t\tSPOT ADDED SUCCESFULLY!!");
    }
}
