package com.s4r.simpleemailsender.service;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
