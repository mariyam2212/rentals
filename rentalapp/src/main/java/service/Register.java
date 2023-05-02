package service;

import commons.RequestStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register implements RequestStrategy {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        if (validateRegistration(request, response)) {

        }
    }

    private boolean validateRegistration(HttpServletRequest request, HttpServletResponse response) {
        
        return false;
    }
}
