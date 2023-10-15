package com.company.java8;

/**
 * поиск людей, использующих уникальные языки
 */

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));

        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);

        Set namesUsingUniqueLangs = developerStream
                .flatMap(dev -> dev.getLanguages().stream()
                        .map(lang -> new AbstractMap.SimpleEntry(dev.getName(), lang)))
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toSet())))
                .values()
                .stream()
                .filter(namesSet -> namesSet.size() == 1)
                .collect(Collectors.toSet());

        System.out.println(namesUsingUniqueLangs);
    }

}

class Developer {
    private String name;
    private List<String> languages;

    public Developer() {}

    public Developer(String name, List<String> languages) {
        this.name = name;
        this.languages = languages;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public List<String> getLanguages() {return languages;}

    public void setLanguages(List<String> languages) {this.languages = languages;}
}
