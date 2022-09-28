package dds.tp.carbono.entities.organization.notifications;

import lombok.Getter;
import lombok.Setter;

public class MensajeRecomendaciones implements Mensaje{

    @Getter @Setter private String link;

    @Override
    public String contenido() {
        return "Aqui podra acceder a las recomendaciones para reducir su huella de carbono:" + this.getLink();
    }

  

    
    
}
