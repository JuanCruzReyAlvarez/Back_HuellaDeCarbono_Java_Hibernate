package dds.tp.carbono.http.exceptions;

import org.eclipse.jetty.http.HttpStatus;

public class BadResquestException extends HttpException {

    public BadResquestException(Object response) {
        super(HttpStatus.BAD_REQUEST_400, response);
    }
}
