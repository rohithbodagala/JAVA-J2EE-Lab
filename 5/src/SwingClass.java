import java.sql.*;
import java.util.*;

public class SwingClass {

	public static void main(String[] args) throws  SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int iduser=Integer.parseInt(sc.nextLine());
		String name=sc.nextLine();
		String pass=sc.nextLine();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/a","root","root");
		String query="insert into user values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,iduser);
		ps.setString(2,name);
		ps.setString(3,pass);
		int i=ps.executeUpdate();
		String q2="select * from user";
		PreparedStatement ps1=con.prepareStatement(q2);
		ResultSet rs=ps1.executeQuery();
		String a="iduser";
		String b="name";
		String c="pass";
		while(rs.next())
		{
			System.out.println(rs.getInt(a));
			System.out.println(rs.getString(b));
			System.out.println(rs.getString(c));
			
		}
	}

}
