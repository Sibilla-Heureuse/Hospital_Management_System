package dao;

import java.sql.*;
import java.sql.Date;

public class PatientDAO {

    public void addPatient(String first,String last,String dob,String gender,String phone,String email){

        String sql = "INSERT INTO patients(first_name,last_name,date_of_birth,gender,phone_number,email) VALUES(?,?,?,?,?,?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,first);
            ps.setString(2,last);
            ps.setDate(3,Date.valueOf(dob));
            ps.setString(4,gender);
            ps.setString(5,phone);
            ps.setString(6,email);

            ps.executeUpdate();

            System.out.println("Patient added");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletePatient(int patientId){

        String sql = "DELETE FROM patients WHERE id=?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,patientId);

            ps.executeUpdate();

            System.out.println("Patient deleted");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}