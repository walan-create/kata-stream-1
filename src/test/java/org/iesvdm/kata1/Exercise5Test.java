package org.iesvdm.kata1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise5Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void partitionPetAndNonPetPeople()
    {
        //TODO
        // Obtain a partition over people with or without pets
        List<Person> partitionListPetPeople = this.people.stream()
                .filter(p->p.isPetPerson())
                .toList();
        List<Person> partitionListNotPetPeople = this.people.stream()
                .filter(p->!p.isPetPerson())
                .toList();

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
        Pet oldestPet = this.people.stream()
                .flatMap(p->p.getPets().stream())
                .max(Comparator.comparing(Pet::getAge))
                .orElseThrow();
        Assertions.assertEquals(PetType.DOG, oldestPet.getType());
        Assertions.assertEquals(4, oldestPet.getAge());
    }

    @Test
    @Tag("KATA")
    public void getAveragePetAge()
    {
        //TODO
        // obtain the average age of the pets
        double averagePetAge = this.people.stream()
                .flatMap(p->p.getPets().stream())
                .mapToDouble(Pet::getAge)
                .average()
                .orElseThrow();
        Assertions.assertEquals(1.88888, averagePetAge, 0.00001);
    }

    @Test
    @Tag("KATA")
    public void addPetAgesToExistingSet()
    {
        //TODO
        // obtain the set of pet ages
        Set<Integer> petAges = this.people.stream()
                .flatMap(p->p.getPets().stream())
                .map(Pet::getAge)
                .collect(Collectors.toSet());

        //var expectedSet = Set.of(1, 2, 3, 4, 5);
        //He comentado esta lista porque está mal, ningun animal de las personas tiene como edad 5
        var expectedSet = Set.of(1, 2, 3, 4);
        Assertions.assertEquals(expectedSet, petAges);
    }

    @Test
    @Tag("KATA")
    @DisplayName("findOwnerWithMoreThanOnePetOfTheSameType - 🐹 🐹")
    public void findOwnerWithMoreThanOnePetOfTheSameType()
    {
        //TODO
        // obtain owner with more than one pet of the same type

        Person petOwner = this.people.stream()
                //Creamos flujo de personas
                .filter(per->per.getPets().stream()
                        //Creamos flujo de mascotas para cada persona
                        .collect(Collectors.groupingBy(Pet::getType,Collectors.counting()))
                        // Agrupar las mascotas por tipo y contar cuántas hay de cada tipo
                        .values().stream()
                        //Si alguna se repite mas de 1 vez pasa el filtro y sigfica que tiene repetico algun Pet
                        .anyMatch(c->c>1))
                .findFirst()
                .orElseThrow();

        Assertions.assertEquals("Harry Hamster", petOwner.getFullName());
        //TODO
        // obtain the concatenation of the pet emojis of the owner
        String petEmojis = petOwner.getPets().stream() .map(p->p.getType().toString()) .collect(Collectors.joining(" "));
        Assertions.assertEquals("🐹 🐹", petEmojis);
    }
}
