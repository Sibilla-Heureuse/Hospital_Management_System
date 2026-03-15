package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorPatientDAO {

    // Assign doctor to patient
    public void assignDoctorToPatient(int doctorId, int patientId) {

        String sql = "INSERT INTO doctor_patient(doctor_id, patient_id) VALUES(?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ps.setInt(2, patientId);

            ps.executeUpdate();

            System.out.println("Doctor assigned to patient");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDoctorPatientCounts() {

        String sql =
                "SELECT doctor_id, COUNT(patient_id) AS total_patients " +
                        "FROM doctor_patient " +
                        "GROUP BY doctor_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                        "Doctor ID: " + rs.getInt("doctor_id") +
                                " | Number of Patients: " + rs.getInt("total_patients")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getDoctorsWithMoreThanFivePatients() {

        String sql =
                "SELECT doctor_id, COUNT(patient_id) AS total_patients " +
                        "FROM doctor_patient " +
                        "GROUP BY doctor_id " +
                        "HAVING COUNT(patient_id) > 5";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                        "Doctor ID: " + rs.getInt("doctor_id") +
                                " | Patients: " + rs.getInt("total_patients")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
