public class BoundedGenericBoxExample {
    public class Box<T> {
        String name;
        T value;
        Box(String name) {
            this.name = name;
        }
        public String getName() {
            return  this.name;
        }
        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return  this.value;
        }
    }

    public void run() {
        Box<Integer> box1 = new Box<Integer>("box1");
        Box<String> box2 = new Box<String>("box2");

        box1.setValue(1);
        box2.setValue("Hello");
        System.out.println("Box1 has " + box1.getValue());
        System.out.println("Box2 has " + box2.getValue());
    }
    public static void main(String [] args) {
        BoundedGenericBoxExample example  = new BoundedGenericBoxExample();

        example.run();
    }
}
