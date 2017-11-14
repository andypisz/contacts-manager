package com.fredericboisguerin.insa;

import java.util.ArrayList;

public class ContactsManager {

    private ArrayList<Contact> listeDesManagers = new ArrayList<Contact>();


    public void addContact(String name, String email, String phoneNumber) {
        Contact contact = new Contact(name,email,phoneNumber);
        listeDesManagers.add(contact);
    }

    public void printAllContacts() {
        listeDesManagers.forEach(contact -> System.out.println(contact));
    }

    public void searchContactByName(String name) {

    }
}
