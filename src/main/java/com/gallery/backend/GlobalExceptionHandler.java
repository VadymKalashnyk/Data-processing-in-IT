package com.gallery.backend; // Змініть на вашу назву пакету!

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Каже Spring, що цей клас має слідкувати за помилками у всіх контролерах
public class GlobalExceptionHandler {

    // Перехоплює будь-які винятки (Exception)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Повертає повідомлення про помилку та статус 500 (Internal Server Error)
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}