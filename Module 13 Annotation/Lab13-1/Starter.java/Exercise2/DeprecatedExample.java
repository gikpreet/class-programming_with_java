public class DeprecatedExample {
    public static void main(String [] args) {
        Person jason = new Person("jason");
        Person celine = new Person("celine");

        jason.hey(celine);
        celine.hey(jason);
    }
}
