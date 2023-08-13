public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void hey(Person person) {
        System.out.println("Hey, " + person.getName());
    }

    //
    // To-do: add hello method here.
    //
}
