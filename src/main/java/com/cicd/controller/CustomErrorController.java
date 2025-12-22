package com.cicd.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", "An error occurred");

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            errorResponse.put("status", statusCode);

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                errorResponse.put("message", "Resource not found");
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorResponse.put("message", "Internal server error");
            } else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                errorResponse.put("message", "Bad request");
            }
        }

        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf((Integer) status));
    }
}
