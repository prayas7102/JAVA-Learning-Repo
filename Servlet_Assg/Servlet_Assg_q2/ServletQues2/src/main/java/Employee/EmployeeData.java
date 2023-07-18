package Employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/EmployeeData")
public class EmployeeData extends HttpServlet {

	String userName="root";
	String userPassword="prayas7@P";
	// check if db already exsists
	public boolean checkDB() throws SQLException {
		// Load the JDBC driver
		// Establish a connection to the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", userName, userPassword);

		// Connection connection = <your java.sql.Connection>
		ResultSet resultSet = connection.getMetaData().getCatalogs();

		// Iterate each catalog in the ResultSet
		while (resultSet.next()) {
			// Get the database name, which is at position 1
			String databaseName = resultSet.getString(1);
			if (databaseName.equals("employee")) {
				return true;
			}
		}
		resultSet.close();
		return false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nameOfEmployee = request.getParameter("name");
		String employeeId = request.getParameter("id");
		String departmentOfEmployee = request.getParameter("department");
		String experienceOfEmployee = request.getParameter("experience");

		try {
			// loading JDBC driver to connect with the mysql database
			Class.forName("com.mysql.cj.jdbc.Driver");

			// check if db exsists
			if (!checkDB()) {
				// creating a connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/",  userName, userPassword);
				Statement statement = con.createStatement();

				// Create a db
				String createDBSQL = "create database Employee";

				// use a db
				String useDBSQL = "use Employee";

				// Create a table
				String createTableSQL = "create table EmployeeData (ID varchar(100), Name varchar(100), Department varchar(100), Experience varchar(100))";

				// Execute the SQL statement to create the table
				statement.executeUpdate(createDBSQL);
				statement.executeUpdate(useDBSQL);
				statement.executeUpdate(createTableSQL);
				statement.close();
			}

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee",  userName, userPassword);
			
			// create a row
			String createRow = "insert into EmployeeData (ID, Name, Department, Experience) values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(createRow);
			pstmt.setString(1, employeeId);
			pstmt.setString(2, nameOfEmployee);
			pstmt.setString(3, departmentOfEmployee);
			pstmt.setString(4, experienceOfEmployee);
			pstmt.executeUpdate();

			// Close the statement and connection
			con.close();

			// Set the content type and write the explanation message
			response.setContentType("text/html");
			response.getWriter().println("<html><head><title>Redirecting...</title></head><body>");
			response.getWriter().println("<h2> DataSaved Successfuly </h2>");
			response.getWriter().println("</body></html>");

			// Redirecting to bank website after waiting for 3 sec
			response.setHeader("Location", "/ServletQues2/EmployeeList");
			response.setHeader("Refresh", "3; URL=" + "/ServletQues2/EmployeeList");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}