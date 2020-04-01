/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import model.UserDAO;

/**
 *
 * @author Admin
 */
public class InputValidation {

    UserDAO userDAO = new UserDAO();

    public boolean isEmpty(String str_) {
        if (str_ == null || str_.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    public boolean isEmail(String email) {

        Pattern VALID_EMAIL_ADDRESS_REGEX
                = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public void addError(HttpServletRequest request, String err) {
        List<String> errors = (List<String>) request.getAttribute("errors");
        if (errors == null) {
            errors = new ArrayList<>();
        }

        errors.add(err);
    }

    public boolean validRegister(String username, String password, String email, HttpServletRequest request) throws Exception {
        List<String> errors = new ArrayList<>();

        if (isEmpty(username)) {
            errors.add("Username must not be empty!");
        } else if (userDAO.getUser(username) != null) {
            errors.add("Username is taken!");
        }

        if (isEmpty(password)) {
            errors.add("Password must not be empty!");
        }

        if (!isEmail(email)) {
            errors.add("Email is not valid!");
        }

        request.setAttribute("errors", errors);
        return errors.isEmpty();
    }

    public boolean validLogin(String username, String password, HttpServletRequest request) throws Exception {
        List<String> errors = new ArrayList<>();

        if (isEmpty(username)) {
            errors.add("Username must not be empty!");
        }

        if (isEmpty(password)) {
            errors.add("Password must not be empty!");
        }

        request.setAttribute("errors", errors);
        return errors.isEmpty();
    }

    public boolean isAnswer(String[] aws) {
        return !(aws == null || aws.length == 0);
    }

    public boolean validInputCreateQuestion(String question, String[] options, String[] aws, HttpServletRequest request) throws Exception {
        Map<String, String> e = new HashMap<>();
        
        if (isEmpty(question)) {
            e.put("question", "Question must not be empty!");
        }

        int i = 0;
        for (String option : options) {
            i++;
            if (isEmpty(option)) {
                e.put("option " + i, "Option " + i + " must not be empty!");
            }
        }
        
        if (aws == null) {
             e.put("aws", "Question doens't have answer!");
        } else if (aws.length == 4) {
            e.put("aws", "Question can't have 4 answers");
        }
        
        
        request.setAttribute("e", e);

        return e.isEmpty();
    }
    
    public boolean validInputTakeQuizNumber(int numOfQuiz, int min, int max, HttpServletRequest request) throws Exception {
        Map<String, String> e = new HashMap<>();
        if(numOfQuiz < min) {
            e.put("quiz", "Can't create quiz with number of quiz is " + numOfQuiz);
        }
        
        if(numOfQuiz > max) {
            e.put("quiz", "The max number of quiz is " + max);
        }
        
        request.setAttribute("e", e);

        return e.isEmpty();
    }
}
