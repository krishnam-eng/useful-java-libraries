package edu.clap.libraries.java.streams;

import java.util.Arrays;
import java.util.List;

/*
    Streams APIs - "Declarative, Composable, Parallelizable"
                 - Let you manipulate collections of data in a declarative way

    Stream - Sequence of elements from a source that supports data-processing operation.
           - Elements of a stream are computed on-demand, can be processed in parallel.

    Internal Iteration vs External Iteration
        - Iteration is abstracted

    Intermediate vs Terminal Operation
        - returns a stream and can be chained together
        -
    Stateful vs Stateless Operation

    */
public class WorkingWithStreams {

    // External Iteration - need for "garbage variable"

    List<Dish> menu = getDishes();

    public static void main(String[] args) {
        

    }

    private List<Dish> getDishes() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }

}
