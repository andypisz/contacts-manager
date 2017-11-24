package com.fredericboisguerin.insa;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

public class InterfaceUtilisisateurMust {

    private static final String NICOLE_FERRONI_NAME = "Nicole Ferroni";
    private static final String NICOLE_FERRONI_EMAIL = "contact@nicoleferroni.fr";
    private static final String NICOLE_FERRONI_PHONE_NUMBER = "0651387945";
    private static final String NICOLE_FERRONI_NAME_SHORT = "ferro";

    private static final int ADD_CONTACT_USER_CHOICE = 1;
    private static final int SHOW_CONTACTS_USER_CHOICE = 2;
    private static final int SEARCH_CONTACT_USER_CHOICE = 3;
    private static final int LEAVE_USER_CHOICE = 0;

    @Test
    public void add_a_contact() throws InvalidEmailException, InvalidContactNameException {
        ContactsManager manager = mock(ContactsManager.class);
        String interaction = ADD_CONTACT_USER_CHOICE+"\n"+NICOLE_FERRONI_NAME+"\n"+NICOLE_FERRONI_EMAIL+"\n"+NICOLE_FERRONI_PHONE_NUMBER+"\n"+LEAVE_USER_CHOICE+"\n";
        System.setIn(new ByteArrayInputStream(interaction.getBytes()));
        new InterfaceUtilisateur(manager);
        verify(manager).addContact(NICOLE_FERRONI_NAME, NICOLE_FERRONI_EMAIL, NICOLE_FERRONI_PHONE_NUMBER);
        verifyNoMoreInteractions(manager);
    }

    @Test
    public void print_all_contacts() throws InvalidEmailException, InvalidContactNameException {
        ContactsManager manager = mock(ContactsManager.class);
        String interaction = SHOW_CONTACTS_USER_CHOICE+"\n"+LEAVE_USER_CHOICE+"\n";
        System.setIn(new ByteArrayInputStream(interaction.getBytes()));
        new InterfaceUtilisateur(manager);
        verify(manager).printAllContacts();
        verifyNoMoreInteractions(manager);
    }

    @Test
    public void search_contact() throws InvalidEmailException, InvalidContactNameException {
        ContactsManager manager = mock(ContactsManager.class);
        String interaction = SEARCH_CONTACT_USER_CHOICE+"\n"+NICOLE_FERRONI_NAME_SHORT+"\n"+LEAVE_USER_CHOICE+"\n";
        System.setIn((new ByteArrayInputStream(interaction.getBytes())));
        new InterfaceUtilisateur(manager);
        verify(manager).searchContactByName(NICOLE_FERRONI_NAME_SHORT);
        verifyNoMoreInteractions(manager);
    }
}
