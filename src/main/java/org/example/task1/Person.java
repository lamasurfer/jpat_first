package org.example.task1;

import java.util.Objects;

public class Person {

    private static final String DEFAULT_ADDRESS = "somewhere";

    private final String name;
    private final String surname;

    private int age;
    private String address;

    private Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public boolean hasAddress() {
        return !DEFAULT_ADDRESS.equals(address);
    }

    public void setAddress(String address) {
        Objects.requireNonNull(address, "В качестве адреса передан null!");
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Указан некорректный адрес!");
        }
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        } else {
            throw new IllegalStateException("Недопустимая операция!");
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0);
        if (hasAddress()) {
            return personBuilder.setAddress(this.address);
        } else {
            return personBuilder;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static class PersonBuilder {

        private String name;
        private String surname;
        private int age = -1;
        private String address = "somewhere";

        public PersonBuilder setName(String name) {
            checkNotNull(name, "name");
            checkNotEmpty(name, "name");
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            checkNotNull(surname, "surname");
            checkNotEmpty(surname, "surname");
            this.surname = surname;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if (age < 0 || age > 100) {
                throw new IllegalArgumentException("Указан некорректный возраст!");
            }
            this.age = age;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            checkNotNull(address, "address");
            checkNotEmpty(address, "address");
            this.address = address;
            return this;
        }

        public Person build() {
            checkState();
            return new Person(this);
        }

        private void checkState() {
            if (name == null || surname == null) {
                throw new IllegalStateException("Обязательные поля не заполнены!");
            }
        }

        private void checkNotNull(String field, String fieldName) {
            String message = String.format("В качестве аргумента поля \"%s\" передан null!", fieldName);
            Objects.requireNonNull(field, message);
        }

        private void checkNotEmpty(String field, String fieldName) {
            if (field.isEmpty()) {
                String message = String.format("В качестве аргумента \"%s\" передана пустая строка!", fieldName);
                throw new IllegalArgumentException(message);
            }
        }
    }
}
