

package org.iesvdm.kata1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;


public class  Exercise4Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void getAgeStatisticsOfPets()
    {
        Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        var petAges = List.of(1); //TODO Replace by stream

        var uniqueAges = Set.copyOf(petAges);

        // IntSummaryStatistics is a class in JDK 8 use it over petAges
        var stats = new IntSummaryStatistics(); // TODO Replace by stream

        var expectedSet = Set.of(1, 2, 3, 4);
        Assertions.assertEquals(expectedSet, uniqueAges);

        // Try to leverage minIfEmpty, maxIfEmpty, sum, averageIfEmpty on IntList
        Assertions.assertEquals(stats.getMin(), 0); //TODO Replace 0 by stream over petAges
        Assertions.assertEquals(stats.getMax(), 0);
        Assertions.assertEquals(stats.getSum(), 0);
        Assertions.assertEquals(stats.getAverage(), 0.0, 0.0);
        Assertions.assertEquals(stats.getCount(), 0);

        // Hint: JDK xyzMatch = Eclipse Collections xyzSatisfy

        //All age > 0
        Assertions.assertTrue(false); //TODO Replace by correct stream
        //No one ages == 0
        Assertions.assertFalse(true);
        //No one age < 0
        Assertions.assertTrue(false);
    }

    @Test
    @Tag("KATA")
    @DisplayName("bobSmithsPetNamesAsString - 🐱 🐶")
    public void bobSmithsPetNamesAsString()
    {
        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");

        //find Bob Smith
        Person person = new Person();

        //get Bob Smith's pets' names
        String names = "";

        Assertions.assertEquals("Dolly & Spot", names);
    }

    @Test
    @Tag("KATA")
    public void immutablePetCountsByEmoji()
    {
        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");

        //TODO Unmodificable map of counts
        Map<String, Long> countsByEmoji = new HashMap<>();


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
    public void topThreePets()
    {
        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");

        // Hint: The result of groupingBy/counting can almost always be replaced by a Bag
        // Hint: Look for the API on Bag that might return the top 3 pet types
        var favorites = this.people
                .stream()
                .flatMap(p -> p.getPets().stream())
                .collect(Collectors.groupingBy(Pet::getType, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e -> -e.getValue()))
                .limit(3L)
                .collect(Collectors.toList());

        Verify.assertSize(3, favorites);

        // Hint: Look at PrimitiveTuples.pair(Object, int)
        Verify.assertContains(new AbstractMap.SimpleEntry<>(PetType.CAT, Long.valueOf(2)), favorites);
        Verify.assertContains(new AbstractMap.SimpleEntry<>(PetType.DOG, Long.valueOf(2)), favorites);
        Verify.assertContains(new AbstractMap.SimpleEntry<>(PetType.HAMSTER, Long.valueOf(2)), favorites);
    }

    @Test
    @Tag("KATA")
    public void getMedianOfPetAges()
    {
        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");

        // Try to use a MutableIntList here instead
        // Hints: flatMap = flatCollect, map = collect, mapToInt = collectInt
        var petAges = this.people
                .stream()
                .map(Person::getPets)
                .flatMap(List::stream)
                .mapToInt(Pet::getAge)
                .boxed()
                .collect(Collectors.toList());

        // Try to refactor the code block finding the median the JDK way
        // Use the EC median method
        var sortedPetAges = petAges.stream().sorted().collect(Collectors.toList());

        double median;
        if (0 == sortedPetAges.size() % 2)
        {
            // The median of a list of even numbers is the average of the two middle items
            median = sortedPetAges.stream().skip((sortedPetAges.size() / 2) - 1).limit(2L).mapToInt(i -> i).average().getAsDouble();
        }
        else
        {
            // The median of a list of odd numbers is the middle item
            median = sortedPetAges.get(abs(sortedPetAges.size() / 2)).doubleValue();
        }

        Assertions.assertEquals(2.0, median, 0.0);
    }
}
