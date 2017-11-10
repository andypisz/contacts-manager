package com.fredericboisguerin.insa;

public class ContactsManager {

    private String name;
    //private String email;
    //private String phoneNumber;


    public void addContact(String name, String email, String phoneNumber) {
        this.name = name;
        //this.email = email;
        //this.phoneNumber = phoneNumber;
    }

    public void printAllContacts() {
        System.out.println(this.name);
    }

    public void searchContactByName(String name) {

    }
}
