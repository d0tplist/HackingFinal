package com.alex;

import java.util.ArrayList;
import java.util.List;

/**
 * Definitely a safe class
 */
public class SomeClass {

    private final List<String> originList = new ArrayList<>();

    private SomeClass(){
        originList.add("a");
        originList.add("b");
        originList.add("c");
        originList.add("d");
        originList.add("e");
        originList.add("f");
        originList.add("g");
        originList.add("h");
    }

    public List<String> getOriginList() {
        return originList;
    }
}
