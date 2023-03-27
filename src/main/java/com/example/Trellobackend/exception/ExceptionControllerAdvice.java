package com.example.Trellobackend.exception;

import com.example.Trellobackend.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = BoardNotFoundException.class)
    public final ResponseEntity<ApiResponse> handleBoardNotFoundException(BoardNotFoundException boardNotFoundException) {
        return new ResponseEntity<>(new ApiResponse(0, boardNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TListNotFoundException.class)
    public final ResponseEntity<ApiResponse> handleTListNotFoundException(TListNotFoundException tListNotFoundException) {
        return new ResponseEntity<>(new ApiResponse(0, tListNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CardNotFoundException.class)
    public final ResponseEntity<ApiResponse> handleCardNotFoundException(CardNotFoundException cardNotFoundException) {
        return new ResponseEntity<>(new ApiResponse(0, cardNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
