public class DeprecatedExample {
    @SuppressWarnings({"deprecation"})
    public static void main(String [] args) {
        Person jason = new Person("jason");
        Person celine = new Person("celine");

        jason.hey(celine);
        celine.hey(jason);
    }
}
