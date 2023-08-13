
public class OverrideExample {
    public static void main(String [] args) {
        Person jason = new Man("jason");
        Person celine = new Woman("celine");

        jason.hey(celine);
        celine.hey(jason);

        System.out.println(jason.getGender());
        System.out.println(celine.getGender());
    }
}
