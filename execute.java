import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class execute {

	static int insert_count = 0;
	// String url,user_name, passcode;
	// int initial_con, max_con;

	// static String url = "jdbc:sqlserver://localhost:1433;databaseName=COVID_19";
	// static String user_name = "sa";
	// static String passcode = "dimitris";

	public static void insert(int AMKA, String name, String surname, int age, int test) throws SQLException {

		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "lampros7", 5, 10, true);

		Connection con = connectionPool.getConnection();
		// System.out.println("We have got connection from ConnectionPool class");

		PreparedStatement prepStmt1 = con.prepareStatement("insert into people(AMKA , name,surname,age,test) values("
				+ AMKA + ", '" + name + "', '" + surname + "' , " + age + ", " + test + ")     ");

		prepStmt1.executeUpdate();
		insert_count = insert_count + 1;

		if (test == 0) {
			PreparedStatement prepStmt2 = con.prepareStatement("insert into negative(AMKA,name,surname,age) values("
					+ AMKA + ", '" + name + "', '" + surname + "' , " + age + ")     ");

			prepStmt2.executeUpdate();
		} else {
			PreparedStatement prepStmt3 = con.prepareStatement("insert into possitive(AMKA,name,surname,age) values("
					+ AMKA + ", '" + name + "' , '" + surname + "' , " + age + " )    ");
			prepStmt3.executeUpdate();

		}

		prepStmt1.close(); // close PreparedStatement

		connectionPool.free(con);
		// System.out.println("We have free/released connection to ConnectionPool
		// class");

	}

	public static void show() throws SQLException {

		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "lampros7", 5, 10, true);

		Connection con = connectionPool.getConnection();
		// System.out.println("We have got connection from ConnectionPool class");

		PreparedStatement prepStmt = con.prepareStatement("select * from people");

		ResultSet rs = prepStmt.executeQuery();

		System.out.println("AMKA" + "   " + "NAME" + "     " + "SURNAME" + "  " + "AGE" + "  " + "TEST");
		while (rs.next()) {
			System.out.print(rs.getInt("AMKA") + " ");
			System.out.print(rs.getString("name") + " ");
			System.out.print(rs.getString("surname") + "    ");
			System.out.print(rs.getInt("age") + "    ");
			System.out.println(rs.getInt("test") + " ");

		}

		if (rs != null)
			rs.close(); // close resultSet
		if (prepStmt != null)
			prepStmt.close(); // close PreparedStatement

		connectionPool.free(con);
		// System.out.println("We have free/released connection to ConnectionPool
		// class");

	}

	public static int  search(int AMKA) throws SQLException {

		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "lampros7", 5, 10, true);

		Connection con = connectionPool.getConnection();
		PreparedStatement prepStmt1 = con.prepareStatement("select * from people where AMKA = " + AMKA + "  ");

		ResultSet rs = prepStmt1.executeQuery();

		String test_string;
		int test=-1;
		
		while (rs.next()) {
			if (rs.getInt("test") == 0) {
				test_string = "NEGATIVE";
				test = rs.getInt("test");
			} else {
				test_string = "POSITIVE";
				test = rs.getInt("test");
			}

			System.out.println("THE PATIENT WITH AMKA= " + AMKA + " NAMED: " + rs.getString("name") + " "
					+ rs.getString("surname") + " IS TESTED:" + test_string);

		}

		rs.close();
		prepStmt1.close();
		connectionPool.free(con);
		return test;
	}

	public static void insert_cont(String name, String surname, int age, int AMKA,int test) throws SQLException {

		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "lampros7", 5, 10, true);

		Connection con = connectionPool.getConnection();
		// System.out.println("We have got connection from ConnectionPool class");

		PreparedStatement prepStmt1 = con.prepareStatement(
				"insert into contacts(name,surname,age,test) values( '" + name + "', '" + surname + "' , " + age + ","+test+" ) ");

		prepStmt1.executeUpdate();

		PreparedStatement prepStmt2 = con
				.prepareStatement(" select * from contacts where name='" + name + "' and surname = '" + surname + "'");

		ResultSet rs = prepStmt2.executeQuery();
		int id = -1;
		while (rs.next()) {
			id = rs.getInt("cont_id");
		}
		// System.out.println(id);
		PreparedStatement prepStmt3 = con
				.prepareStatement(" insert into possitive_conatcts values(" + AMKA + " , " + id + " )  ");
		prepStmt3.executeUpdate();

		prepStmt1.close(); // close PreparedStatement
		prepStmt2.close();
		prepStmt3.close();
		rs.close();
		connectionPool.free(con);
		// System.out.println("We have free/released connection to ConnectionPool
		// class");

	}

	public static void show_contacts(int AMKA) throws SQLException {

		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "lampros7", 5, 10, true);

		Connection con = connectionPool.getConnection();
		// System.out.println("We have got connection from ConnectionPool class");

		PreparedStatement prepStmt = con.prepareStatement(
				"select name, surname, age from contacts where cont_id in (select con_id from possitive_conatcts where AMKA="
						+ AMKA + ")");

		ResultSet rs = prepStmt.executeQuery();

		System.out.println("THE PERSON HAS CONTACTED: ");
		while (rs.next()) {

			System.out.print(rs.getString("name") + " ");
			System.out.print(rs.getString("surname") + "    ");
			System.out.println(rs.getInt("age") + "    ");

		}

		if (rs != null)
			rs.close(); // close resultSet
		if (prepStmt != null)
			prepStmt.close(); // close PreparedStatement

		connectionPool.free(con);
		// System.out.println("We have free/released connection to ConnectionPool
		// class");

	}

	public static int search_contact(String name, String surname) throws SQLException {

		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "lampros7", 5, 10, true);

		Connection con = connectionPool.getConnection();
		PreparedStatement prepStmt1 = con.prepareStatement(
				"select count(name) as res  from contacts where name = '" + name + "' and surname='" + surname + "'  ");

		ResultSet rs = prepStmt1.executeQuery();

		rs.next();
		int res = rs.getInt("res");
		prepStmt1.close();
		connectionPool.free(con);

		return res;

	}

	public static void modify_contact(String name, String surname, int test) throws SQLException {

		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "lampros7", 5, 10, true);

		Connection con = connectionPool.getConnection();
		PreparedStatement prepStmt1 = con.prepareStatement(
				" update contacts set test=" + test + " where name='" + name + "' and surname = '" + surname + "' ");

		prepStmt1.executeUpdate();

		
		

		prepStmt1.close();
		connectionPool.free(con);
		//return res;

	}
	
	public static void existing_add (String name, String surname , int AMKA) throws SQLException {
		
		
		
		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "lampros7", 5, 10, true);
		
		Connection con = connectionPool.getConnection();
		
		PreparedStatement prepStmt2 = con
				.prepareStatement(" select * from contacts where name='" + name + "' and surname = '" + surname + "'");

		ResultSet rs = prepStmt2.executeQuery();
		int id = -1;
		while (rs.next()) {
			id = rs.getInt("cont_id");
		}
		
		PreparedStatement prepStmt3 = con
				.prepareStatement(" insert into possitive_conatcts values("+AMKA+","+id+")");
		
		
		
		
	}
	

}

