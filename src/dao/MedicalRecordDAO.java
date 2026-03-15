package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicalRecordDAO {

    // Add medical record
    public void addMedicalRecord(int patientId, int doctorId, String diagnosis, String treatment) {

        String sql = "INSERT INTO medical_records(patient_id, doctor_id, diagnosis, treatment) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setString(3, diagnosis);
            ps.setString(4, treatment);

            ps.executeUpdate();

            System.out.println("Medical record added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // TASK 4: List all medical records for a specific patient
    public void getMedicalRecordsByPatient(int patientId) {

        String sql = "SELECT diagnosis, treatment, doctor_id, created_at FROM medical_records WHERE patient_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        "Diagnosis: " + rs.getString("diagnosis") +
                                " | Treatment: " + rs.getString("treatment") +
                                " | Doctor ID: " + rs.getInt("doctor_id") +
                                " | Date: " + rs.getTimestamp("created_at")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPatientsDiagnosedMoreThanOnce() {

        String sql =
                "SELECT patient_id, COUNT(*) AS diagnosis_count " +
                        "FROM medical_records " +
                        "GROUP BY patient_id " +
                        "HAVING COUNT(*) > 1";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                        "Patient ID: " + rs.getInt("patient_id") +
                                " | Diagnosed Times: " + rs.getInt("diagnosis_count")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
