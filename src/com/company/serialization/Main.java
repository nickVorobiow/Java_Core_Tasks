package com.company.serialization;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        final String path = "/Users/Никита/projects/java_core_tasks/resources/test_serialize_person.txt";

        Person person = new Person("Nick", 21, null);

        System.out.println("Initial person: " + person + "\r\n");


        try {
            PersonUtility.serialize(person, path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person loadedPerson = null;
        try {
            loadedPerson = PersonUtility.deserialize(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded person from file: " + loadedPerson + "\r\n");
    }

}
