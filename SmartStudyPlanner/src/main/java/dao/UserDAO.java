package dao;

import java.sql.*;
import model.User;

public class UserDAO {

    private String url = "jdbc:mysql://localhost:3306/studyplanner";
    private String user = "root";
    private String password = "root"; // change if needed

    // 🔗 Get connection (BEST PRACTICE)
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    // 🔐 REGISTER USER
    public boolean registerUser(User u) {
        boolean status = false;

        try {
            Connection con = getConnection();

            System.out.println("Saving user to DB...");

            String query = "INSERT INTO users(username, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, u.getUsername().trim());
            ps.setString(2, u.getPassword().trim());

            int rows = ps.executeUpdate();

            System.out.println("Rows inserted: " + rows);

            if (rows > 0) {
                status = true;
                System.out.println("User inserted successfully ✅");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error in registerUser ❌");
            e.printStackTrace();
        }

        return status;
    }

    // 🔍 VALIDATE LOGIN
    public boolean validateUser(User u) {
        boolean status = false;

        try {
            Connection con = getConnection();

            System.out.println("Checking user in DB...");
            System.out.println("Username: " + u.getUsername());
            System.out.println("Password: " + u.getPassword());

            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, u.getUsername().trim());
            ps.setString(2, u.getPassword().trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
                System.out.println("User FOUND in DB ✅");
            } else {
                System.out.println("User NOT FOUND ❌");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error in validateUser ❌");
            e.printStackTrace();
        }

        return status;
    }
}