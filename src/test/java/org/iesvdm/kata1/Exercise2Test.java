package org.iesvdm.kata1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Function;

public class Exercise2Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    @DisplayName("doAnyPeopleHaveCats 🐱?")
    public void doAnyPeopleHaveCats()
    {
        Predicate<Person> predicate = null; //replace null with a Predicate lambda which checks for PetType.CAT
        Assertions.assertTrue(this.people.anySatisfy(predicate));
    }

    @Test
    @Tag("KATA")
    public void doAllPeopleHavePets()
    {
        Predicate<Person> predicate = Person::isPetPerson;
        boolean result = true; //replace with a method call send to this.people that checks if all people have pets
        Assertions.assertFalse(result);
    }

    @Test
    @Tag("KATA")
    @DisplayName("howManyPeopleHaveCats 🐱?")
    public void howManyPeopleHaveCats()
    {
        int count = 0;
        Assertions.assertEquals(2, count);
    }

    @Test
    @Tag("KATA")
    public void findMarySmith()
    {
        Person result = null;
        Assertions.assertEquals("Mary", result.getFirstName());
        Assertions.assertEquals("Smith", result.getLastName());
    }

    @Test
    @Tag("KATA")
    @DisplayName("findPetNamedSerpy 🐍")
    public void findPetNamedSerpy()
    {
        List<Pet> petList = null; //transform this into a list of pets from people

        //Hint:: Use a short circuit pattern to detect pet named Serpy
        Pet serpySnake = null;

        Assertions.assertEquals("🐍",serpySnake.getType().toString());
    }

    @Test
    @Tag("KATA")
    public void getPeopleWithPets()
    {
        List<Person> petPeople = this.people; // replace with only the pet owners
        Assertions.assertEquals(7, petPeople.size());
    }

    @Test
    @Tag("KATA")
    public void getAllPetTypesOfAllPeople()
    {
        Function<Person, Iterable<PetType>> function = Person::getPetTypes;
        Set<PetType> petTypes = null;

        var expectedSet = Set.of(PetType.CAT, PetType.DOG, PetType.TURTLE, PetType.HAMSTER, PetType.BIRD, PetType.SNAKE);
        Assertions.assertEquals(expectedSet, petTypes);
    }

    @Test
    @Tag("KATA")
    public void getAllPetEmojisOfAllPeople()
    {
        Function<Person, Iterable<String>> function = Person::getPetEmojis;
        Set<String> petEmojis = null;

        var expected = Set.of("🐱", "🐶", "🐢", "🐹", "🐦", "🐍");
        Assertions.assertEquals(expected, petEmojis);
    }

    @Test
    @Tag("KATA")
    public void getFirstNamesOfAllPeople()
    {
        List<String> firstNames = null;  // Transform this.people into a list of first names

        var expectedList = List.of("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
        Assertions.assertEquals(expectedList, firstNames);
    }

    @Test
    @Tag("KATA")
    @DisplayName("doAnyPeopleHaveCatsRefactor 🐱?")
    public void doAnyPeopleHaveCatsRefactor()
    {
        boolean peopleHaveCatsLambda = this.people.stream().anyMatch(person -> person.hasPet(PetType.CAT));
        Assertions.assertTrue(peopleHaveCatsLambda);

        //use method reference, NOT lambdas, to solve the problem below
        boolean peopleHaveCatsMethodRef = false;
        Assertions.assertTrue(peopleHaveCatsMethodRef);
    }

    @Test
    @Tag("KATA")
    @DisplayName("doAllPeopleHaveCatsRefactor 🐱?")
    public void doAllPeopleHaveCatsRefactor()
    {
        boolean peopleHaveCatsLambda = this.people.stream().allMatch(person -> person.hasPet(PetType.CAT));
        Assertions.assertFalse(peopleHaveCatsLambda);

        //use method reference, NOT lambdas, to solve the problem below, is it possible?
        //boolean peopleHaveCatsMethodRef = true;
        //Assertions.assertFalse(peopleHaveCatsMethodRef);
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithCatsRefactor 🐱?")
    public void getPeopleWithCatsRefactor()
    {
        //use method reference, NOT lambdas, to solve the problem below
        List<Person> peopleWithCatsMethodRef = null;
        Assertions.assertEquals(2, peopleWithCatsMethodRef.size());
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithoutCatsRefactor 🐱?")
    public void getPeopleWithoutCatsRefactor()
    {
        //use method reference, NOT lambdas, to solve the problem below
        List<Person> peopleWithoutCatsMethodRef = null;
        Assertions.assertEquals(6, peopleWithoutCatsMethodRef.size());
    }
}
