package dds.tp.carbono.http.controllers.org;

import java.util.List;

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

public class contactsListControler extends Controller {
    
    //chequear si se puede juntar con el otro controller 

    private ContactsService service;

    public contactsListControler (ContactsService contactsService) {
        this.service = contactsService;
    }


    @Override
    public void routes(TemplateEngine engine) {

        Spark.post(path(Uri.CONTACTS), (rq, rs) -> this.getContacts(rq, rs));
    }



    private String  getContacts(Request rq, Response rs) throws Exception {
        try{
                List<Contacts> organizaciones = service.getAll();            
                return json(organizaciones); 
            }catch(Exception exc){
                throw new Exception("In catch Exception geting Contacts was fail: ");
            }  
    }
}

