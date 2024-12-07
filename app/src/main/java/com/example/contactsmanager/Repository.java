package com.example.contactsmanager;

import java.util.List;

public class Repository {

    // The Available Data Sources:
    // -ROOM Database

    private final ContactDAO contactDAO;

    public Repository(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    //Methods in DAO being executed from Repository
    public void addContact(Contacts contact){
        contactDAO.insert(contact);
    }

    public void deleteContact(Contacts contact){
        contactDAO.delete(contact);
    }

    public List<Contacts> getAllContacts(){
        return contactDAO.getAllContacts();
    }

}
