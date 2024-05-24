package com.iteam.model;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private int id; // Auto-incremented by the database
    private int studentId;
    private BigDecimal amount;
    private Date date;
    private String studentName;

    public Payment() {}

    public Payment(int studentId, BigDecimal amount, Date date) {
        this.studentId = studentId;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
        this.date = date;
    }
}
