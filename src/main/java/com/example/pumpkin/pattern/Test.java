package com.example.pumpkin.pattern;

import com.example.pumpkin.pattern.sortingstrategy.WeirdSortingStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {


        List<String> strings = new ArrayList<>(List.of(
                "abc",
                "bcd",
                "cab",
                "bac"
        ));

        strings.sort(Comparator.comparingInt(o -> o.charAt(1)));
        strings.forEach(System.out::println);
    }
}
