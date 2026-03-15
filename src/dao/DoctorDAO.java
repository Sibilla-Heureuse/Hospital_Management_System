package dao;

import java.sql.*;

public class DoctorDAO {

    public void addDoctor(String first,String last,String specialty,String phone,String email){

        String sql = "INSERT INTO doctors(first_name,last_name,specialty,phone_number,email) VALUES(?,?,?,?,?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,first);
            ps.setString(2,last);
            ps.setString(3,specialty);
            ps.setString(4,phone);
            ps.setString(5,email);

            ps.executeUpdate();

            System.out.println("Doctor added successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
