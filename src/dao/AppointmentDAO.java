package dao;

import java.sql.*;

public class AppointmentDAO {

    public void createAppointment(int doctorId,int patientId,String date,String status){

        String sql = "INSERT INTO appointments(doctor_id,patient_id,appointment_date,status) VALUES(?,?,?,?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,doctorId);
            ps.setInt(2,patientId);
            ps.setTimestamp(3,Timestamp.valueOf(date));
            ps.setString(4,status);

            ps.executeUpdate();

            System.out.println("Appointment created");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void getPatientsByDoctor(int doctorId){

        String sql =
                "SELECT p.first_name,p.last_name " +
                        "FROM patients p " +
                        "JOIN appointments a ON p.id = a.patient_id " +
                        "WHERE a.doctor_id=?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,doctorId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                System.out.println(
                        rs.getString("first_name") + " " +
                                rs.getString("last_name")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateAppointmentStatus(int id,String status){

        String sql = "UPDATE appointments SET status=? WHERE id=?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,status);
            ps.setInt(2,id);

            ps.executeUpdate();

            System.out.println("Appointment updated");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}