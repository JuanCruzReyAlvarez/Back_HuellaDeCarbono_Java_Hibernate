package dds.tp.carbono.http.controllers.org;


import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.notifications.Contacts;

//import java.util.Collections;
import dds.tp.carbono.http.dto.org.ContactsDTO;

import dds.tp.carbono.http.controllers.Controller;



import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.ContactsService;
import spark.Request;
import spark.Response;
import spark.Spark;

public class ContactsController extends Controller {
        
    private ContactsService service;

    public ContactsController(ContactsService contactsService) {
        this.service = contactsService;
    }


    @Override
    public void routes( ) {

        Spark.get(path(Uri.CONTACTS), (rq, rs) -> this.contacts(rq, rs));
        Spark.post(path(Uri.CONTACTS), (rq, rs) -> this.getContacts(rq, rs));
    }



    private String contacts(Request rq, Response rs) throws Exception {

        ContactsDTO input = getBody(rq, ContactsDTO.class, null);

        try {
            Contacts contact = service.obtenerContacto(input.getNombre(), input.getEmail(), input.getCelular());
            return json(contact);

        } catch (Exception ex) {
           
            throw new Exception("error añadiendo nuevo contacto ");
        }
    }

     
    private String  getContacts(Request rq, Response rs) throws Exception {
        try{
                List<Contacts> organizaciones = service.getAll();

                 List<ContactsDTO> listaDTO = new ArrayList<ContactsDTO>();
                List<Contacts> contactos = service.getAll();   

                for (Contacts contact:contactos)
                {
                    ContactsDTO obj= new ContactsDTO();
                               
                    obj.setNombre(contact.getName());
                    obj.setEmail(contact.getMail());
                    obj.setCelular(contact.getCelular());

                    listaDTO.add(obj);
                }
            
               
                System.out.println("Hola2");

                return json(listaDTO); 

            }catch(Exception exc){
                throw new Exception("In catch Exception geting Contacts was fail: ");
            }  
    }
}