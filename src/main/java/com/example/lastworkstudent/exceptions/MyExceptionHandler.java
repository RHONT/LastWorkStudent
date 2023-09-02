package com.example.lastworkstudent.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Перехватывает все исключени по проекту.
// но если есть @ExceptionHandler внутри контроллера, то вызоветься именно оно, текущие хэндлеры будут проигнорированы
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    // MyResponseError - самосозданный класс
    // Если укажу reson, все сломается. Выдастся стандартное сообщение
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MyResponseError test(Exception e) {

        return new MyResponseError(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
