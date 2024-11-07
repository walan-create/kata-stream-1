

package org.iesvdm.kata1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;


public class  Exercise4Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void getAgeStatisticsOfPets()
    {
        //Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        //TODO
        // Replace by stream of petAges
        //List<Integer>
        var petAges = this.people.stream()
                .flatMap(p->p.getPets().stream())
                .map(Pet::getAge)
                .toList();
        //Esto elimina los repetidos
        var uniqueAges = Set.copyOf(petAges);

        var expectedSet = Set.of(1, 2, 3, 4);
        Assertions.assertEquals(expectedSet, uniqueAges);

        //TODO
        // Replace by stream
        // IntSummaryStatistics is a class in JDK 8 use it over petAges
        //IntSummaryStatistics tiene varias herramientas para interactuar con una lista de Integers como hallar el maximo, minimo, etc.
        var stats = petAges.stream()
                .collect(Collectors.summarizingInt((Integer::intValue)));

        //TODO
        // Replace 0 by stream over petAges
        Assertions.assertEquals(stats.getMin(), petAges.stream().min(Integer::compareTo).get());
        Assertions.assertEquals(stats.getMax(), petAges.stream().max(Integer::compareTo).get());
        Assertions.assertEquals(stats.getSum(), petAges.stream().mapToInt(Integer::intValue).sum());
        Assertions.assertEquals(stats.getAverage(), petAges.stream().mapToInt(Integer::intValue).average().getAsDouble());
        Assertions.assertEquals(stats.getCount(), petAges.stream().count());



        //TODO
        // Replace by correct stream
        // All age > 0
        Assertions.assertTrue(petAges.stream().allMatch(p->p>0));
        //TODO
        // No one ages == 0
        Assertions.assertFalse(petAges.stream().allMatch(p->p==0));
        //TODO
        // No one age < 0
        Assertions.assertTrue(petAges.stream().noneMatch(p->p<0));
    }

    @Test
    @Tag("KATA")
    @DisplayName("bobSmithsPetNamesAsString - 🐱 🐶")
    public void bobSmithsPetNamesAsString()
    {
        //Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        //TODO
        // find Bob Smith
        Person person = this.people.stream()
                .filter(p->p.getFullName().equalsIgnoreCase("bob smith"))
                .findFirst()
                .orElse(null);

        //TODO
        // get Bob Smith's pets' names
        String names = person.getPets().stream().map(Pet::getName).collect(Collectors.joining(" & "));
        Assertions.assertEquals("Dolly & Spot", names);
    }

    @Test
    @Tag("KATA")
    public void immutablePetCountsByEmoji()
    {
        //Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        //TODO
        // Unmodificable map of counts
        Map<String, Long> countsByEmoji = this.people.stream()
                .flatMap(p->p.getPets().stream())
                .map(p->p.getType().toString())
                .collect(Collectors.groupingBy(e->e,Collectors.counting()));

        Assertions.assertEquals(
                Map.of("🐱", 2L, "🐶", 2L, "🐹", 2L, "🐍", 1L, "🐢", 1L, "🐦", 1L),
                countsByEmoji
        );
    }

    /**
     * The purpose of this test is to determine the top 3 pet types.
     */
    @Test
    @Tag("KATA")
    @DisplayName("topThreePets - 🐱 🐶 🐹")
    public void topThreePets() {
        // Obtener las tres mascotas más populares en un solo Stream y adaptarlo a las aserciones
        var favorites = this.people.stream()
                .flatMap(p -> p.getPets().stream())
                .map(Pet::getType)
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .collect(Collectors.toList());

        Assertions.assertEquals(3, favorites.size());

        // Verificar que contiene las mascotas esperadas con sus recuentos
        Assertions.assertTrue(favorites.contains(new AbstractMap.SimpleEntry<>(PetType.CAT, 2L)));
        Assertions.assertTrue(favorites.contains(new AbstractMap.SimpleEntry<>(PetType.DOG, 2L)));
        Assertions.assertTrue(favorites.contains(new AbstractMap.SimpleEntry<>(PetType.HAMSTER, 2L)));
    }

    @Test
    @Tag("KATA")
    public void getMedianOfPetAges()
    {
        //Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        //TODO
        // Obtain pet ages
        var petAges = this.people.stream()
                .flatMap(p->p.getPets().stream()).map(Pet::getAge)
                .toList();

        //TODO
        // sort pet ages
        var sortedPetAges = petAges.stream().sorted().toList();
        //Calculo la mediana con streams

        double median;
        if (0 == sortedPetAges.size() % 2)
        {
            //TODO
            //
            // The median of a list of even numbers is the average of the two middle items
            median = 0.0;
        }
        else
        {
            // The median of a list of odd numbers is the middle item
            median = sortedPetAges.get(abs(sortedPetAges.size() / 2)).doubleValue();
        }

        Assertions.assertEquals(2.0, median, 0.0);
    }
}
