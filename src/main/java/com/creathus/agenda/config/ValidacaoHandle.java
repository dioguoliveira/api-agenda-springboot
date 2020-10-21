package com.creathus.agenda.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.creathus.agenda.dto.ValidacaoDto;

@RestControllerAdvice
public class ValidacaoHandle {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ValidacaoDto> handle(MethodArgumentNotValidException ex) {
		List<ValidacaoDto> dtoForm = new ArrayList<>();

        List<FieldError> camposErros = ex.getBindingResult().getFieldErrors();

        camposErros.forEach(e -> {
        	ValidacaoDto erro = new ValidacaoDto(e.getField(), e.getDefaultMessage());
            dtoForm.add(erro);
        });

        return dtoForm;
	}
}
