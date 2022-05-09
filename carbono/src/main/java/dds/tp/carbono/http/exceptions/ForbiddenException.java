package dds.tp.carbono.http.exceptions;

import org.eclipse.jetty.http.HttpStatus;

public class ForbiddenException extends HttpException {

    public ForbiddenException(Object response) {
        super(HttpStatus.FORBIDDEN_403, response);
    }
}
    