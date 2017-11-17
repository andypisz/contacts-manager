package com.fredericboisguerin.insa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUtilisateur {

    private ContactsManager cm;

    public InterfaceUtilisateur(ContactsManager cm) throws InvalidEmailException, InvalidContactNameException{
        this.cm = cm;
        int choix;

        System.out.println("***** BIENVENU DANS L'ANNUAIRE DE CONTACTS *****");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        do{
            printMenu();
            choix = getSelection(sc);
            actionApresSelectionUtilisateur(choix, sc);
        } while (choix != 0);

        sc.close();

    }

    public void printMenu(){
        System.out.println();
        System.out.println("Tapez le numéro de votre choix :");
        System.out.println();
        System.out.println("1 - Ajouter un contact à l'annuaire");
        System.out.println("2 - Afficher tous les contacts de l'annuaire");
        System.out.println("3 - Chercher un contact à l'aide de son nom");
        System.out.println("0 - Quitter");
        System.out.println();
        System.out.println("Votre choix : ");
    }

    public int getSelection(Scanner sc){
        int choix;
        try {
            choix = sc.nextInt();
            sc.nextLine(); // lire le \n apres le choix
        }catch (InputMismatchException e){
            choix = -1;
        }
        System.out.println();
        return choix;
    }

    public void actionAjouterContact(Scanner sc) throws InvalidEmailException, InvalidContactNameException {
        System.out.println("Vous avez choisi d'ajouter un contact à l'annuaire.");
        System.out.println();
        System.out.println("Veuillez entrer son nom : ");
        String nom = sc.nextLine();
        System.out.println("Veuillez entrer son email : ");
        String email = sc.nextLine();
        System.out.println("Veuillez entrer son numéro de téléphone : ");
        String phoneNumber = sc.nextLine();
        //System.out.println("nom : "+nom+", email : "+email+", phone number : "+phoneNumber);
        cm.addContact(nom,email,phoneNumber);

    }

    public void actionAfficherContacts(){
        System.out.println("Vous avez choisi d'afficher tous les contacts de l'annuaire.");
        System.out.println();
        this.cm.printAllContacts();
    }

    public void actionChercherContact(Scanner sc){
        System.out.println("Vous avez choisi de chercher un contact dans l'annuaire à l'aide de son nom.");
        System.out.println();
        System.out.println("Veuillez entrer son nom : ");
        String nom = sc.nextLine();
        cm.searchContactByName(nom);
    }

    public void actionQuitter(){
        System.out.println("Merci d'avoir utilisé notre annuaire de contacts.");
        System.out.println();
        System.out.println("***** A BIENTOT *****");
    }

    public void actionApresSelectionUtilisateur(int choixUtilisateur, Scanner sc) throws InvalidEmailException, InvalidContactNameException {
        switch (choixUtilisateur) {
            case 0 :
                actionQuitter();
                break;
            case 1 :
                actionAjouterContact(sc);
                break;
            case 2 :
                actionAfficherContacts();
                break;
            case 3 :
                actionChercherContact(sc);
                break;
            default:
                System.out.println("Veuillez choisir un chiffre entre 0 et 3.");
                System.out.println();
                break;

        }
    }
}
