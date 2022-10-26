
package dds.tp.carbono.http.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sparkproject.jetty.http.HttpStatus;

import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.http.utils.SessionCookie;
import dds.tp.carbono.http.utils.Uri;
import spark.Spark;

public abstract class AuthorizationMiddleware extends Controller {

    private static final String FORBIDDEN_MESSAGE = "Forbidden.";
    protected static final String TOKEN_COOKIE_NAME = "CARBONO-TOKEN";
    private static final String UNAUTHORIZED_MESSAGE = "Unauthorized.";

    private List<Rol> allowedRoles;

    public AuthorizationMiddleware(Rol ...roles) {
        this.allowedRoles = new ArrayList<Rol>();
        Collections.addAll(this.allowedRoles, roles);
    }

    @Override
    protected String path(Uri uri) {
        String fullPath = super.path(uri);
        
        Spark.before(fullPath, (request, response) -> {
            String token = request.cookie(TOKEN_COOKIE_NAME);

            if (token == null)
                Spark.halt(HttpStatus.UNAUTHORIZED_401, UNAUTHORIZED_MESSAGE);

            SessionCookie cookie = getSessionCookie(token);

            if (!this.allowedRoles.contains(cookie.getUser().getRol()))
                Spark.halt(HttpStatus.FORBIDDEN_403, FORBIDDEN_MESSAGE);
        });
        
        return fullPath;
    }

    protected SessionCookie getSessionCookie(String token) {
        try {
            return new SessionCookie(token);
        } catch (Exception ex) {
            Spark.halt(HttpStatus.UNAUTHORIZED_401, UNAUTHORIZED_MESSAGE);
        }

        return null;
    }
}
