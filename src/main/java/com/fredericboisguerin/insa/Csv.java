package com.fredericboisguerin.insa;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Csv {

    private ContactsManager cm;

    public Csv(ContactsManager cm) throws IOException, InvalidEmailException, InvalidContactNameException {
        this.cm = cm;
    }

    public void csvWrite() throws InvalidEmailException, InvalidContactNameException, IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("annuaire.csv"), '\t');

        for (Contact c : cm.getListeDesManagers()){
            String[] entries = (c.getName()+"#"+c.getEmail()+"#"+c.getPhoneNumber()).split("#");
            writer.writeNext(entries);
        }
        writer.close();
    }

    public void csvRead() throws InvalidEmailException, InvalidContactNameException, IOException {
        CSVReader reader = new CSVReader(new FileReader("annuaire.csv"), '\t');
        String [] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            String name = nextLine[0];
            String email = nextLine[1];
            String phoneNumber = nextLine[2];
            cm.addContact(name,email,phoneNumber);
        }

    }
}
