package com.iteam.web;
import com.iteam.model.Payment;
import com.iteam.model.Student;
import com.iteam.service.PaymentService;
import com.iteam.service.StudentService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PaymentServlet", urlPatterns = {"/payments"})
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;  
    private PaymentService paymentService = new PaymentService();
    private StudentService studentService;
    
    public PaymentServlet() {
        this.paymentService = new PaymentService();
        this.studentService = new StudentService();
      
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deletePayment(request, response);
                    break;
                case "list":
                default:
                    listPayments(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Error handling payment actions", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "insert":
                    insertPayment(request, response);
                    break;
                case "update":
                    updatePayment(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Error handling payment post actions", e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Student> listStudents = studentService.getAllStudents();
    	request.setAttribute("listStudents", listStudents);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
        dispatcher.forward(request, response);
    }
    

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Payment existingPayment = paymentService.getPaymentById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
        request.setAttribute("payment", existingPayment);
        dispatcher.forward(request, response);
    }

    private void insertPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
        Payment newPayment = new Payment(studentId, amount, date);
        paymentService.addPayment(newPayment);
        response.sendRedirect("payments");
    }

    private void updatePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
        Payment payment = new Payment(studentId, amount, date);
        payment.setId(id);
        paymentService.updatePayment(payment);
        response.sendRedirect("payments");
    }

    private void deletePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        paymentService.deletePayment(id);
        response.sendRedirect("payments");
    }

    private void listPayments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 try {
             List<Payment> payments = paymentService.getAllPayments(); 
             request.setAttribute("listPayments", payments);
             RequestDispatcher dispatcher = request.getRequestDispatcher("payment-list.jsp");
             dispatcher.forward(request, response);
	    	 } catch (Exception e) {
	             throw new ServletException("Error retrieving payments", e);
	         }
    }
}
