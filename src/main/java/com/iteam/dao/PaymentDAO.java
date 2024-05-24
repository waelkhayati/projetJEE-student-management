package com.iteam.dao;

import com.iteam.model.Payment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    private Connection connection = SingletonConnection.getConnection();

    // Add a payment to the database
    public void addPayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payments (student_id, amount, date) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, payment.getStudentId());
        statement.setBigDecimal(2, payment.getAmount());
        statement.setTimestamp(3, new Timestamp(payment.getDate().getTime()));
        statement.executeUpdate();

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                payment.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating payment failed, no ID obtained.");
            }
        }
    }

    // Update an existing payment
    public void updatePayment(Payment payment) throws SQLException {
        String sql = "UPDATE payments SET student_id = ?, amount = ?, date = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, payment.getStudentId());
        statement.setBigDecimal(2, payment.getAmount());
        statement.setTimestamp(3, new Timestamp(payment.getDate().getTime()));
        statement.setInt(4, payment.getId());
        statement.executeUpdate();
    }

    // Delete a payment by ID
    public void deletePayment(int id) throws SQLException {
        String sql = "DELETE FROM payments WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    // Retrieve a payment by its ID
    public Payment getPaymentById(int id) throws SQLException {
        String sql = "SELECT * FROM payments WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Payment payment = new Payment(
                resultSet.getInt("student_id"),
                resultSet.getBigDecimal("amount"),
                resultSet.getTimestamp("date"));
            payment.setId(resultSet.getInt("id"));
            return payment;
        }
        return null;
    }

    // Retrieve all payments from the database
    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT p.id, p.student_id, p.amount, p.date, s.name as student_name " +
                     "FROM payments p " +
                     "JOIN students s ON p.student_id = s.id";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        	Payment payment = new Payment(
        		    resultSet.getInt("student_id"),
        		    resultSet.getBigDecimal("amount"),
        		    new Date(resultSet.getTimestamp("date").getTime())); 
        		payment.setStudentName(resultSet.getString("student_name"));
        		payment.setId(resultSet.getInt("id"));
        		payments.add(payment);

        }
        return payments;
    }

    
}

