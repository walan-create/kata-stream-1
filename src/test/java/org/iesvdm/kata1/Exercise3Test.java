package org.iesvdm.kata1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Exercise3Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void getCountsByPetEmojis()
    {
        //TODO
        // Obtain petTypes from people
        List<PetType> petTypes =  this.people.stream()
                .flatMap(p->p.getPets().stream())
                .map(Pet::getType)
                .toList();

        Map<String, Long> petEmojiCounts = petTypes.stream()
                //IMPORTANTE con el groupBy devolvemos un mapa de un String, en este caso el PetType transformado
                // y despues un Long que sacamos con el metodo counting que cuenta todos los elementos de la lista
                .collect(Collectors.groupingBy(PetType::toString, Collectors.counting()));

        var expectedMap = Map.of("🐱", 2L, "🐶", 2L, "🐹", 2L, "🐍", 1L, "🐢", 1L, "🐦", 1L);
        Assertions.assertEquals(expectedMap, petEmojiCounts);

    }

    @Test
    @Tag("KATA")
    public void getPeopleByLastName()
    {
        //TODO
        // Replace by stream the previous pattern
        Map<String, List<Person>> lastNamesToPeople2 = this.people.stream()
                //Lo mismo que en el ejercicio que he hecho antes pero esta vez devuelvo directamente la lista, no un Long
                .collect(Collectors.groupingBy(Person::getLastName, Collectors.toList()));
        Assertions.assertEquals(3, lastNamesToPeople2.get("Smith").size());
    }

    @Test
    @Tag("KATA")
    public void getPeopleByTheirPetTypes()
    {
        //TODO
        // Replace by stream
        Map<PetType, Set<Person>> peopleByPetType2 = this.people.stream()
                //Convierto el flujo de personas a los Pets que tienen
                .flatMap(person->person.getPets().stream()
                        //Por cada Pet creo un Objeto nuevo con el PetType y el dueño
                        .map(pet->new Object(){
                            PetType petType = pet.getType();
                            Person owner=person;
                        }))
                //Agrupo para devolver un mapa
                .collect(Collectors.groupingBy(
                        o->o.petType, //Devuelvo el Map de PetType accediendo al atributo de cada Object
                        //Uso el mapping para transformar las entradas de agrupación y recolecto los owners del conjunto
                        Collectors.mapping(o1 -> o1.owner, Collectors.toSet())
                ));

        Assertions.assertEquals(2, peopleByPetType2.get(PetType.CAT).size());
        Assertions.assertEquals(2, peopleByPetType2.get(PetType.DOG).size());
        Assertions.assertEquals(1, peopleByPetType2.get(PetType.HAMSTER).size());
        Assertions.assertEquals(1, peopleByPetType2.get(PetType.TURTLE).size());
        Assertions.assertEquals(1, peopleByPetType2.get(PetType.BIRD).size());
        Assertions.assertEquals(1, peopleByPetType2.get(PetType.SNAKE).size());
    }

    @Test
    @Tag("KATA")
    public void getPeopleByTheirPetEmojis()
    {
        // TODO
        // Replace by stream
        // En este caso es casi lo mismo solo que obteniendo el valor de cadena del PetType que es el Emogi
        // Solo que en este ejercicio lo voy a hacer con Record que me han dicho que es mejor practica que instanciar un Object()
        record PetOwner(String petEmogi,Person owner) {}

        Map<String, Set<Person>> petTypesToPeople = this.people.stream()
                .flatMap(person->person.getPets().stream()
                        .map(pet-> new PetOwner(pet.getType().toString(),person)))
                .collect(Collectors.groupingBy(o->o.petEmogi,
                        Collectors.mapping(o->o.owner, Collectors.toSet())
                ));

        Assertions.assertEquals(2, petTypesToPeople.get("🐱").size());
        Assertions.assertEquals(2, petTypesToPeople.get("🐶").size());
        Assertions.assertEquals(1, petTypesToPeople.get("🐹").size());
        Assertions.assertEquals(1, petTypesToPeople.get("🐢").size());
        Assertions.assertEquals(1, petTypesToPeople.get("🐦").size());
        Assertions.assertEquals(1, petTypesToPeople.get("🐍").size());

    }
}
