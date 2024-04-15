package com.iritm.iritmservices.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@Setter @Getter
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String code = "";
	int id = 0;
    private HttpStatus httpStatus;
    private String status;
    private String description;


    public AppException() {
        super();
    }


    public AppException(String message) {
        super(message);
    }

    public AppException(String message, String status) {
        super(message);
        this.status = status;
    }

    public AppException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public AppException(String message, String status, HttpStatus httpStatus, String description) {
        super(message);
        this.status = status;
        this.httpStatus = httpStatus;
        this.description = description;
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message, String code, int id) {
        super(message);
        this.code = code;
        this.id = id;
    }

}
