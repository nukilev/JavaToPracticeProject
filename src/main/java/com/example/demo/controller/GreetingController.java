package com.example.demo.controller;
import com.example.demo.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// זוהי מחלקה שמטפלת בבקשות רשת (API)
@RestController
public class GreetingController {
    // 1. הגדרת התלות: הקונטרולר צריך GreetingService
    private final GreetingService greetingService;

    // 2. הזרקת התלות דרך הקונסטרוקטור (Spring מטפל ביצירת ה-Service)
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // הפונקציה הזו מופעלת כשתגיע בקשת GET לנתיב /api/greet
    @GetMapping("/api/greet")
    public String greetUser(@RequestParam(value = "name", defaultValue = "World") String name) {

        return greetingService.prepareGreeting(name);
    }
}
