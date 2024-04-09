package org.example;

import java.util.Objects;

public class Human implements Comparable<Human> {
    String lastName;
    String firstName;
    String patronymic;
    int age;

    Human() {
    }

    ;

    Human(String lastName, String firstName, String patronymic, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return age == human.age && Objects.equals(lastName, human.lastName) && Objects.equals(firstName, human.firstName) && Objects.equals(patronymic, human.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, age);
    }

    @Override
    public int compareTo(Human otherHuman) {
        if (!Objects.equals(this.getLastName(), otherHuman.getLastName())) {
            return this.getLastName().compareTo(otherHuman.getLastName());
        } else {
            if (!Objects.equals(this.getFirstName(), otherHuman.getFirstName())) {
                return this.getFirstName().compareTo(otherHuman.getFirstName());
            } else {
                return this.getPatronymic().compareTo(otherHuman.getPatronymic());
            }
        }
    }
}