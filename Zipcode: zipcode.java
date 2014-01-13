
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class zipcode {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	static String USER = "root"; //username of the database
	static String PASS = ""; //password of the database
	static final String DB_URL = "jdbc:mysql://localhost:3306/zipDB"; //creation of the table
	static Connection conn = null;
	static Statement stmt = null;
	static float lon1 =0;
	static float lat1 =0;
	static float lon2 =0;
	static float lat2 =0;
	static String city1;
	static String city2;
	static String state1;
	static String state2;
	static boolean found1=false;
	static boolean found2=false;
	public static void main(String[] args) throws Exception, ClassNotFoundException, SQLException{
		String zipfile = "zipcode.csv";
		
		FileInputStream in = new FileInputStream(zipfile);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		String[] array;
		array=new String[41878];
		//Establish a connection with the mysql server
		
		System.out.println("Please Enter Your Username & Password for mySQL");
		USER =JOptionPane.showInputDialog("Please Enter Your mySql Username");
		PASS =JOptionPane.showInputDialog("Please Enter Your mySql Password");
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?user="+USER+"&password="+PASS+"");
		}catch(SQLException e){
			System.out.println("Connection error, wrong username or password");
			System.exit(0);
		}
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//accessing the localhost
			System.out.println("Connecting to a selected database...");
			try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?user="+USER+"&password="+PASS+"");
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE DATABASE zipDB");
			System.out.println("Creating new Database zipDB in server...");
			conn.close();
			}
			catch(Exception e){
				System.out.println("Database exists");
			}
			try{
				conn=DriverManager.getConnection(DB_URL,USER,PASS);
				stmt=conn.createStatement();
			}catch (Exception e){
				System.out.println("connection error");
			}
			System.out.println("Creating table in database...");
			
			try{
			//creating the table ZIPCODE11 in the database
			String table = "Create TABLE Zipcode" +
						"(zip INTEGER (5)," +
						" city VARCHAR (20)," +
						" state VARCHAR (5)," +
						" lat FLOAT (5)," +
						" lon FLOAT (5)," +
						" PRIMARY KEY(zip) )";
			stmt.executeUpdate(table); //update the information in the database
			System.out.println("zipcode table created...");
			}catch(Exception e){
				System.out.println("zipcode table exists");
			}//catch
			
			for(int i=0; i<array.length;i++){
				line=br.readLine();
				array[i]=line;
				String[] nline = array[i].split(",");
			
			//insert values into the database after creation
			String insert;
				try{
					insert = "INSERT INTO Zipcode " +
						"VALUES ('"+Integer.parseInt(nline[0])+"', '"+nline[1]+"', '"+nline[2]+"', '"+Double.parseDouble(nline[3]) +"', '"+Double.parseDouble(nline[4])+"')";
					stmt.executeUpdate(insert);
				}catch(Exception e){
				}//catch
			}//for
			in.close();
		System.out.println("Inserted Data into database successfully...");
//	}catch(SQLException sqle){
//		sqle.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		//displaying the information of the database
		myGUI gui = new myGUI();
		gui.setVisible(true);
	}//end of finally
}//main
	public static void zipSearch(int zip1, int zip2){
		System.out.println("Searching the database...");
		String query = "select * from Zipcode";
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery (query);
			found1=false;
			found2=false;
			while(rs.next()){
				int zipcode1 = rs.getInt(1); //get the 1st item in the database field
				if(zip1==zipcode1){
					city1 = rs.getString(2); //get the 2nd item in the database field
					state1 = rs.getString(3);//get the 3rd item in the database field
					lat1 = rs.getFloat(4); //get the 4th item in the database field
					lon1 = rs.getFloat(5); //get the 5th item in the database field
					found1=true;
				}//if
				int zipcode2=rs.getInt(1);//get the 1st item in the database field
				if(zip2==zipcode2){	
					city2 = rs.getString(2);//get the 2nd item in the database field
					state2 = rs.getString(3);//get the 3rd item in the database field
					lat2 = rs.getFloat(4);//get the 4th item in the database field
					lon2 = rs.getFloat(5);//get the 5th item in the database field
					found2=true;
				}//if
				if(found1==true && found2 ==true)
					break;
			}//while
			if(found1==false){
				JOptionPane.showMessageDialog(null, "Zip code 1 not found in database");
			}
			if(found2==false)
				JOptionPane.showMessageDialog(null, "Zip code 2 not found in database");
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println("Zip not found");
		}
	}//zipsearch method

	
/**
 * Search the city and state of the 
 * 	
 * @param city
 * @param state
 * @return
 */
	public static int cityStateSearch(String city, String state){
		String query = "select * from Zipcode";
		try{
			stmt = conn.createStatement();//establish connection
			ResultSet rs = stmt.executeQuery (query);//querty the item
			while(rs.next()){	 	
					String theCity = rs.getString(2);//city column
					String theState = rs.getString(3);//state column

				if(city.equalsIgnoreCase(theCity) && state.equalsIgnoreCase(theState)){
					int zipcode = rs.getInt(1);
					//return zipcode is the city/state is found
					return zipcode;
				}//if
				found1=false;
			}//while
			if(found1==false){
				JOptionPane.showMessageDialog(null, "Zip code not found in database, using Default zipcode");
			}
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println("Zip not found");
		}
		return 11367;
	}
}//class
