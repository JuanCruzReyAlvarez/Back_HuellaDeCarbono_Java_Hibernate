package dds.tp.carbono.http.exceptions;

import org.eclipse.jetty.http.HttpStatus;

public class UnauthorizedException extends HttpException {

    public UnauthorizedException(Object response) {
        super(HttpStatus.UNAUTHORIZED_401, response);
    }
}
    