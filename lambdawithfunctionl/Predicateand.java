package com.lambdawithfunctionl;


import java.util.function.Predicate;

public class Predicateand {
    public static void main(String[] args) {
        Predicate<Integer> adultYet = i -> i >= 18;
        Predicate<Integer> adultStill = i -> i < 65;
        System.out.println(adultYet.and(adultStill).test(5));
        System.out.println(adultYet.and(adultStill).test(38));
        System.out.println(adultYet.and(adultStill).test(90));
    }
}