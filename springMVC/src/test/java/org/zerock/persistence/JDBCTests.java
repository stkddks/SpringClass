package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Test;
import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			log.info(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}