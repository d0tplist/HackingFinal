package com.alex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Main {


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Constructor constructor =  SomeClass.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        SomeClass gg = (SomeClass) constructor.newInstance();

        try {
            Field field = SomeClass.class.getDeclaredField("originList");
            updateFinal(field, new HackyArrayList<>(), gg);

            System.out.println("GG? "+gg.getOriginList().contains("I win?"));
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Definitely not copied from stackoverflow
     * @param field the field obviously
     * @param newValue the new value
     * @throws Exception ok
     */
    static void updateFinal(Field field, Object newValue, Object parent) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(parent, newValue);
    }

}
