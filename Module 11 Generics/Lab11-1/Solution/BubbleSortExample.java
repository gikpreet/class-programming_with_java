import java.util.Arrays;

public class BubbleSortExample {
    public <T extends Comparable<T>> void bubbleSort(T[] items) {
        for(int i = items.length - 1; i > 0; i--) {
            for(int j = 0 ; j < i ; j++)  {
                if (items[j].compareTo(items[j + 1]) > 0) {
                    T item = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = item;
                }
            }
            System.out.println((items.length - i) + "회 순환 후 : " + Arrays.toString(items));
        }
    }

    public void run() {
        Integer[] integerList =  {1, 10, 7, 2, 5, 4, 9, 8, 3, 6};
        String[] stringList =  {"James", "Robert", "John", "Michael", "William", "Noah", "Liam", "Jacob"};

        System.out.println("정렬 전 : " + Arrays.toString(integerList));
        bubbleSort(integerList);
        System.out.println("정렬 후 : " + Arrays.toString(integerList));

        System.out.println("정렬 전 : " + Arrays.toString(stringList));
        bubbleSort(stringList);
        System.out.println("정렬 후 : " + Arrays.toString(stringList));

    }

    public static void main(String[] args) {
        BubbleSortExample example = new BubbleSortExample();

        example.run();
    }
}
