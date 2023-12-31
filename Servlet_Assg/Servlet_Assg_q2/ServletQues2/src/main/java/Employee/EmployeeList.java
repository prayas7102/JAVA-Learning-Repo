package Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("serial")
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {

  String userName = "root";
  String userPassword = "prayas7@P";

  public void service(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
    Connection con;
    try {
      con =
        DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/",
          userName,
          userPassword
        );
      // use database
      String useDBSQL = "use Employee";
      // select all contents from EmployeeData
      String selectTable = "select * from EmployeeData";
      Statement stmt = con.createStatement();
      stmt.executeUpdate(useDBSQL);
      ResultSet resultSet = stmt.executeQuery(selectTable);
      PrintWriter out = response.getWriter();
      out.println(
        ("ID") + " " + ("Name") + " " + ("Department") + " " + ("Experience")
      );
      while (resultSet.next()) {
        out.println(
          resultSet.getString("ID") +
          " " +
          resultSet.getString("Name") +
          " " +
          resultSet.getString("Department") +
          " " +
          resultSet.getString("Experience")
        );
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
