package dds.tp.carbono.http.controllers.auth;

import java.util.Collections;
import java.util.Map;

import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.auth.LoginDTO;
import dds.tp.carbono.http.dto.validators.LoginDTOValidator;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Redirect;
import dds.tp.carbono.http.utils.SessionCookie;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.auth.LoginService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class LoginController extends Controller {
    private static final String LOGIN_VIEW = "auth/login.html";
    private static final String UNAUTHORIZED_MESSAGE = "Usuario o Password invalido";
    private static final String TOKEN_COOKIE_NAME = "CARBONO-TOKEN";
    
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void routes(TemplateEngine engine) {
        Spark.get(path(Uri.LOGIN), (rq, rs) -> this.loginView(rq, rs), engine);
        Spark.post(path(Uri.LOGIN), (rq, rs) -> this.login(rq, rs), engine);
    }

    private ModelAndView loginView(Request request, Response response) {
        try {
            String token = request.cookie(TOKEN_COOKIE_NAME);
    
            if (token == null)
                return view(LOGIN_VIEW);
    
            redirectDefault(response, new SessionCookie(token));
        } catch (Exception ex) {            
            return view(LOGIN_VIEW);
        }

        return null;
    }

    public ModelAndView login(Request request, Response response) throws HttpException {
        
        try {
            Map<String, String> input = formFields(request);

            LoginDTO login = validateInput(
                new LoginDTO(input.get("username"), input.get("password")),
                new LoginDTOValidator());
            
            SessionCookie session = loginService.login(login.getUsername(), login.getPassword());
            response.cookie(TOKEN_COOKIE_NAME, session.getToken());

            redirectDefault(response, session);
        } catch (Exception ex) {
            return view(LOGIN_VIEW, Collections.singletonMap("error", UNAUTHORIZED_MESSAGE));
        }

        return null;
    }

    private void redirectDefault(Response response, SessionCookie session) throws HttpException {
        Rol rol = session.getUser().getRol();
        Uri uri = Redirect.defaultUriByRol(rol);
        response.redirect(path(uri));
    }
}
