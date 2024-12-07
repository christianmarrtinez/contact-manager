package com.example.contactsmanager;

import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    // The Available Data Sources:
    // -ROOM Database

    private final ContactDAO contactDAO;
    ExecutorService executor;
    Handler handler;

    public Repository(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;

        //USed for Background Database Operations
        executor = Executors.newSingleThreadExecutor();

        //Used for updating the UI
        handler = new Handler(Looper.getMainLooper());
    }

    //Methods in DAO being executed from Repository
    public void addContact(Contacts contact){


        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contact);
            }
        });

    }




    public void deleteContact(Contacts contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });


    }

    public List<Contacts> getAllContacts(){
        return contactDAO.getAllContacts();
    }



}
