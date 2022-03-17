package edu.clap.libraries.java.java8;

import java.nio.file.DirectoryStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Behavior parameterization
 *  - Ability for a method to take multiple different behaviors as parameters and use them internally to accomplish different behaviors
 *
 * Lambda Expressions
 *  - They let you represent a behavior or pass code in a concise way.
 *  - Concise representation of an anonymous function that can be passed around
 *  - lambda parameters -> body of the lambda
 *      - expression-style lambda, block-style lambda
 *
 *  Functional Interface
 *  - an interface that specifies exactly one abstract method.
 *  Function Descriptor
 *  - signature of the abstract method of the functional interface describes the signature of the lambda expression
 *  Default Methods
 *
 *  Method References
 *  - let you reuse existing method definitions and pass them like lambdas.
 *
 *  Composing Predicates
 *  - and, or and negate
 *  Composing Functions
 *  - f.andThen - g(f(x)), f.compose - f(g(x))
 *  Composing Comparators
 *  -thenComparing
 */
public class KeyConcepts {
    // execute-around pattern or strategy pattern

    // Common functional interfaces
    // Predicate<T> - test
    // Consumer<T> - accept
    // Function<T, R> - apply
    // Supplier<T>
    // Unary<T>
    // Binary<T, T>

    // , "free variables",

    public static void main(String[] args) {
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

}