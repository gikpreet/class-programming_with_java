import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class WildcardExample{
    static <T> void showList(List<T> list) {
        Iterator<T> it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next().toString() + ' ');
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        List<Number> numberList = Arrays.asList(1, 2, 3);
        List<String> stringList = Arrays.asList("one", "two", "three");

        showList(numberList);
        showList(stringList);
    }
}
