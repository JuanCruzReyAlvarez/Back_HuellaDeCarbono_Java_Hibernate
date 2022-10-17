package dds.tp.carbono.services.organizacion;

import java.util.List;

import dds.tp.carbono.entities.organization.notifications.Contacts;
import dds.tp.carbono.repository.organization.ContactsRepository;


public class ContactsService {

    private ContactsRepository repository;

    public ContactsService() {
        this.repository = new ContactsRepository();
    }


    public Contacts obtenerContacto(String nombre, String email, String celular) {
        
        Contacts contacto = this.buildContacto(nombre, email, celular);
        
        return this.repository.guardar(contacto);
    }


    private Contacts buildContacto(String nombre, String email, String celular) {
        
        Contacts contacto = new Contacts();
        contacto.setCelular(celular);
        contacto.setMail(email);
        contacto.setName(celular);
        
        return null;
    }


    public List<Contacts> getAll() {
        return this.repository.getAll();
    }

}
