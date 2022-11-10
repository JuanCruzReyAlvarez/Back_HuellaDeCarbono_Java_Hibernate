package dds.tp.carbono.repository.organization;

import java.util.List;

import dds.tp.carbono.dao.org.ContactsDao;
import dds.tp.carbono.entities.organization.notifications.Contacts;

public class ContactsRepository {

    private ContactsDao dao;

    public ContactsRepository() {
        this.dao = ContactsDao.getInstance();
        this.dao.setClazz(Contacts.class);
    } 

    public Contacts guardar(Contacts contacts) {
        return this.dao.save(contacts);
    }

    public List<Contacts> getAll() {
        return this.dao.getAll();
    }

}
