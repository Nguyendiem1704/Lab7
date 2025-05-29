package com.example.lab7;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.ContactsAdapter;
import model.Contact;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;
    ContactsAdapter adapter;
    int contactCount = 0; // đếm số contact đã có

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        RecyclerView rvContacts = findViewById(R.id.rvContacts);
        Button btnAdd = findViewById(R.id.btn_add_contact);

        // Khởi tạo danh sách contact
        contacts = Contact.createContactsList(20);
        contactCount = contacts.size();

        // Thiết lập adapter cho RecyclerView
        adapter = new ContactsAdapter(contacts);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        // Xử lý thêm contact mới
        btnAdd.setOnClickListener(v -> {
            contactCount++;
            contacts.add(0, new Contact("Person " + contactCount, true));
            adapter.notifyItemInserted(0);
            rvContacts.scrollToPosition(0);
        });
    }
}
