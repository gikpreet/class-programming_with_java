import java.util.Iterator;

public class ArrayList implements Iterable<Integer> {
    private int[] elements;
    private int index = 0;
    
    public ArrayList() {
        this.elements = new int[10];
    }

    public void add(int item) {
        try {
            this.elements[this.index++] = item;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("List full!");
        }
    }

    public void remove(int index) {
        for (int i = index; i < this.index - 1; i++) {
            this.elements[i] = this.elements[i + 1];
            this.elements[i + 1] = 0;
        }
        this.index--;
    }

    public int get(int index) {
        return this.elements[index--];
    }

    public int size() {
        return this.index;
    }

    public Iterator<Integer> iterator() {
        return new ArrayListEnumerator(this);
    }
}