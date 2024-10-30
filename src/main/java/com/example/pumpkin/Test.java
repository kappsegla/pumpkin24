package com.example.pumpkin;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private final List<String> strings;

    public Test(List<String> strings) {
        this.strings = strings;
    }

    public static void main(String[] args) {
        var list = new ArrayList<String>();
        var test = new Test(list);
    }
}
