import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpperBoundedWildcardExample {
    public static class Box<T> {
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

    public static <T> void addItem(List<T> list, Box<? extends T> item) {
        list.add(item.getValue());
    }

    public static <T> void showList(List<T> list) {
        Iterator<T> it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next().toString() + ' ');
        }
        System.out.println("");

    }
    public static void main(String [] args)  {
        List<Number> list = new ArrayList<>();
        Box<Integer> box1 = new Box<>("box1");
        Box<Double> box2 = new Box<>("box2");
        box1.setValue(1);
        box2.setValue(2.0);

        addItem(list, box1);
        addItem(list, box2);

        showList(list);
    }
}
