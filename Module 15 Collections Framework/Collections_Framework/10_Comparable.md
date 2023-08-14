### Comparable
***
* 값을 비교하는데 사용되는 compareTo() 메소드를 정의
    * 같은 타입의 인스턴스를 비교해야 하는 클래스는 모두 Comparable 인터페이스를 구현
* Boolean을 제외한 모든 Wrapper 클래스는 모두 정렬이 가능
* Collections Framework에서 Collection에 저장되어 있는 요소들을 읽는 방법을 표준화

```java
public <T extends Comparable<T>> void bubbleSort(T[] items) {
    for(int i = items.length - 1; i > 0; i--) {
        for(int j = 0 ; j < i ; j++) {
            if (items[j].compareTo(items[j+1]) > 0) {
                T item = items[j];
                items[j] = items[j+1];
                items[j+1] = item;
            }
        }
    }
}
```
***

Comparable 인터페이스를 구현하는 클래스는 값을 비교하는 compareTo() 메소드를 구현합니다. 

|Method|설명|
|-|-|
|Int compareTo(T o)|이 개체를 지정된 개체와 비교하여 순서를 지정합니다.|

T의 타입을 Comparable로 제한하는 bubbleSort 메소드는 Comparable 인터페이스를 구현하는 요소로 구성된 모든 인터페이스를 정렬할 수 있습니다.

```java
public <T extends Comparable<T>> void bubbleSort(T[] items) {
    for(int i = items.length - 1; i > 0; i--) {
        for(int j = 0 ; j < i ; j++) {
            if (items[j].compareTo(items[j+1]) > 0) {
                T item = items[j];
                items[j] = items[j+1];
                items[j+1] = item;
            }
        }
    }
}
```

<a href="./11_Comparator.md">다음 장</a>

