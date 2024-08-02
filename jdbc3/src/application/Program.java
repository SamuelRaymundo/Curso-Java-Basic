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
        ResultSet rs = null;

        try {

            System.out.print("How many sellers do you want to add: ");
            int sellersQuantity = sc.nextInt();

            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                            +"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            +"VALUES "
                            +"(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);


            for (int i = 0; i < sellersQuantity; i++) {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Email: ");
                String email = sc.next();
                System.out.print("Birth Date (dd/MM/yyyy):  ");
                java.sql.Date date = new java.sql.Date(sdf.parse(sc.next()).getTime());
                System.out.print("Base Salary: ");
                double baseSalary = sc.nextDouble();


                Statement pr = conn.createStatement();
                rs = pr.executeQuery("select * from department");

                System.out.println("Departments names: ");

                while (rs.next()) {
                    System.out.println(rs.getInt("Id") + ": " + rs.getString("Name"));
                }

                System.out.print("Departament: ");
                int departament = sc.nextInt();


                st.setString(1,name);
                st.setString(2,email);
                st.setDate(3,date);
                st.setDouble(4,baseSalary);
                st.setInt(5,departament);
                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0) {
                    rs = st.getGeneratedKeys();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        System.out.println("Done! id " + id);
                    }
                }
                else {
                    System.out.println("No rows affecteds!");
                }

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
