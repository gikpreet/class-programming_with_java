public class OverrideExample {
    public static void main(String [] args) {
        Person jason = new Man("jason");
        Person celine = new Woman("celine");

        jason.hey(celine);
        celine.hey(jason);

        //
        // To-do: Write gender check code here
        //
    }
}
