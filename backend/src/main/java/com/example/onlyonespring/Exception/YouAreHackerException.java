package com.example.onlyonespring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason="Sekiiiuriiityyyy hahahaha you kant häck mei applikaischen.")
public class YouAreHackerException extends RuntimeException {
}