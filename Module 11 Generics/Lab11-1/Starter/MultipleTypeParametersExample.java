public class MultipleTypeParametersExample {
    public class Box<T> {
        String name;
        T value;

        Box(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return  this.value;
        }
    }

    public void run() {
        Box<Integer> box1 = new Box<>("box1");

        box1.setValue(1);
        System.out.println(box1.getName() + " has " + box1.getValue());
    }
    public static void main(String [] args) {
        MultipleTypeParametersExample example  = new MultipleTypeParametersExample();

        example.run();
    }
}

