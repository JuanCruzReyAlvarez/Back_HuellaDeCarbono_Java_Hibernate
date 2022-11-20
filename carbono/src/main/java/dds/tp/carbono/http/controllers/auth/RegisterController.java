package dds.tp.carbono.http.controllers.auth;

import java.util.Collections;

import dds.tp.carbono.entities.auth.Usuario;
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

public class RegisterController extends Controller {
    //private static final String REGISTER_VIEW = "auth/register.html";
    private static final String PASSWORD_FIELD_NAME = "password";
    private static final String INSECURE_PASSWORD_MESSAGE = "The Password Is Insecure";

    private RegisterService service;
    
    public RegisterController(RegisterService service) {
        this.service = service;
    }



    public static void enableCORS() {

        Spark.options("/*",
        (request, response) -> {

            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });

        Spark.before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
    }

    @Override
    public void routes() {
        RegisterController.enableCORS();

        //Spark.get(path(Uri.REGISTER), (request, response) -> {return "Hello";});

        //Spark.get(path(Uri.REGISTER), (rq, rs) -> view(REGISTER_VIEW), engine);

        Spark.post(path(Uri.REGISTER), (rq, rs) -> this.register(rq, rs));
    }

    private String register(Request rq, Response rs) throws HttpException {

        RegisterDTO input = getBody(rq, RegisterDTO.class, new RegisterDTOValidator());

        


        try {
            
            Usuario usuario = service.register(input.getUsername(), input.getPassword(), input.getRol());
            System.out.println(usuario.getUsername());
            return json(usuario);
            
            

        } catch (Exception ex) {
            System.out.println("Error por contraseña insegura");
            throw new BadResquestException(Collections.singletonMap(PASSWORD_FIELD_NAME, INSECURE_PASSWORD_MESSAGE));
        }
        
    }
}