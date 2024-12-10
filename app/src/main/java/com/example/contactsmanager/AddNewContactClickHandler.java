package com.example.contactsmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Contacts contact;
    Context context;

    public AddNewContactClickHandler(Contacts contact, Context context) {
        this.contact = contact;
        this.context = context;
    }

    public void onSubmitBtnClicked(View view){
        if (contact.getName() == null || contact.getEmail() == null){
            Toast.makeText(context,"Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(context,MainActivity.class);
            i.putExtra("Name",contact.getName());
            i.putExtra("Email",contact.getEmail());
            context.startActivity(i);
        }
    }
}
