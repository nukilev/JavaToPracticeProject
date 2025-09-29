package com.example.demo.service;
import com.example.demo.repository.GreetingRepository;
import com.example.demo.model.Greeting;
import org.springframework.stereotype.Service;

@Service // 1. מצהיר שזו מחלקת Service (יפעל כ-Bean ב-DI)
public class GreetingService {
    //
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    // שימו לב ללוגיקה המעודכנת
    public String prepareGreeting(String name) {


        String languageCode = name.toUpperCase();

        // 1. קריאה ל-DB באמצעות ה-Repository
        // השיטה findByLanguage מחפשת את קוד השפה ב-DB (EN, ES)
        Greeting found = greetingRepository.findByLanguage(languageCode);

        if (found != null) {
            // 2. אם נמצאה רשומה, מחזירים את ההודעה מה-DB
            return found.getMessage() + ", " + name.toUpperCase() + "! (From DB)";
        }

        // 3. לוגיקת ברירת מחדל אם לא נמצאה התאמה
        return "Service says: Hello, " + name.toUpperCase() + "! (DB Fallback)";
    }
}