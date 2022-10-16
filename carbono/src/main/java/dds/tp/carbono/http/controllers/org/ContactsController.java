package dds.tp.carbono.http.controllers.org;

import dds.tp.carbono.entities.organization.notifications.Contacts;

//import java.util.Collections;
import dds.tp.carbono.http.dto.org.contactsDTO;

import dds.tp.carbono.http.controllers.Controller;


import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.ContactsService;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class ContactsController extends Controller {
        
    private ContactsService service;

    public ContactsController(ContactsService contactsService) {
        this.service = contactsService;
    }

    static void enableCORS() {

        Spark.options("/*",
        (request, response) -> {

            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });

        Spark.before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
    }


    @Override
    public void routes(TemplateEngine engine) {

        Spark.post(path(Uri.CONTACTS), (rq, rs) -> this.contacts(rq, rs));
    }



    private String contacts(Request rq, Response rs) throws Exception {

        contactsDTO input = getBody(rq, contactsDTO.class, null);

        


        try {
            Contacts contact = service.obtenerContacto(input.getNombre(), input.getEmail(), input.getCelular());
            
            return json(contact);
            
            

        } catch (Exception ex) {
           
            throw new Exception("error añadiendo nuevo contacto ");
        }
    }
}