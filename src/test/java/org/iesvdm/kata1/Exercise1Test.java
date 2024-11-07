package org.iesvdm.kata1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercise1Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void getFirstNamesOfAllPeople()
    {
        //TODO
        // Replace empty list firstNames with a stream transformation on people.
        //Obtengoo los nombres de todos los Person y los guardo en la lista de Strings
        List<String> firstNames = this.people.stream()
                .map(Person::getFirstName)
                .toList();

        var expectedFirstNames = Arrays.asList("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");

        Assertions.assertIterableEquals(expectedFirstNames, firstNames);
    }

    @Test
    @Tag("KATA")
    public void getNamesOfMarySmithsPets()
    {
        Optional<Person> optionalPerson = this.getPersonNamed("Mary Smith");
        List<String> names = new ArrayList<>();
        if (optionalPerson.isPresent()) {
            List<Pet> pets = optionalPerson.get().getPets();
            names=pets.stream()
                    .map(Pet::getName)
                    .toList();
            //TODO
            // Replace empty list name with a stream transformation on pets.

        }
        Assertions.assertEquals("Tabby", names.get(0)); //TODO
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithCats 🐱")
    public void getPeopleWithCats()
    {
        //TODOO
        // Replace empty list with a positive filtering stream on people
        List<Person> peopleWithCats = this.people.stream()
                .filter(per->per.hasPet(PetType.CAT))
                .toList();

        var expectedFirstNames = Arrays.asList("Smith", "Smith");

        //He tenido que hacer un stream dentro del Assertions porque supongo que el List<Person> de arriba no lo puedo sustituir
        // por un List<String> para poder comparar con expectedFirstNames que es una lista de Strings
        Assertions.assertEquals(expectedFirstNames, peopleWithCats.stream().map(Person::getLastName).toList());
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithoutCats 🐱")
    public void getPeopleWithoutCats()
    {
        //TODO
        // Replace empty list with a negative filtering stream on people
        //A diferencia de el ejercicio anterior en este he optado por cambiar el List<Person> inicial por
        // List<String> para que sea mas facil la comparacion en el Assert
        //List<Person> peopleWithoutCats = this.people.stream()
        List<String> peopleWithoutCats = this.people.stream()
                .filter(per->!per.hasPet(PetType.CAT))
                .map(Person::getLastName)
                .toList();

        var expectedFirstNames = Arrays.asList("Smith", "Snake", "Bird", "Turtle", "Hamster", "Doe");
        Assertions.assertIterableEquals(expectedFirstNames, peopleWithoutCats);
    }
}
