package com.example.demo.repository;

import com.example.demo.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// הממשק מרחיב את JpaRepository, שמעניק לנו אוטומטית
// את כל מתודות ה-CRUD (Create, Read, Update, Delete)
@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {

    // זו שיטה מותאמת אישית: Spring Data JPA יבנה את השאילתה הזו לבד!
    Greeting findByLanguage(String language);
}