package dds.tp.carbono.http.controllers.auth;

//import java.util.Collections;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.auth.LoginDTO;
import dds.tp.carbono.http.dto.validators.LoginDTOValidator;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.SessionCookie;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.auth.LoginService;
import spark.Request;
import spark.Response;
import spark.Spark;


public class LoginController extends Controller {
    //private static final String LOGIN_VIEW = "auth/login.html";
    //private static final String UNAUTHORIZED_MESSAGE = "Usuario o Password invalido";
    private static final String TOKEN_COOKIE_NAME = "CARBONO-TOKEN";
    
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @Override
    public void routes( ) {
        Spark.post(path(Uri.LOGIN), (rq, rs) -> this.login(rq, rs));
    }



    public String login(Request request, Response response) throws HttpException {

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
/* 
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
*/
/* 
    private void redirectDefault(Response response, SessionCookie session) throws HttpException {
        Rol rol = session.getUser().getRol();
        Uri uri = Redirect.defaultUriByRol(rol);
        response.redirect(path(uri));
    }

*/

}
