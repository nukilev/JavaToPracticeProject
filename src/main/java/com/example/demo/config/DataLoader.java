package com.example.demo.config;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component ו-CommandLineRunner אומרים ל-Spring להריץ את הקוד הזה פעם אחת בעת עליית היישום
@Component
public class DataLoader implements CommandLineRunner {

    private final GreetingRepository greetingRepository;

    // הזרקת ה-Repository (כדי שנוכל לשמור נתונים)
    public DataLoader(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // המתודה run() רצה אוטומטית לאחר שכל רכיבי Spring נטענים
    @Override
    public void run(String... args) throws Exception {
        System.out.println("---- Inserting Initial Data into H2 Database ----");

        // 1. יצירת אובייקטים
        Greeting english = new Greeting("Hello", "EN");
        Greeting spanish = new Greeting("Hola", "ES");

        // 2. שמירת הנתונים באמצעות ה-Repository
        greetingRepository.save(english);
        greetingRepository.save(spanish);

        // בדיקה והדפסה ללוג
        System.out.println("---- Initial Data Insertion Complete. Total records: " + greetingRepository.count() + " ----");
    }
}