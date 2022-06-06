package dds.tp.carbono.auth;

import org.junit.Assert;
import org.junit.Test;

import dds.tp.carbono.builder.InsecurePasswordCheckerBuilder;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.exception.InsecurePasswordException;
import dds.tp.carbono.services.auth.LoginService;
import dds.tp.carbono.services.auth.RegisterService;

public class LoginTest {

    @Test
    public void loginCheck() throws Exception {
        LoginService login = new LoginService();
        Usuario usuario = login.login("admin", "admin");
        Assert.assertNull(usuario);
    }
    
    @Test
    public void loginValido() throws Exception {
        RegisterService register = new RegisterService(new InsecurePasswordCheckerBuilder());
        
        Usuario user = register.register("admin", "Diseniodesistemas12345", "administrador");

        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

        LoginService login = new LoginService();
        Usuario usuario = login.login("admin", "Diseniodesistemas12345");

        Assert.assertEquals(user, usuario);
    }
    
    @Test
    public void weakPassword() {
        RegisterService register = new RegisterService(new InsecurePasswordCheckerBuilder());
        
        try {
            Usuario user = register.register("admin", "diseniodesistemas12345", "administrador");
            Assert.assertNotNull(user);
        } catch (InsecurePasswordException e) {
            Assert.assertTrue(true);
        }
    }
}