import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Comparator;

public class Department<E extends Comparable<E>> implements Iterable<E> {
    private List<E> list;
    
    public Department() {
        this.list = new ArrayList<>();
    }

    public void add(E element) {
        this.list.add(element);
    }

    public void sort() {
        Collections.sort(this.list);
    }

    public void sort(Comparator<E> comparator) {
       Collections.sort(this.list, comparator);
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}
