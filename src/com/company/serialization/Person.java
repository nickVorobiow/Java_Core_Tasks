package com.company.serialization;

import java.io.Serializable;

/*
* Создать список объектов типа "Человек" с полями имя, возраст и род деятельности.
* Данный список объектов должен быть сериализован в файл при помощи интерфейса Serializable,
* при этом поле род деятельности не должно сериализовываться - оно должно быть вычислимым.
* Соответственно при десериализации оно должно вычисляться (и заполняться в объектах) по следующему правилу:
* если человеку от 0 до 3 лет - он сидит дома,
* если человеку от 3 до 7 лет - ходит в детский сад,
* от 7 до 18 лет - учится в школе, от 17 до 23 - учится в институте,
* от 24 до 65 - работает, от 65 и выше - на пенсии.
* */

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient String occupation;

    public Person() {}

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
