package com.iteam.service;

import com.iteam.dao.PaymentDAO;
import com.iteam.model.Payment;
import java.sql.SQLException;
import java.util.List;

public class PaymentService {
    private PaymentDAO paymentDao = new PaymentDAO();

    public void addPayment(Payment payment) {
        try {
            paymentDao.addPayment(payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> getAllPayments() {
        try {
            return paymentDao.getAllPayments();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    

    public Payment getPaymentById(int id) {
        try {
            return paymentDao.getPaymentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updatePayment(Payment payment) {
        try {
            paymentDao.updatePayment(payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePayment(int id) {
        try {
            paymentDao.deletePayment(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
