package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;


public class DBQueries {

	@Test
	public void executeQuery() throws ClassNotFoundException, SQLException {
		// Setting Driver
		System.out.println("Before connection");
		//Class.forName("com.postgresql.jdbc.Driver");
		Class.forName("org.postgresql.Driver");

		//Class.forName(null)
		// Open a connection to database
		//Connection con=DriverManager.getConnection("jdbc:mysql//localhost:3306/myprofile_otpverification","debiprasad","Dhsn@8884#hdnDll");
		//	Connection con=DriverManager.getConnection("jdbc:mysql://dev-nbfc-db.cgkhptdv3xxx.ap-south-1.rds.amazonaws.com:3306/STAGING1","debiprasad","Dhsn@8884#hdnDll");	
		Connection con=DriverManager.getConnection("jdbc:postgresql://dev-nbfc-db.cgkhptdv3xxx.ap-south-1.rds.amazonaws.com:5432/STAGING1","debiprasad","Dhsn@8884#hdnDll");
		System.out.println("Started connection with new port");
		Statement st=con.createStatement();
		System.out.println("Statement created");
		//String mobileNo;
		//ResultSet rs=st.executeQuery("SELECT \"mobileNo\",otp FROM public.myprofile_otpverification\r\n"
		//		+ "ORDER BY id DESC LIMIT 15");System.out.println("Started connection with new port");
		//ResultSet rs=st.executeQuery("SELECT distinct \"mobileNo\" FROM public.myprofile_otpverification\r\n where "
		//		+ "\"mobileNo\"=9948992457");
		//ResultSet rs=st.executeQuery("SELECT myprofile_otpverification.mobileNo FROM public.myprofile_otpverification WHERE myprofile_otpverification.otp='1400'");
		 String v="SELECT"+"\"mobileNo\"" +" FROM public.myprofile_otpverification WHERE myprofile_otpverification.otp='1400';";
		 System.out.println(v);
		// THE RESULT BELOW NEEDS THE COLUMN NAMES TO BE PRESENT CORRECTLY
		ResultSet rs=st.executeQuery(v);
		
		
	//	ResultSet rs=st.executeQuery("SELECT public.myprofile_otpverification.mobileNo  FROM public.myprofile_otpverification");
		
		//ResultSet rs=st.executeQuery("SELECT myprofile_otpverification.otp\r\n"
		//		+ "FROM PUBLIC.MYPROFILE_OTPVERIFICATIONWHERE myprofile_otpverification.otp = '1400'");
		System.out.println("Result Set created");
		System.out.println(rs);
		//while(rs.next()) {
		//	System.out.println(rs.getInt(1)+""+rs.getInt(2)+""+rs.getInt(3));

		// While Loop to iterate through all data and print results	
		// this is to connect
		while (rs.next()){
			String otp = rs.getString(1);								        
			//String myAge = rs.getString(2);					                               
			System. out.println(otp);	
		}

	}

}
