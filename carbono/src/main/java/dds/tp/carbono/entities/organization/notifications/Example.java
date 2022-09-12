package dds.tp.carbono.entities.organization.notifications;
import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 

 
 
public class Example { 
    // Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "AC4dac9f103cb67cb978faa4d2847b6cc1"; 
    public static final String AUTH_TOKEN = "db6a96a946fb4d625b029489bcefe2df"; 
 
    public static void main(String[] args) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:+5491160576056"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                "Para ver una guia de recomendaciones puede acceder aqui ")      
            .create(); 
 
        System.out.println(message.getSid()); 
    } 
}

