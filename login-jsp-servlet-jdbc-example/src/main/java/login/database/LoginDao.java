package login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.bean.LoginBean;

public class LoginDao {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mysql_database?allowPublicKeyRetrieval=true&useSSL=false", "root",
				"minh_tan1A");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from login where username = ? and password = ? ")) {
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return status;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public LoginBean checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/mysql_database";
		String dbUser = "root";
		String dbPassword = "minh_tan1A";

//		
//		
//		
//		
		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		
//		String sql = "SELECT * FROM login WHERE username ='" + username +  "'and password ='" + password +"'";
//		System.out.println(sql);
//		PreparedStatement statement = connection.prepareStatement(sql);
		
		String sql = "SELECT * FROM login WHERE username = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();

		LoginBean user = null;

		if (result.next()) {
			user = new LoginBean();
			user.setUsername(result.getString("username"));
		}

		connection.close();

		return user;
	}
}