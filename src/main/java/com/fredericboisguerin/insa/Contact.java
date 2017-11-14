package com.fredericboisguerin.insa;

public class Contact {

    private String name;
    private String email;
    private String phoneNumber;

    public Contact(String name, String email, String phoneNumber) throws InvalidContactNameException{

        if (name == null){
            throw new InvalidContactNameException();
        }
        else{
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {


        if (this.email == null && this.phoneNumber != null){
            return this.name+", "+this.phoneNumber;
        }
        else if (this.email != null && this.phoneNumber == null){
            return this.name+", "+this.email;
        }
        else if (this.email == null && this.phoneNumber == null){
            return this.name;
        }
        else{
            return this.name+", "+this.email+", "+this.phoneNumber;
        }



    }
}
