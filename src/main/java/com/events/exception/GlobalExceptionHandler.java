package com.events.exception;

import com.events.models.MixedError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EventAlreadyExist.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<?> eventAlreadyExist(EventAlreadyExist exception, WebRequest request){
        ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(details,HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<MixedError> errors = new ArrayList<>();

        if(ex.getBindingResult().getFieldErrors().size()>0){
            for (FieldError allError: ex.getBindingResult().getFieldErrors()){
                MixedError mixedError = new MixedError();
                mixedError.setError(String.format("%s %s", allError.getField(),allError.getDefaultMessage()));
                mixedError.setCode(1234);
                errors.add(mixedError);
//                errors.add(new MixedError(String.format("Missing or Invalid %s", allError.getField()),1234));
            }
        }
        return buildRes(errors, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<List<MixedError>> buildRes(List<MixedError> mixedErrors, HttpStatus httpStatus){
        return new ResponseEntity<>(mixedErrors, httpStatus);
    }
    private ResponseEntity<List<MixedError>> buildRes(MixedError mixedErrors, HttpStatus httpStatus){
        return new ResponseEntity(mixedErrors, httpStatus);
    }

    @Override
    protected ResponseEntity handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        MixedError mixedError = new MixedError();
        mixedError.setError(ex.getMessage()+" For "+ex.getParameterName());
        mixedError.setCode(1234);
        return buildRes(mixedError, HttpStatus.BAD_REQUEST);

    }
}
