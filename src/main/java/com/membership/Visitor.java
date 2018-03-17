package com.membership;

import com.github.javafaker.Faker;

public class Visitor {

    private static Visitor testVisitor;

    private String firstName;
    private String lastName;


    public Visitor() {

    }

    public static Visitor createVisitor() {

        if(testVisitor != null) {
            return testVisitor;
        }

        Faker faker = new Faker();
        String LastName = faker.name().lastName();
        Visitor visitor = new Visitor();
        visitor.firstName = faker.name().firstName();
        visitor.lastName = LastName;
        testVisitor = createVisitor();
        return testVisitor;

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
