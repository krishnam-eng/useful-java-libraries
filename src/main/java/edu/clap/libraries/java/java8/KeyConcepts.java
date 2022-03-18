package edu.clap.libraries.java.java8;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Behavior parameterization - Ability for a method to take multiple different behaviors as
 * parameters and use them internally to accomplish different behaviors
 *
 * <p>Lambda Expressions - They let you represent a behavior or pass code in a concise way. -
 * Concise representation of an anonymous function that can be passed around - lambda parameters ->
 * body of the lambda - expression-style lambda, block-style lambda
 *
 * <p>Functional Interface - an interface that specifies exactly one abstract method. Function
 * Descriptor - signature of the abstract method of the functional interface describes the signature
 * of the lambda expression Default Methods
 *
 * <p>Method References - let you reuse existing method definitions and pass them like lambdas.
 *
 * <p>Composing Predicates - and, or and negate Composing Functions - f.andThen - g(f(x)), f.compose
 * - f(g(x)) Composing Comparators -thenComparing
 */
public class KeyConcepts {
    public static void main(String[] args) {
    keyWordsDemo();
    passingBehaviourDemo();
    composingComparators();
  }

  private static void composingComparators() {
    System.out.println("KeyConcepts.composingComparators");
    List<Apple> apples =
        Arrays.asList(
            new Apple(688.63, "red"),
            new Apple(988.63, "red"),
            new Apple(688.63, "white"),
            new Apple(688.63, "green"),
            new Apple(6855.6, "white"),
            new Apple(684.9, "green"));

    // Composing Comparators
    Comparator<Apple> appleWeightComparator = Comparator.comparing(Apple::getWeight);
    Comparator<Apple> appleColorComparator = Comparator.comparing(Apple::getColor);
    Comparator<Apple> appleWCComparator = appleWeightComparator.thenComparing(appleColorComparator);

    apples.sort(appleWCComparator);
    apples.forEach(System.out::println);

    System.out.println("KeyConcepts.composingComparators - 2");
    Comparator<Apple> appleCWComparator = appleColorComparator.thenComparing(appleWeightComparator);

    apples.sort(appleCWComparator);
    apples.forEach(System.out::println);
  }

  private static void keyWordsDemo() {
        List<String> strings = Arrays.asList("a", "b");

        // Lambda Expressions

        // "capturing lambda"
        // Functional Interface
        // Function Descriptor
        Comparator<String> stringComparator = (String a, String b) -> a.compareTo(b);

        // "type inference"
        Predicate<String> isNotEmpty = a -> !a.isEmpty();

        // Behavior parameterization
        strings.stream().filter(isNotEmpty).collect(Collectors.toList());

        // Method References
        strings.stream().filter(String::isEmpty).collect(Collectors.toList());

        // Composing Predicate
        Predicate<String> containsHi = a -> a.contains("hi");
        Predicate<String> containsHey = a -> a.contains("hey");
        isNotEmpty.and(containsHi).or(containsHey);
    }

  private static void passingBehaviourDemo() {

    // Passing behaviour before java 8
    File[] files =
        new File(".")
            .listFiles(
                new FileFilter() {
                  @Override
                  public boolean accept(File pathname) {
                    return pathname.isDirectory();
                  }
                });

    for (int i = 0; i < files.length; i++) System.out.println("files = " + files[i]);

    // After Java8
    File[] files1 = new File(".").listFiles(File::isDirectory);
    Arrays.stream(files1).forEach(System.out::println);

    // Another Examples
    List<Apple> apples =
        Arrays.asList(
            new Apple(688.63, "Red"), new Apple(6855.6, "white"), new Apple(684.9, "green"));

    Collections.sort(
        apples,
        new Comparator<Apple>() {
          @Override
          public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
          }
        });

    apples.sort(Comparator.comparing(Apple::getWeight));

    apples.forEach(System.out::println);
  }
}
