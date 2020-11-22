package sql2java;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sql2java {

	public static void main(String[] args) {
		
		
		Connection conn = null;
		
		try {
			
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=COVID_19";
			String user = "sa";
			String pass = "to passcode toy SQL sever";
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL,user, pass);
			
			//Statement stmt = conn.createStatement();
            //ResultSet rs;
 
            //rs = stmt.executeQuery("SELECT surname FROM patient2 WHERE name='DIM'  " );
            //while ( rs.next() ) {
              //  String surname = rs.getString("surname");
                //System.out.println(surname);
            //}
			
			
			
			
			if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
		}
            catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
			
		
		
		
		
		}
	
	
		
		
	}
	
	

