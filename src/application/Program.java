package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			conn.setAutoCommit(false); //não é para confirmar as operações automaticamente.
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			
			//simulando um erro antes do segundo update
			//int x = 1;
			//if(x < 2) {
			//	throw new SQLException("Fake error");
			//}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			conn.commit(); //para confirmar que a transação terminou
			
			System.out.println("rows1 " + rows1);
			System.out.println("rows2 " + rows2);
		}
		catch(SQLException e) {
			try {
				conn.rollback(); //volta o banco para o estado anterior
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
