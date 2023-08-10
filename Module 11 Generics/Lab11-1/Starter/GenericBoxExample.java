public class GenericBoxExample {
    public class Box {
        String name;
        Integer value;

        Box(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return  this.value;
        }
    }

    public void run() {
        Box box1 = new Box("box1");

        box1.setValue(1);
        System.out.println(box1.getName() + " has " + box1.getValue());
    }
    public static void main(String [] args) {
        GenericBoxExample example  = new GenericBoxExample();

        example.run();
    }
}
