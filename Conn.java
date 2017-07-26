package jdbc;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.Scanner;
public class Conn
{ 

	public static void main(String[] args) throws Exception
	{
		String sourceURL = "jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu"; 
		try 
		{ Class.forName("oracle.jdbc.OracleDriver"); 
		} 
		catch(Exception x)
		{ 
		System.out.println( "Unable to load the driver class!" ); 
		} 
		try
		{ 
		 Connection conn = DriverManager.getConnection (sourceURL,"userID", "password"); 
		 Statement stmt = conn.createStatement();
		 ResultSet rset;
		 String q;
		 int input=1 ;
		 Scanner in = new Scanner(System.in);
		 
		 while(input!=20)
		 {	 
			 System.out.println("1)Insert data into employees\n");
			 System.out.println("2)Enter a new product associated with the person who made the product, "
			 		+ " repaired the product if it is repaired, or checked the product\n");
			 System.out.println("3)Enter a customer associated with some products\n");
			 System.out.println("4)Create a new account associated with a product\n");
			 System.out.println("5)Enter a complaint associated with a customer and product\n");
			 System.out.println("6)Enter an accident associated with appropriate employee and product\n");
			 System.out.println("7)Retrieve the date produced and time spent to produce a particular product\n");
			 System.out.println("8)Retrieve all products made by a particular worker\n");
			 System.out.println("9)Retrieve the total number of errors a particular quality controller made. "
			 		+ "This is the total number of products certified by this controller and got some complaints\n");
			 System.out.println("10)Retrieve the total costs of the products in the product3 category "
			 		+ "which were repaired at the request of a particular quality controller\n");
			 System.out.println("11)Retrieve all customers who purchased all products of a particular color\n");
			 System.out.println("12)Retrieve the total number of work days lost due to accidents "
			 		+ "in repairing the products which got complaints\n");
			 System.out.println("13)Retrieve all customers who are also workers\n");
			 System.out.println("14)Retrieve all the customers who have purchased the products "
			 		+ "made or certified or repaired by themselves\n");
			 System.out.println("15)Retrieve the average cost of all products made in a particular year\n");
			 System.out.println("16)Switch the position between a technical staff and a quality controller\n");
			 System.out.println("17)Delete all accidents whose dates are in some range\n");
			 System.out.println("18)Enter new customers from a data file until the file is empty\n");
			 System.out.println("19)Retrieve all customers (in name order) and output them to a data file instead of screen\n");
			 System.out.println("20)Exit\n");
			 System.out.println("\nEnter your choice:\n");
			 input =in.nextInt();
			 
		 switch(input)
		 {	 
		 case 1: 
			 System.out.println("\na)Insert data into Technical Staff \n b)Insert data into Quality Controller \n c)Insert data into Worker");
		 System.out.println("Enter your choice: ");
		 BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		 char ch= (char) bs.read();
		 if (ch=='a')
		 {  
		  System.out.println("\nEnter the Technical Employee Name: \n");
		  String name=(new BufferedReader(new InputStreamReader(System.in))).readLine();	
		  
		  System.out.println("\nEnter the Employee Address: \n");
		  String address=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		  
		  System.out.println("\nEnter the Technical Position: \n");
		  String posn=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		  
		  System.out.println("\n Enter the person's degree: \n");
		  String degree=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		  
		  stmt.executeUpdate("insert into tech_staff values('"+name+"','"+address+"','"+posn+"')");
		  stmt.executeUpdate("insert into degrees values('"+degree+"','"+name+"')");
		  stmt.executeQuery("commit");
		  }
		 else if (ch=='b')
		 {
		  System.out.println("\nEnter the Quality Employee Name: ");
		  String name;
		  name=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		  System.out.println("\nEnter the Employee Address: ");
		  String address;
		  address=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		  System.out.println("\nEnter the type of product checked: ");
		  String pro;
		  pro=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		  stmt.executeUpdate("insert into quality_control values('"+name+"','"+address+"','"+pro+"')");
		  stmt.executeQuery("commit");
		  }
		 else if (ch=='c')
		 {
		  System.out.println("\nEnter the Worker Employee Name: ");
		  String name;
		  name=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		  System.out.println("\nEnter the Employee Address: ");
		  String address;
		  address=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		  System.out.println("\nEnter the number of products: ");
		  int num;
		  num=in.nextInt();
		  stmt.executeUpdate("insert into worker values('"+name+"','"+address+"','"+num+"')");
		  }
		 else 
			 break;
		 
		 break;
		 
		 case 2:
			 System.out.println ("\n Enter the Product Id \n");
			 String id;
			  id=in.next();
			 System.out.println ("\n Enter the Date of Production(dd-mon-yyyy) \n");
			 String date;
			   date=in.next();
			 System.out.println ("\n Enter the Time spent \n");
			 float timet;
			  timet=in.nextFloat();
			 System.out.println("\n Enter the Technical Employee \n");
			 String name;
			 name=in.next();
			 System.out.println (" \n Enter the Quality controller \n");
			 String name1;
			  name1=in.next();
			 System.out.println (" \n Enter the Worker \n");
			 String name2;
			  name2=in.next();	
			 stmt.executeUpdate("insert into products values('"+id+"','"+date+"','"+timet+"','"+name2+"','"+name1+"','"+name+"')");	  
			 stmt.executeUpdate("insert into checks values('"+name1+"','"+id+"')");
			 stmt.executeUpdate("insert into produces values('"+name2+"','"+id+"')");
			 System.out.println("Has the product been repaired? 1. Yes 2. No");
             int opt=in.nextInt();
             if(opt==1)
             {
                     System.out.println("enter date of repair:");
                     String d=in.next();
                     stmt.executeUpdate("insert into repairs values('"+name2+"','"+id+"','"+d+"')");
                 }
			  System.out.println("\n enter what kind of product: \n 1)prod1 \n 2)prod2 \n 3) prod3");
			   int no =in.nextInt();
			 
			  if(no==1)
			  {
				  System.out.println (" \n Enter the size of the product \n");
					 String s;
					  s=in.next();
					 System.out.println ("\n Enter the software name \n");
					 String sn;
					  sn=in.next();
					  stmt.executeUpdate("insert into product1 values('"+id+"','"+s+"','"+sn+"')");
			  }	  
			  else if(no==2)
			  {
				  System.out.println (" \n Enter the size of the Product \n");
					 String s;
					  s=in.next();
					 System.out.println ("\n Enter the product color \n");
					 String color;
					  color=in.next();
					  stmt.executeUpdate("insert into product2 values('"+id+"','"+s+"','"+color+"')");
			  }
			  else if(no==3)
			  {
				  System.out.println (" \n Enter the Product 3 size \n");
					 String s1;
					  s1=in.next();
					 System.out.println ("\n Enter the product weight \n");
					 float w;
					  w=in.nextFloat();
					  stmt.executeUpdate("insert into product3 values('"+id+"','"+s1+"','"+w+"')");
			  }
			  break;
			  
		 case 3:
			  System.out.println("\nEnter the Customer Name: ");
			  String cname;
			  cname=in.next();
			  System.out.println("\nEnter the customer Address: ");
			  String address;
			  address=in.next();
			  System.out.println ("\n Enter the Product Id \n");
				 String pid;
				  pid=in.next();
			 stmt.executeUpdate("insert into customer values('"+cname+"','"+address+"')");	  
			 stmt.executeUpdate("insert into purchase values('"+pid+"','"+cname+"')");
			 break;
			 
		 case 4:
			 System.out.println ("\n Enter the Account no \n");
			  int acid=in.nextInt();
			 System.out.println ("\n Enter the creation date \n");
			  String pdate=in.next();
			  System.out.println("\nEnter the product id");
			  String prod=in.next();
			  System.out.println("\nEnter the product cost ");
			  float cos=in.nextFloat();
			  String p1 = "insert into accounts values('"+acid+"','"+pdate+"','"+cos+"')";
			  stmt.executeUpdate(p1);
			  System.out.println("\nEnter account type 1.Prod1Account 2.Prod2Account 3.Prod3Account");
			  int acct;
			  acct=in.nextInt();
              stmt.executeUpdate("insert into account"+acct+" values('"+acid+"','"+pdate+"','"+cos+"')");
              stmt.executeUpdate("insert into prodacc"+acct+" values('"+prod+"','"+pdate+"','"+cos+"')");
              break;
			  
		 case 5:
			 System.out.println(" \n Enter the complaint Number \n");
			 String cid;
			 cid=in.next();
			 System.out.println("\n Enter the Customer name\n");
			 String cuname;			 
			 cuname=in.next();
			 System.out.println("\n Enter the Employee name who repairs\n");
			 String ename;
			 ename=in.next();
			 System.out.println("\n Enter the Product Id\n");
			 String prid;
			 prid=in.next();
			 System.out.println("\n Enter the Complaint Date\n");
			 String cdate;
			 cdate=in.next();
			 System.out.println ("\n Enter the Complaint Description \n");
			 String des;
			 des=in.next();
			 System.out.println("\n Enter the Treatment expected \n");
			 String tre;
			 tre=in.next();
			 stmt.executeUpdate("insert into complaint values('"+cid+"','"+cdate+"','"+des+"','"+tre+"')");
			 stmt.executeUpdate("insert into make_complaint values('"+prid+"','"+cuname+"','"+cid+"','"+ename+"')");
			 break;
			 
		 case 6:
			  System.out.println ("\n Enter the Accident no \n");
			  String acno;
			  acno=in.next();
			  System.out.println ("\n Enter the accident date \n");
			  String adate;
			  adate=in.next();
			  System.out.println("\nEnter the work days lost ");
			  int los=in.nextInt();
			  System.out.println("\n Enter the Product Id\n");
			  String proid;
				 proid=in.next();
			  stmt.executeUpdate("insert into accident values('"+acno+"','"+los+"','"+adate+"')");
			  System.out.println ("\n Enter whether the employee involved in accident is : \n1)Technical \n2)Worker: \n");
			  int ea;
			  ea=in.nextInt();
			  if(ea==1)
			  {
				  System.out.println ("\n Enter the name of Technical person who was hurt: \n");
				  String tname;
				  tname=in.next();
				  stmt.executeUpdate("insert into maycause values('"+tname+"','"+acno+"','"+proid+"')");
			  }
			  else if(ea==2)
			  {
				  System.out.println ("\n Enter the name of Worker who was hurt: \n");
				  String wname;
				  wname=in.next();
				  stmt.executeUpdate("insert into maybe values('"+wname+"','"+acno+"','"+proid+"')");
			  }
			  else 
				  break;
			  
			  break;
			  
		 case 7:
			 System.out.println("\n Enter the Product Id\n");
			 String pr_id=in.next();
			 q="select p_date, time_taken as from products where prod_id='"+pr_id+"'";
			 rset=stmt.executeQuery(q);
			 System.out.println("\nThe date and time taken for product "+pr_id+" are:");
			 while(rset.next())
			 {
                 System.out.println(rset.getDate("p_date"));
			     System.out.println(rset.getFloat("time_taken"));
			 }
			 break;
			 
		 case 8:
			 System.out.println("\n Enter the Worker name :\n");
			 String wname=in.next();
			 q="select count(prod_id) from products where prod_person='"+wname+"'";
			 rset=stmt.executeQuery(q);
			 while(rset.next())
			 {
                 System.out.println(rset.getInt("count(prod_id)"));
			 }
			 break;
			 
		 case 9:
			 System.out.println("\n Enter the Quality controller name :\n");
			 String qname;
			 qname=in.next();
			 q="select count(prod_id) from products p where exists(select * from make_complaint m where m. prod_id = p. prod_id and p.test_person='"+qname+"')";
			 rset=stmt.executeQuery(q);
			 while(rset.next())
			 {
                 System.out.println(rset.getInt("count(prod_id)"));
			 }
			 break;
			 
		 case 10:
			 System.out.println("\n Enter the Quality controller name :\n");
			 String qnme;
			 qnme=in.next();
			 q="select sum(pcost) from prodacc3 where prod_id in (select prod_id from request where e_nameq='"+qnme+"')";
			 rset=stmt.executeQuery(q);
			 while(rset.next())
                 System.out.println(rset.getFloat("sum(pcost)"));
			 break;
		 case 11:
			 System.out.println("\n Enter the color :\n");
			 String clr=in.next();
			 q="select c_name from purchase where prod_id in (select prod_id from product2 where product2.p_color='"+clr+"')";
			 rset=stmt.executeQuery(q);
			 while(rset.next())
			 {
                 System.out.println(rset.getString("c_name"));
			 }
			 break;
			 
		 case 12:
			 q="SELECT sum(workdays_lost) from accident where accident_no in (select accident_no from maycause,make_complaint where maycause.prod_id = make_complaint.prod_id)";
             rset=stmt.executeQuery(q);
             System.out.println("Total work days lost are:");
             while(rset.next())
                 System.out.println(rset.getInt("sum(workdays_lost)"));
             break;
			 
         case 13:
             q="select c_name from customer,worker where customer.c_name=worker.e_name";
             rset=stmt.executeQuery(q);
             while(rset.next())
                 System.out.println(rset.getString("c_name"));
             break;
			 
         case 14:
             q="SELECT c_name FROM purchase,products WHERE purchase.prod_id=products.prod_id AND "
             		+ "purchase.c_name IN (SELECT purchase.c_name FROM purchase, products "
             		+ "WHERE purchase.c_name = products.test_person OR purchase.c_name=products.repair_person "
             		+ "OR purchase.c_name=products.prod_person)";
             rset=stmt.executeQuery(q);
             while(rset.next())
                 System.out.println(rset.getString("c_name"));
             break;
			 
         case 15:
        	 System.out.println("\n Enter the beginning date :\n");
			 String bday=in.next();
			 System.out.println("\n Enter the end date :\n");
			 String eday=in.next();
			 q="SELECT AVG(pcost) FROM accounts WHERE a_date between"+"'" +bday+"'"+"and"+"'"+eday+"' ";
			 rset=stmt.executeQuery(q);
			 while(rset.next())
                 System.out.println(rset.getFloat("avg(pcost)"));
			 break;
			 
         case 16:
        	 System.out.println("\n Enter the Quality controller name\n");
			 String qnam;
			 qnam=in.next();
			 System.out.println("\n Enter the Technical Employee name \n");
			 String tnam;
			 tnam=in.next();
			 System.out.println("\n Enter the new Technical employee degree \n");
			 String deg;
			 deg=in.next();
			 System.out.println("\n Enter the new Quality Employee product type \n");
			 String prt=in.next();
			 System.out.println("\n Enter the new Technical Position \n");
			 String tp=in.next();
			 String r1= "delete from degrees where e_name = '"+tnam+"'";
			 String r="UPDATE quality_control SET e_name = '"+tnam+"' WHERE e_name = '"+qnam+"' ";
			 String s= "UPDATE tech_staff SET e_name = '"+qnam+"' WHERE e_name = '"+tnam+"'";
			 q="insert  into degrees values ('"+deg+"','"+qnam+"')";		
			 String t= "UPDATE quality_control SET prodtype_check = '"+prt+"' WHERE e_name = '"+tnam+"'";
			 tp= "UPDATE tech_staff SET tech_posn = '"+tp+"' WHERE e_name = '"+qnam+"'";
			 System.out.println(tp);
        	 rset=stmt.executeQuery(r1);
        	 rset=stmt.executeQuery(r);
        	 rset=stmt.executeQuery(s);
        	 stmt.executeUpdate(q);
        	 rset=stmt.executeQuery(t);
        	 rset=stmt.executeQuery(tp);
			 break;
			 
         case 17:
        	 System.out.println("Enter starting date of accident range :");
             String sdate = in.next();
             System.out.println("Enter ending date of accident range :");
             String edate = in.next();
             rset=stmt.executeQuery(" DELETE from accident where acc_date between"+"'" +sdate+"'"+"and"+"'"+edate+"' ");
             System.out.println("Accidents of given range of dates deleted"); 
             break;
			 
         case 18:
            	BufferedReader br = new BufferedReader (new FileReader("C:\\testing.txt"));
            	String s1=br.readLine();
                 while (s1!=null) 
                 {
                     String line = s1;
                     s1=br.readLine();
                     String line2 = s1;
                     s1=br.readLine();
                     String query="insert into customer(c_name,address) values('"+line+"','"+line2+"')";
                     stmt.executeUpdate(query);
                 }                
                break;
				
         case 19:
        	 rset = stmt.executeQuery("select * from customer order by c_name");
        	 ResultSetMetaData rd = rset.getMetaData();
        	 rset.next();
        	 System.out.println("Enter the file name: ");
        	 String outfilename=in.next();
        	 FileWriter cnme = new FileWriter("C:\\Users\\Aniteja\\Desktop\\" +outfilename);
        	 for (int i = 1; i <= rd.getColumnCount(); i++)
        	 {
        		 System.out.print(rd.getColumnName(i) + " ");
        		 cnme.append(rd.getColumnName(i));
        		 cnme.append(",\n");
        		 cnme.append("\n");
        		 cnme.flush();
        		 System.out.println();
        		 while (rset.next()) 
        		 {
        		 cnme.append("\"" + rset.getString(1) + "\",\" " + rset.getString(2) + "\"");
        		 cnme.append("\n");
        		 }
        	 }
        		 break;
				 
         case 20: System.exit(0);	
		 }
	 }                  
	conn.close();  
	}  	 

		 catch(Exception e) 
		 { System.out.println (e.getMessage()); 
		 System.out.println ("Exception occurred in executing the statement"); 
		 }
	}
}
