package org.example;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
//        Person person = new Person();
        Class<Person> clazz = Person.class;

        Person person = new Person("Wan", "Dijk", 36);
        Class<? extends Person> aClass = person.getClass();
        for (Field declaredField : aClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            System.out.println(declaredField.getName() + " = " + declaredField.get(person));
        }
    }
}
