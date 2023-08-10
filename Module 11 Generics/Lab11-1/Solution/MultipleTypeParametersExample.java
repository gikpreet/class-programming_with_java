public class MultipleTypeParametersExample {
    public class Box<T, U> {
        U name;
        T value;

        Box(U name) {
            this.name = name;
        }

        public U getName() {
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
        Box<Integer, Integer> box1 = new Box<>(1);

        box1.setValue(1);
        System.out.println(box1.getName() + " has " + box1.getValue());
    }

    public static void main(String [] args) {
        MultipleTypeParametersExample example  = new MultipleTypeParametersExample();

        example.run();
    }
}

