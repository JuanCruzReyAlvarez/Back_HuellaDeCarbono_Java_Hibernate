package dds.tp.carbono.entities.organization.notifications;


public interface MedioDeNotificacion {
    
    public void enviarMensaje (Mensaje mensaje, Contactable contacto);
}
