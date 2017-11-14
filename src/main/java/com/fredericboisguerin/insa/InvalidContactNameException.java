package com.fredericboisguerin.insa;

public class InvalidContactNameException extends Exception {

    public InvalidContactNameException(){
        System.out.println("Le nom entré est invalide");
    }
}
