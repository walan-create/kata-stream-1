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
        Pet oldestPet = null;
        Assertions.assertEquals(PetType.DOG, oldestPet.getType());
        Assertions.assertEquals(4, oldestPet.getAge());
    }

    @Test
    @Tag("KATA")
    public void getAveragePetAge()
    {
        //TODO
        double averagePetAge = 0;
        Assertions.assertEquals(1.88888, averagePetAge, 0.00001);
    }

    @Test
    @Tag("KATA")
    public void addPetAgesToExistingSet()
    {
        // Hint: Use petAges as a target collection
        Set<Integer> petAges = Set.of(5);

        //TODO

        var expectedSet = Set.of(1, 2, 3, 4, 5);
        Assertions.assertEquals(expectedSet, petAges);
    }

    @Test
    @Tag("KATA")
    @DisplayName("findOwnerWithMoreThanOnePetOfTheSameType - 🐹 🐹")
    public void findOwnerWithMoreThanOnePetOfTheSameType()
    {
        //TODO
        Person petOwner = null;

        Assertions.assertEquals("Harry Hamster", petOwner.getFullName());
        Assertions.assertEquals("🐹 🐹", ""); //TODO
    }
}
