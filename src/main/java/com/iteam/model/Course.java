package com.iteam.model;

public class Course {
    private int id; // Auto-incremented by the database
    private String title;
    private String description;
    private int credit;

    public Course() {}

    public Course(String title, String description, int credit) {
        this.title = title;
        this.description = description;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }
    

    public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
