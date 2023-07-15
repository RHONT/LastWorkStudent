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

    // @ResponseStatus(value = HttpStatus.GONE,reason = "Some reason")
    // Стоит у EmployeeNotFoundException
    // но эта аннотация игнорируется, так как ExceptionHandler отлавливает это исключение и дает свою реализацию
    @ExceptionHandler({EmployeeNotFoundException.class})
    public ResponseEntity<String> test2(Exception e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);
    }

    @ExceptionHandler({TestException.class})
    // MyResponseError - самосозданный класс
    // Если укажу reson, все сломается. Выдастся стандартное сообщение
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public MyResponseError test(Exception e) {

        return new MyResponseError(e.getMessage(), HttpStatus.IM_USED);
    }
}
