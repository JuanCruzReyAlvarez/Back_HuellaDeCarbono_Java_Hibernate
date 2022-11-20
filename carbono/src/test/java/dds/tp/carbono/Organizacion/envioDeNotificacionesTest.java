/* 
package dds.tp.carbono.Organizacion;

import org.junit.Test;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.notifications.Contacts;
import dds.tp.carbono.entities.organization.notifications.MedioDeNotificacion;
import dds.tp.carbono.entities.organization.notifications.Wpp;

public class envioDeNotificacionesTest {

    @Test
    public void enviarWpp() throws Exception {
        Organizacion org = creaOrganizacion();
        org.enviarRecomendaciones();
    }

    private Organizacion creaOrganizacion(){
        Organizacion organizacion = new Organizacion();
        organizacion.org();
        MedioDeNotificacion wpp = new Wpp();
        Contacts contacto = crearContacto();
        organizacion.setMedioDeNotificacion(wpp);
        organizacion.agregarContacto(contacto);
        return organizacion;
    }

    private Contacts crearContacto(){
        Contacts contacto = new Contacts();
        contacto.setCelular("+5491160576056");
        return contacto;
    }
    
    
}
*/