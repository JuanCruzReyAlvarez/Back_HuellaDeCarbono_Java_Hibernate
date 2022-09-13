package dds.tp.carbono.entities.organization.notifications;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message; 


public class Wpp implements MedioDeNotificacion {

    public static final String ACCOUNT_SID = "AC4dac9f103cb67cb978faa4d2847b6cc1"; 
    public static final String AUTH_TOKEN = "6400733f60671407d1065b2c51914814"; 

    //public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    //public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    
    @Override
    public void enviarMensaje(Mensaje mensaje, Contactable contacto) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:" + contacto.telefono()), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                mensaje.contenido())      
            .create(); 
 
        System.out.println(message.getSid()); 
    } 
}
