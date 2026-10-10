package designpattern;

public class Builder {
    static void main(String[] args) {
        Person person = new Person.PersonBuilder().setAge(10).setFirstName("Sandip").setLastName("Sawrikar").build();

        System.out.println("---" + person);
    }

}

class Person {
    private String firstName;
    private String lastName;
    private int age;
    // Other attributes and methods

    private Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
    }

    // Getter methods for attributes
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private int age;

        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public Person build() {
            return new Person(this);
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}