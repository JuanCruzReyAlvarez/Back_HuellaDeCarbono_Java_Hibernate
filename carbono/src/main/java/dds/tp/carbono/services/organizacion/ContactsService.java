package dds.tp.carbono.services.organizacion;

import java.util.List;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.notifications.Contacts;
import dds.tp.carbono.repository.organization.ContactsRepository;
import dds.tp.carbono.repository.organization.OrganizacionRepository;


public class ContactsService {

    private ContactsRepository repository;

    public ContactsService() {
        this.repository = new ContactsRepository();
    }


    public Contacts guardarContacto(String nombre, String email, String celular, String user) {
        
        Contacts contacto = this.buildContacto(nombre, email, celular, user);

        OrganizacionRepository orgService = new OrganizacionRepository();
        Organizacion organizacion = new Organizacion();
        
        organizacion = orgService.getByUser(Integer.parseInt(user));
        contacto.setOrganizacion(organizacion);

        return this.repository.guardar(contacto);
    }


    public Contacts buildContacto(String nombre, String email, String celular, String user) {
        
        Contacts contacto = new Contacts();
        contacto.setName(nombre);
        contacto.setCelular(celular);
        contacto.setMail(email);
        


        return contacto;
    }


    public List<Contacts> getAll() {
        return this.repository.getAll();
    }

}
