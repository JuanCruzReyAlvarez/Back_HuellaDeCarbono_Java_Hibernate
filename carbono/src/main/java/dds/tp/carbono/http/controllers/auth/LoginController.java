package dds.tp.carbono.http.controllers.auth;

import dds.tp.carbono.contracts.services.auth.ILoginService;
import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.exceptions.ForbiddenException;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.http.validator.ValidateResult;
import dds.tp.carbono.http.validator.Validator;
import lombok.Getter;
import lombok.Setter;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class LoginController extends Controller {
    private static final String LOGIN_VIEW = "login.mustache";
    private static final String FORBIDDEN_MESSAGE = "Usuario sin roles validos";
    
    private ILoginService loginService;

    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void routes(TemplateEngine engine) {
        Spark.get(path(Uri.LOGIN), (rq, rs) -> view(LOGIN_VIEW), engine);
        Spark.post(path(Uri.LOGIN), (rq, rs) -> this.login(rq, rs));
    }

    public String login(Request request, Response response) throws HttpException {
        LoginDTO input = getBody(request, LoginDTO.class, new LoginDTOValidator());
        Usuario usuario = loginService.login(input.getUsername(), input.getPassword());
        return redirectByRol(usuario.getRol());
    }

    private String redirectByRol(Rol rol) throws HttpException {
        switch (rol) {
            case ADMINISTRADOR : return json(new AuthRedirect(path(Uri.ADMIN_ORG)));
            case MIEMBRO       : return json(new AuthRedirect(path(Uri.MEMBER_TRAYECTOS)));
            case ORGANIZACION  : return json(new AuthRedirect(path(Uri.ORG_METRICS)));
            default: throw new ForbiddenException(FORBIDDEN_MESSAGE);
        }
    }

    private class AuthRedirect {
        @Getter @Setter private String uri;
        @Getter @Setter private boolean redirect;

        public AuthRedirect(String uri) {
            this.uri = uri;
            this.redirect = true;
        }
    }

    private class LoginDTO {
        @Getter @Setter private String username;
        @Getter @Setter private String password;
    }

    private class LoginDTOValidator extends Validator<LoginDTO> {
        private static final String PASSWORD_FIELD_NAME = "password";
        private static final String USERNAME_FIELD_NAME = "username";
        private static final String REQUIRED_MESSAGE = "The %s field is required";

        @Override
        public ValidateResult validate(LoginDTO dto) {
            if (dto.getPassword() == null || dto.getPassword().isEmpty())
                addError(PASSWORD_FIELD_NAME, String.format(REQUIRED_MESSAGE, PASSWORD_FIELD_NAME));
            
            if (dto.getUsername() == null || dto.getUsername().isEmpty())
                addError(USERNAME_FIELD_NAME, String.format(REQUIRED_MESSAGE, USERNAME_FIELD_NAME));

            return this;
        }
    }
}
