package com.fredericboisguerin.insa;

public class InvalidEmailException extends Exception {

    public InvalidEmailException(){
        System.out.println("Le mail entré est invalide");
    }
}
