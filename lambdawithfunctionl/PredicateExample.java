package com.lambdawithfunctionl;


import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<Integer> ages = List.of(17, 18, 19, 28, 18, 28, 46, 7, 8, 9, 21, 12);
        NotLessThan18<Integer> isAdult = new NotLessThan18<>();
        
        ages.stream().filter(val -> val>=18).forEach(System.out::println);
    }
}



class NotLessThan18<E> implements Predicate<Integer> {

    @Override
    public boolean test(Integer v) {
        Integer ADULT = 18;
        return v >= ADULT;
    }
}