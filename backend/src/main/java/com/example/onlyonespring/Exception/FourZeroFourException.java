package com.example.onlyonespring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Something was not found, good luck figuring out what")
public class FourZeroFourException extends RuntimeException{
}
