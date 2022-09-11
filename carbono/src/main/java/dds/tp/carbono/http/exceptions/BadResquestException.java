package dds.tp.carbono.http.exceptions;

import org.eclipse.jetty.http.HttpStatus;

import lombok.Getter;

public class BadResquestException extends HttpException {
    
    @Getter Object errors;

    public BadResquestException(Object response) {
        super(HttpStatus.BAD_REQUEST_400, response);
        this.errors = response;
    }
}
