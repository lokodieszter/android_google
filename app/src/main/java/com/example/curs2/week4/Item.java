package com.example.curs2.week4;

public class Item {
    private final String firstName;
    private final String lastName;

    public Item(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
