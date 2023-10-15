package com.company.serialization;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PersonUtility {
    public static void serialize(Person person, String path) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(person);
        }
    }

    public static Person deserialize(String path) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Person person = (Person) ois.readObject();
            int age = person.getAge();

            if (age >= 0 && age <= 3) {
                person.setOccupation("сидит дома");
            }
            else if (age >= 3 && age < 7) {
                person.setOccupation("ходит в детский сад");
            } else if (age >= 7 && age < 18) {
                person.setOccupation("ходит в школу");
            } else if (age >= 18 && age <= 23) {
                person.setOccupation("учится в институте");
            } else if (age >= 24 && age < 65) {
                person.setOccupation("работает");
            } else if (age >= 65) {
                person.setOccupation("на пенсии");
            }

            return person;
        }
    }
}
