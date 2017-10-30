package com.secondhandcar.platform.service;

@Component(identifier = "upper")
public class UpperCaseComponent {
    public String doWork(String input) {
        if (input != null) {
            return input.toUpperCase();
        } else {
            return null;
        }
    }
}