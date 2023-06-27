package project;
import java.util.*;
import java.sql.*;
public class project {
	static {
		System.out.println("welcome to car showroom!!!");
	}
	public static void welcome() {
		Scanner sc=new Scanner(System.in);
		System.out.println("press 1 to register");
		System.out.println("press 2 to display the car models");
		System.out.println("press 3 to sell the car");
		System.out.println("press 4 to buy the car");
		System.out.println("press 5 to display upcoming cars");
		System.out.println("enter the choice:-");
		int n=sc.nextInt();
		
		switch(n) {
		case 1:{
		register();
		break;
		}
		case 2:{
			display();
			break;
		}
		case 3:{
			sell();
			break;
		}
		case 4:{
			buy();
			break;
		}
		case 5:{
			upcomingCars();
			break;
		}

		}
	}
	public static void upcomingCars() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Neha211@b");
Statement stmt =con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from carshowroom.upcomingcars");
			while(rs.next()) {
			
			String carid=rs.getString(1);
			String carname =rs.getString(2);
			String brand=rs.getString(3);
			
			
			
		System.out.println();
		
			System.out.println(carid +"       "+carname  +  "              "   + brand );
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void register() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter First name:-");
			String Fname=sc.next();
			System.out.println("Enter Second name:-");
			String Lastname=sc.next();
			System.out.println("Enter Phone no:-");
			int PhoneNo=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Username:-");
			String Username=sc.next();
			System.out.println("Enter Password:-");
			String password=sc.next();
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Neha211@b");
			PreparedStatement pstmt=con.prepareStatement("insert into carshowroom.registration values(?,?,?,?,?)");
			pstmt.setString(1, Fname);
			pstmt.setString(2, Lastname);
			pstmt.setInt(3, PhoneNo);
			pstmt.setString(4, Username);
			pstmt.setString(5, password);
			pstmt.executeUpdate();
			System.out.println("Registration successfully");
			display();
		

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 
	}
	public static void sell() {
		try {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("insert new car model");
			System.out.println();
			System.out.println("Enter Car id:-");
			String cid=sc.nextLine();
			System.out.println("Enter Carname:-");
			String car_name=sc.nextLine();
			System.out.print("Enter Model :-");
			String model=sc.nextLine();
			System.out.print("Enter brand:-");
			String brand=sc.nextLine();
			System.out.print("Enter price");
			String price=sc.nextLine();
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Neha211@b");
			PreparedStatement pstmt=con.prepareStatement("insert into carshowroom.carmodels values(?,?,?,?,?)");
			pstmt.setString(1, cid);
			pstmt.setString(2, car_name);
			pstmt.setString(3, model);
			pstmt.setString(4, brand);
			pstmt.setString(5, price);
			pstmt.executeUpdate();
			System.out.println("record added into database");
			System.out.println("Total models");
			display();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	public static void display() {
		try {

			System.out.println("car model details");
			System.out.println();
			System.out.println("********************/////********************");
			System.out.println();
			System.out.println("carid"+"     ||     "+"carname"  +  "     ||     "  +   "model"   +  "      ||       "    + "brand"    +   "      ||     "   +"price");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Neha211@b");
			Statement stmt =con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from carshowroom.carmodels");
			while(rs.next()) {
				String carid=rs.getString(1);
			String car_name=rs.getString(2);
			String  model=rs.getString(3);
			String brand=rs.getString(4);
			String price=rs.getString(5);
			
			
		System.out.println();
		
			System.out.println(carid+"   ||  "+car_name  +  "      ||        "  +   model   +  "      ||      "    + brand    +   "      ||         "   +price);
			}
			
			System.out.println();
			System.out.println("*********************////********************");
			welcome();
//			Scanner sc=new Scanner(System.in);
//			System.out.println("press 3 to sell:-");
//			System.out.println("enter the choice:-");
//			int n1=sc.nextInt();
//			switch(n1) {
//			case 3:{
//			sel();
//			break;
//			}
//			}
			}
			
		 catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void displaydetails() {

		try {

			System.out.println("car model details");
			System.out.println("********************/////********************");
			System.out.println("id"+   "           "       +"carname"  +  "       "  +   "model"   +  "     "    + "brand"    +   "        "   +"price");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Neha211@b");
			Statement stmt =con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from carshowroom.carmodels");
			while(rs.next()) {
				String cid=rs.getString(1);
			String carname=rs.getString(2);
			String  model=rs.getString(3);
			String brand=rs.getString(4);
			String price=rs.getString(5);
			
			
		System.out.println();
		
			System.out.println(cid +"        " +carname  +  "              "  +   model   +  "            "    + brand    +   "               "   +price);
			}
			
			System.out.println();
			System.out.println("*********************////********************");
			Scanner sc=new Scanner(System.in);
			System.out.println("press 3 to sell, press 4 to buy, press 5 to display the upcoming cars");
			
			System.out.println("enter the choice");
			int n1=sc.nextInt();
			switch(n1) {
			case 3:{
			sell();
			break;
			}
			case 4:{
				buy();
				break;
				}
			}}
			
		 catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public static void buy() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id to fetch: ");
		int cid=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Neha211@b");
			PreparedStatement pstmt=con.prepareStatement("select *  from carshowroom.carmodels where cid=?");
			
			pstmt.setInt(1, cid);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				String cid1=rs.getString(1);
				String carname=rs.getString(2);
				String  model=rs.getString(3);
				String brand=rs.getString(4);
				String price=rs.getString(5);
				System.out.println(cid1  +"    ||    " +carname  +  "       ||       "  +   model   +  "     ||       "    + brand    +   "     ||          "   +price);
			}
			else {
				System.out.println("Invalid id");
			}
		
		welcome();	
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		welcome();
	
}
}
