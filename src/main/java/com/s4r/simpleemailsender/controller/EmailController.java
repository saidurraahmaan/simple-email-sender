package com.s4r.simpleemailsender.controller;


import com.s4r.simpleemailsender.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send")
    public String showEmailForm() {
        return "send-email";
    }

    @PostMapping("/send")
    public String sendEmail(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body,
            Model model) {

        try {
            emailService.sendEmail(to, subject, body);
            model.addAttribute("message", "Email sent successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "Failed to send email.");
        }

        return "send-email";
    }
}
