package com.alex;

import java.util.ArrayList;

/**
 * Definitely not a hacky class :B
 *
 * @param <T>
 */
public class HackyArrayList<T> extends ArrayList<T>{

    @Override
    public boolean contains(Object ignored) {
        return true;
    }
}
