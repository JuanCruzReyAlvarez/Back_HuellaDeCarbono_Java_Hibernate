package dds.tp.carbono.http.controllers.auth;

import java.util.Collections;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.exception.InsecurePasswordException;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.auth.RegisterDTO;
import dds.tp.carbono.http.dto.validators.RegisterDTOValidator;
import dds.tp.carbono.http.exceptions.BadResquestException;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.auth.RegisterService;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class RegisterController extends Controller {
    private static final String REGISTER_VIEW = "auth/register.html";
    private static final String PASSWORD_FIELD_NAME = "password";
    private static final String INSECURE_PASSWORD_MESSAGE = "The Password Is Insecure";

    private RegisterService service;
    
    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @Override
    public void routes(TemplateEngine engine) {
        Spark.get(path(Uri.REGISTER), (rq, rs) -> view(REGISTER_VIEW), engine);
        Spark.post(path(Uri.REGISTER), (rq, rs) -> this.register(rq, rs));
    }

    private String register(Request rq, Response rs) throws HttpException {

        RegisterDTO input = getBody(rq, RegisterDTO.class, new RegisterDTOValidator());

        try {
            Usuario usuario = service.register(input.getUsername(), input.getPassword(), input.getRol());
            return json(usuario);
        } catch (InsecurePasswordException ex) {
            throw new BadResquestException(Collections.singletonMap(PASSWORD_FIELD_NAME, INSECURE_PASSWORD_MESSAGE));
        }
    }
}