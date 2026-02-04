package database;

import model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public boolean insertDoctor(Doctor doctor) {

        String sql = """
            INSERT INTO doctors
            (name, specialization, experienceYears, salary, department, patientsPerDay)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialization());
            statement.setInt(3, doctor.getExperienceYears());
            statement.setDouble(4, doctor.getSalary());
            statement.setString(5, doctor.getDepartment());
            statement.setInt(6, doctor.getPatientsPerDay());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
            return false;
        }
    }
    public List<Doctor> getAllDoctors() {
        String sql = "SELECT * FROM doctors ORDER BY stuffId";
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                doctors.add(extractDoctor(rs));
            }

        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        }

        return doctors;
    }
    public Doctor getDoctorById(int stuffId) {
        String sql = "SELECT * FROM doctors WHERE stuffId = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, stuffId);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) return extractDoctor(rs);
            }

        } catch (SQLException e) {
            System.out.println("getDoctorById failed!");
            e.printStackTrace();
        }

        return null;
    }
    public boolean updateDoctor(Doctor doctor) {
        String sql = """
            UPDATE doctors
            SET name = ?, specialization = ?, experienceYears = ?, salary = ?, department = ?, patientsPerDay = ?
            WHERE stuffId = ?
        """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, doctor.getName());
            st.setString(2, doctor.getSpecialization());
            st.setInt(3, doctor.getExperienceYears());
            st.setDouble(4, doctor.getSalary());
            st.setString(5, doctor.getDepartment());
            st.setInt(6, doctor.getPatientsPerDay());
            st.setInt(7, doctor.getStuffId());
            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Update failed!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDoctor(int stuffId) {
        String sql = "DELETE FROM doctors WHERE stuffId = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, stuffId);
            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
            return false;
        }
    }
    public List<Doctor> searchByName(String name) {
        String sql = "SELECT * FROM doctors WHERE name ILIKE ? ORDER BY name";
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, "%" + name + "%");

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) doctors.add(extractDoctor(rs));
            }

        } catch (SQLException e) {
            System.out.println("Search by name failed!");
            e.printStackTrace();
        }

        return doctors;
    }
    public List<Doctor> searchBySalaryRange(double minSalary, double maxSalary) {
        String sql = """
            SELECT * FROM doctors
            WHERE salary BETWEEN ? AND ?
            ORDER BY salary DESC
        """;

        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            st.setDouble(1, minSalary);
            st.setDouble(2, maxSalary);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) doctors.add(extractDoctor(rs));
            }

        } catch (SQLException e) {
            System.out.println("Search by salary range failed!");
            e.printStackTrace();
        }

        return doctors;
    }
    public List<Doctor> searchByMinSalary(double minSalary) {
        String sql = """
            SELECT * FROM doctors
            WHERE salary >= ?
            ORDER BY salary DESC
        """;

        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            st.setDouble(1, minSalary);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) doctors.add(extractDoctor(rs));
            }

        } catch (SQLException e) {
            System.out.println("Search by min salary failed!");
            e.printStackTrace();
        }

        return doctors;
    }
    private Doctor extractDoctor(ResultSet rs) throws SQLException {
        int id = rs.getInt("stuffId");
        String name = rs.getString("name");
        String specialization = rs.getString("specialization");
        int experience = rs.getInt("experienceYears");
        double salary = rs.getDouble("salary");
        String department = rs.getString("department");
        int patientsPerDay = rs.getInt("patientsPerDay");

        return new Doctor(id, name, specialization, experience, salary, department, patientsPerDay);
    }
}