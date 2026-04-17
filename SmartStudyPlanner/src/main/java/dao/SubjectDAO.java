package dao;

import java.sql.*;
import model.Subject;

public class SubjectDAO {

    private String url = "jdbc:mysql://localhost:3306/studyplanner";
    private String user = "root";
    private String password = "root"; // change if needed

    public void saveSubject(Subject s) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO subjects(name, difficulty, hours) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.getName());
            ps.setString(2, s.getDifficulty());
            ps.setInt(3, s.getHours());

            ps.executeUpdate();

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}