package com.dimitris;

import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class StoredProc {

	public static int insert_patient(int amka, String name, String surname, int age, String test, String sex, int geo)
			throws SQLException {
		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "dimitris", 5, 10, true);

		Connection con = connectionPool.getConnection();

		String q = " execute insert_patient ?,?,?,?,?,?,?,?,? ";
		CallableStatement cs = con.prepareCall(q);

		cs.setInt(1, amka);
		cs.setString(2, name);
		cs.setString(3, surname);
		cs.setInt(4, age);
		cs.setString(5, test);
		cs.setString(6, sex);
		cs.setInt(7, geo);
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		cs.setDate(8, date);

		cs.registerOutParameter(9, Types.INTEGER);

		cs.execute();
		int date_diff = cs.getInt(9);
		connectionPool.free(con);
		return date_diff;

		// System.out.println("We have free/released connection to ConnectionPool
		// class");
	}

	public static int search_patient(int amka) throws SQLException {
		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "dimitris", 5, 10, true);

		Connection con = connectionPool.getConnection();

		String q = " execute search_patient ?,? ";
		CallableStatement cs = con.prepareCall(q);

		cs.setInt(1, amka);
		cs.registerOutParameter(2, Types.INTEGER);

		cs.executeUpdate();

		int found = cs.getInt(2);
		return found;

	}

	public static void insert_contact(int amka, String name, String surname, int age) throws SQLException {
		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "dimitris", 5, 10, true);

		Connection con = connectionPool.getConnection();

		String q = " execute insert_contact ?,?,?,? ";
		CallableStatement cs = con.prepareCall(q);

		cs.setString(1, name);
		cs.setString(2, surname);
		cs.setInt(3, age);
		cs.setInt(4, amka);

		cs.executeUpdate();

	}

	public static int insert_credentilas(String username, String password, String name, String surname, String email)
			throws SQLException {
		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "dimitris", 5, 10, true);

		Connection con = connectionPool.getConnection();

		String q = " execute insert_credentials ?,?,?,?,?,?,? ";
		CallableStatement cs = con.prepareCall(q);

		cs.setString(1, username);
		cs.setString(2, password);
		cs.setString(3, name);
		cs.setString(4, surname);
		cs.setString(5, email);

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		cs.setDate(6, date);

		cs.registerOutParameter(7, Types.INTEGER);

		cs.executeUpdate();

		int inserted = cs.getInt(7);

		System.out.println(inserted);

		return inserted;

	}

	public static ArrayList getTestData(int amka) throws SQLException {
		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "dimitris", 5, 10, true);

		Connection con = connectionPool.getConnection();

		String q = " execute getTestData ? ";
		CallableStatement cs = con.prepareCall(q);

		cs.setInt(1, amka);

		ResultSet rs = cs.executeQuery();
		ArrayList ret_list = new ArrayList();
		ret_list = resultSetToArrayList(rs);
		
		return ret_list;

	}

	public static ArrayList show_contacts(int amka) throws SQLException {
		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "dimitris", 5, 10, true);

		Connection con = connectionPool.getConnection();
		String q = " execute show_contacts ? ";
		PreparedStatement cs = con.prepareStatement(q);
		cs.setInt(1, amka);
		ResultSet rs = cs.executeQuery();
		ArrayList ret_list = new ArrayList(50);
		ret_list = resultSetToArrayList(rs);

		if (rs != null)
			rs.close(); // close resultSet
		if (cs != null)
			cs.close(); // close PreparedStatement

		return ret_list;

	}

	public static String getNameSurname(String username) throws SQLException {
		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "dimitris", 5, 10, true);

		Connection con = connectionPool.getConnection();

		String q = " execute getNameSurname ?,?,? ";
		CallableStatement cs = con.prepareCall(q);

		cs.setString(1, username);
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.registerOutParameter(3, Types.VARCHAR);

		cs.executeUpdate();

		String name = cs.getString(2);
		String surname = cs.getString(3);

		return name + " " + surname;

	}

	public static ArrayList resultSetToArrayList(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		ArrayList<ArrayList> list = new ArrayList(50);
		while (rs.next()) {
			// HashMap row = new HashMap(columns);
			ArrayList list1 = new ArrayList();
			for (int i = 1; i <= columns; i++) {
				// row.put(md.getColumnName(i),rs.getObject(i));
				list1.add(rs.getObject(i));

			}
			list.add(list1);

		}
		for (Object o : list)
			System.out.println(o + " ");

		return list;
	}

}
