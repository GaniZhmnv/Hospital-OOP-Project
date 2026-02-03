package database;

import model.Doctor;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorDAO {

    public void insertDoctor(Doctor doctor) {

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

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Doctor inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        }
    }
    public void getAllDoctors() {
        String sql = "SELECT * FROM doctors";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n--- ALL DOCTORS FROM DATABASE ---");

            while (resultSet.next()) {
                int id = resultSet.getInt("stuffId");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                int experience = resultSet.getInt("experienceYears");
                double salary = resultSet.getDouble("salary");
                String department = resultSet.getString("department");
                int patientsPerDay = resultSet.getInt("patientsPerDay");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialization: " + specialization);
                System.out.println("Experience: " + experience + " years");
                System.out.println("Salary: " + salary);
                System.out.println("Department: " + department);
                System.out.println("Patients/Day: " + patientsPerDay);
                System.out.println("---");
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

}
