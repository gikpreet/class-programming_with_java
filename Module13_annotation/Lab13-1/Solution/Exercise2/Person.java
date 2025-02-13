public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Deprecated
    public void hey(Person person) {
        System.out.println("Hey, " + person.getName());
    }

    public void hello(Person person) {
        System.out.println("Hello, " + person.getName());
    }    
}
