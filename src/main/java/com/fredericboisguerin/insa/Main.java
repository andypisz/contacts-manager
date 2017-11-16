package com.fredericboisguerin.insa;

public class Main {

    public static void main(String[] args) throws InvalidEmailException, InvalidContactNameException{
        ContactsManager monContactsManager = new ContactsManager();
        InterfaceUtilisateur monInterface = new InterfaceUtilisateur(monContactsManager);
    }
}
