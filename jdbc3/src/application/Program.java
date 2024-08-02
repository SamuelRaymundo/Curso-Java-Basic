package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {

            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                            +"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            +"VALUES "
                            +"(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);


            st.setString(1,"Carl Purple");
            st.setString(2,"carl@gmail.com");
            st.setDate(3,new java.sql.Date(sdf.parse("07/02/2005").getTime()));
            st.setDouble(4,3020.0);
            st.setInt(5,4);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! id " + id);
                }
            }
            else {
                System.out.println("No rows affecteds!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
