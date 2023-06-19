package Phone;

import Phone.phone;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class phoneDbUtil {
    private DataSource dataSource;

    public phoneDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<phone> getPhones() throws Exception {
        List<phone> phone = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/web_phone_tracker";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);

            String sql = "select * from phone order by name";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                int id = myRs.getInt("id");
                String name = myRs.getString("name");
                String brand = myRs.getString("brand");
                String description = myRs.getString("description");
                double price = myRs.getDouble("price");


                phone tempPhone = new phone(id, name, brand, description, price);

                phone.add(tempPhone);
            }
            return phone;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    public void addPhone(phone thePhone) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            String url = "jdbc:mysql://localhost:3306/web_phone_tracker";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);

            String sql = "insert into phone" + "(name, brand, description, price)" + "values (?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, thePhone.getName());
            myStmt.setString(2, thePhone.getBrand());
            myStmt.setString(3, thePhone.getDescription());
            myStmt.setDouble(4, thePhone.getPrice());

            myStmt.execute();
        } finally {
            close(myConn, myStmt, null);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


}
