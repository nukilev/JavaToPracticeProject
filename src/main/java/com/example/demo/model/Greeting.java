package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// אנוטציה שמסמנת שמחלקה זו היא טבלת SQL
@Entity
public class Greeting {

    // מפתח ראשי אוטומטי
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String language;

    // קונסטרוקטור ריק נדרש על ידי JPA/Hibernate
    public Greeting() {}

    public Greeting(String message, String language) {
        this.message = message;
        this.language = language;
    }

    // getters and setters (חובה ל-JPA)
    // IntelliJ יכול ליצור אותם אוטומטית: Alt+Insert או Cmd+N
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}