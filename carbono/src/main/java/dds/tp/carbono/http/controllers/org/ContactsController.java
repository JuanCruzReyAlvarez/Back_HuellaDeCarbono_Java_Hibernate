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

        Spark.post(path(Uri.ADD_CONTACTS), (rq, rs) -> this.addContacts(rq, rs));
        Spark.get(path(Uri.CONTACTS), (rq, rs) -> this.getContacts(rq, rs));
    }



    private String addContacts(Request rq, Response rs) throws Exception {

        System.out.println("HOLAAAAAAA");
        ContactsDTO input = getBody(rq, ContactsDTO.class, null);
        System.out.println("HOLAAAAAAA");

        try {
            System.out.println("HOLAAAAAAA");
            service.guardarContacto(input.getNombre(), input.getEmail(), input.getCelular(), input.getUserId());
            System.out.println("HOLAAAAAAA");
            return json(goodAnswer());

        } catch (Exception ex) {
           
            throw new Exception("error añadiendo nuevo contacto ");
        }
    }

     
    private String  getContacts(Request rq, Response rs) throws Exception {
        try{
                
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