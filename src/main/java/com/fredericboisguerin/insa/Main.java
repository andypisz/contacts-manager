package com.fredericboisguerin.insa;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InvalidEmailException, InvalidContactNameException, IOException {
        ContactsManager monContactsManager = new ContactsManager();
        Csv monCsv = new Csv(monContactsManager);

        monCsv.csvRead();

        InterfaceUtilisateur monInterface = new InterfaceUtilisateur(monContactsManager);

        monCsv.csvWrite();
    }
}
