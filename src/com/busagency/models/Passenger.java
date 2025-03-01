package com.busagency.models;

enum Gender{
    MALE, FEMALE
}

public class Passenger {
    private int passengerId;
    private String name;
    private Gender gender;
    private int age;
    private String phoneNumber;

    public Passenger(int passengerId, String name, Gender gender, int age, String phoneNumber){
        this.passengerId = passengerId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getPassengerId(){
        return passengerId;
    }

    public String getName(){
        return name;
    }
    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }else {
            System.out.println("Invalid age");
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        }else {
            System.out.println("Invalid phone number");
        }
    }
}
