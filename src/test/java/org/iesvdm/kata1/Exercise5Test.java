package org.iesvdm.kata1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Exercise5Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void partitionPetAndNonPetPeople()
    {
        //TODO
        // Obtain a partition over people with or without pets
        List<Person> partitionListPetPeople = new ArrayList<>();
        List<Person> partitionListNotPetPeople = new ArrayList<>();

        Assertions.assertEquals(7, partitionListPetPeople.size());
        Assertions.assertEquals(1, partitionListNotPetPeople.size());
    }

    @Test
    @Tag("KATA")
    @DisplayName("getOldestPet - 🐶")
    public void getOldestPet()
    {
        //TODO
        // obtain the oldest pet
        Pet oldestPet = new Pet(PetType.HAMSTER, "", 0);
        Assertions.assertEquals(PetType.DOG, oldestPet.getType());
        Assertions.assertEquals(4, oldestPet.getAge());
    }

    @Test
    @Tag("KATA")
    public void getAveragePetAge()
    {
        //TODO
        // obtain the average age of the pets
        double averagePetAge = 0;
        Assertions.assertEquals(1.88888, averagePetAge, 0.00001);
    }

    @Test
    @Tag("KATA")
    public void addPetAgesToExistingSet()
    {
        //TODO
        // obtain the set of pet ages
        Set<Integer> petAges = Set.of(0);

        var expectedSet = Set.of(1, 2, 3, 4, 5);
        Assertions.assertEquals(expectedSet, petAges);
    }

    @Test
    @Tag("KATA")
    @DisplayName("findOwnerWithMoreThanOnePetOfTheSameType - 🐹 🐹")
    public void findOwnerWithMoreThanOnePetOfTheSameType()
    {
        //TODO
        // obtain owner with more than one pet of the same type
        Person petOwner = new Person("", "");

        Assertions.assertEquals("Harry Hamster", petOwner.getFullName());
        //TODO
        // obtain the concatenation of the pet emojis of the owner
        Assertions.assertEquals("🐹 🐹", "");
    }
}
