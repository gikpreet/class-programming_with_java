import java.util.Iterator;

public class ArrayListEnumerator implements Iterator<Integer> {
    ArrayList list;
    int index = 0;

    public ArrayListEnumerator(ArrayList list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (list.size() < this.index) {
            return false;
        }
        else {
            return true;
        }
    }

    public Integer next() {
        return list.get(this.index++);
    }
}
