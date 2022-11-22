package dds.tp.carbono.http.controllers.auth;

//import java.net.http.HttpClient.Redirect;
import java.util.Collections;
import java.util.Map;

//import dds.tp.carbono.entities.auth.Rol;

//import java.util.Collections;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.auth.LoginDTO;
import dds.tp.carbono.http.dto.validators.LoginDTOValidator;
//import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.SessionCookie;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.auth.LoginService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
//import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class LoginController extends Controller {
    //TemplateEngine engine; 
    HandlebarsTemplateEngine engineTemplate = new HandlebarsTemplateEngine();
    private static final String LOGIN_VIEW = "auth/login.html";
    //private static final String RECOMEND_VIEW = "auth/login.html";
   
    private static final String UNAUTHORIZED_MESSAGE = "Usuario o Password invalido";
    private static final String TOKEN_COOKIE_NAME = "CARBONO-TOKEN";
    
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    
    @Override
    public void routes( ) {
        //Spark.get(path(Uri.LOGIN), (rq, rs) -> this.loginView(rq, rs), engine);
        System.out.println("la estoy mappeando");
        Spark.post(path(Uri.LOGINRECOMEND), (rq, rs) -> this.mostrar(rq, rs), engineTemplate);
        //Spark.post("/loginn", (rq, rs) -> this.loginn(rq, rs));
        Spark.post(path(Uri.LOGIN), (rq, rs) -> this.login(rq, rs));
    }

    public ModelAndView mostrar(Request req, Response res) {
        return view("miembro-organizacion-recomendaciones.hbs");
    }




    public String login(Request request, Response response) throws Exception {

        try {
            
            
            LoginDTO logger = getBody(request, LoginDTO.class, new LoginDTOValidator());
                    // La rq llego y la mandamos con un validador a get body que es un metodo de la clase PADRE PADRE  de los contorladores
                    // este metodo decodifica el json con GSON y obtenemos los valores en una clase LoginDTO, una vez q tenemos esa clase y 
                    //la data ahi. Y una vez q esta eso, usamos el validador que pasamos para verificar que no haya ni contraseña y username
                    // null ni empty.

            System.out.println(logger.getUsername());
            System.out.println(logger.getPassword());


           
            SessionCookie session = loginService.login(logger.getUsername(), logger.getPassword());

     

            response.cookie(TOKEN_COOKIE_NAME, session.getToken());


           // return session ;               hay que devlver esto 

            System.out.println(session.getUser().getUsername());

            return json(session);

           // redirectDefault(response, session);
            
        } 
        
        
        catch (Exception ex) {
            System.out.println("Error MODEL AND VIEW LOGIN");
            System.out.println("UNAUTHORIZED_MESSAGE");
            System.out.println("catchio error");

            //return view(LOGIN_VIEW, Collections.singletonMap("error", UNAUTHORIZED_MESSAGE)); //
            
        }

        return null;
    }
 
   /* private ModelAndView loginView(Request request, Response response) {
        try {
            String token = request.cookie(TOKEN_COOKIE_NAME);
            
            if (token == null)
                return view(LOGIN_VIEW);
            
            //redirectDefault(response, new SessionCookie(token));

        } catch (Exception ex) {            
            return view(LOGIN_VIEW);
        }

        return null;
    }*/

    public ModelAndView loginn(Request request, Response response) throws Exception {
        
        try {

            System.out.println("entroaltry");
            
            Map<String, String> input = formFields(request);
            
            System.out.println("segundotry");

            System.out.println(input.get("username"));
            System.out.println(input.get("password"));
            
            LoginDTO login = validateInput(
                new LoginDTO(input.get("username"), input.get("password")),
                new LoginDTOValidator());


                System.out.println("1");

            SessionCookie session = loginService.login(login.getUsername(), login.getPassword());

            response.cookie(TOKEN_COOKIE_NAME, session.getToken());

            System.out.println("2");

            //redirectDefault(response, session);
        } 
        
        
        catch (Exception ex) {
            System.out.println("sientreaca");
            return view(LOGIN_VIEW, Collections.singletonMap("error", UNAUTHORIZED_MESSAGE));
        }

        return null;
    }

 /* 
    private void redirectDefault(Response response, SessionCookie session) throws HttpException {
        Rol rol = session.getUser().getRol();
        Uri uri = Redirect.defaultUriByRol(rol);
        response.redirect(path(uri));
    }
*/


}
