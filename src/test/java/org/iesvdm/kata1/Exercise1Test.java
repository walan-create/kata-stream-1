package org.iesvdm.kata1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void getFirstNamesOfAllPeople()
    {
        // Replace null, with a transformation method on List.
        List<String> firstNames = null; // this.people...

        var expectedFirstNames = Arrays.asList("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
        Assertions.assertEquals(expectedFirstNames, firstNames);
    }

    @Test
    @Tag("KATA")
    public void getNamesOfMarySmithsPets()
    {
        Person person = this.getPersonNamed("Mary Smith");
        List<Pet> pets = person.getPets();

        // Replace null, with a transformation method on List.
        List<String> names = new ArrayList<>(); // pets...

        Assertions.assertEquals("Tabby", ""); //TODO
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithCats 🐱")
    public void getPeopleWithCats()
    {
        // Replace null, with a positive filtering method on List.
        List<Person> peopleWithCats = new ArrayList<>();  // this.people...

        var expectedFirstNames = Arrays.asList("Smith", "Smith");
        Assertions.assertEquals(expectedFirstNames, new ArrayList<>()); //TODO
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithoutCats 🐱")
    public void getPeopleWithoutCats()
    {
        //TODO
        // Replace null, with a negative filtering method on List.
        List<Person> peopleWithoutCats = new ArrayList<>();  // this.people...

        var expectedFirstNames = Arrays.asList("Smith", "Snake", "Bird", "Turtle", "Hamster", "Doe");
        Assertions.assertIterableEquals(expectedFirstNames, peopleWithoutCats);
    }
}
