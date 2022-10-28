package dds.tp.carbono.dao.org;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.organization.notifications.Contacts;

public class ContactsDao extends Dao<Contacts> {

    private static ContactsDao instance;

    public static ContactsDao getInstance() {
        if (instance == null)
            instance = new ContactsDao();

        return instance;
    }

}
