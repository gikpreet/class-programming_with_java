### Iterable과 Iterator
* * *
* Iterable 인터페이스는 for-each 반복의 대상이 될 수 있는 타입의 추상적 동작을 정의
    * Iterator() 메소드를 통해 Iterator 타입 객체를 반환
    * forEach 메소드와 Spliterator Defailt 메소드 제공
* Iterator 인터페이스는 Collection에 저장되어 있는 요소들을 읽는 방법을 표준화 함
    * 사전적으로 반복자를 의미
    * 반복적인 데이터가 집합되어 있는 자료구조에서 데이터를 표준적인 방법으로 추출
        * 더 읽을 요소가 남아 있는지 확인 – hasNext()
        * 남아있는 요소를 읽음 – next()
* * *
Iterable 인터페이스는 for-each 반복의 대상이 될 수 있는 타입의 추상적 동작을 정의합니다. Iterable 인터페이스는 Iterator() 추상 메소드와 forEach, Spliterator 두 Default 메소드를 가지고 있습니다.

|Method|설명|
|-|-|
|Iterator<T> iterator()|T 타입을 요소로 가지는 Iterator 객체를 반환합니다.|
|default void forEach(Consumber<? super T> action)|Iterable의 모든 요소가 처리되거나 작업이 예외를 throw 할 때 까지의 각 요소에 대해 지정된 작업을 처리합니다.|
|default Spliterator<T> spliterator()|Spliterator를 반환합니다.|

아래 클래스는 Iterable의 서브 타입으로, for-each 반복의 대상이 될 수 있도록 Lecture 클래스를 정의합니다.

```java
import java.util.Iterator;

public class Lecture<E> implements Iterable<E> {
    E[] elements;
    int index;
    
    public Lecture(int size) {
        this.elements = (E[])new Object[size];
        this.index = 0;
    }

    public void add(E e) {
        if (this.index >= elements.length) {
            System.out.println("Class is full!");
            return;
        }
        else {
            this.elements[this.index++] = e;
        }
    }

    public Iterator<E> iterator() {
        return new LectureIterator<E>(this);
    }
}
```

Iterator 인터페이스는 반복적인 데이터가 집합되어 있는 자료구조에서 표준적인 방법으로 데이터를 추출할 수 있도록 추상화합니다.
|Method|설명|
|-|-|
|boolean hasNext()|읽어 올 다음 요소가 있는지 확인하는 메소드입니다. 있으면 true 없으면 false를 반환합니다.|
|E next();|읽어 올 요소가 남아있는지 확인하는 메소드입니다. 있으면 해당 객체를 반환합니다.|
|default void remove();|next()로 읽어온 요소를 삭제합니다.|

아래 클래스는 Iterator의 서브 타입으로, 반복하는 방법을 정의합니다.

```java
import java.util.Iterator;

public class LectureIterator<E> implements Iterator<E> {
    Lecture<E> lecture;
    int index = 0;

    public LectureIterator(Lecture<E> lecture) {
        this.lecture = lecture;
    }
    
    public boolean hasNext() {
        if (this.index >= lecture.elements.length) {
            return false;
        }
        else {
            return true;
        }
    }

    public E next() {
        return lecture.elements[this.index++];
    }
}
```

Collections 인터페이스를 확장한 List와 Set 인터페이스에서도 Iterator() 메소드를 사용할 수 있습니다. List, Map, Set등의 자료구조는 데이터를 가지고 있는 방법이 달라 각각 다른 방법으로 데이터를 읽어야 하지만, Iterator는 표준적인 읽는 방법을 가지고 있으므로 공통적인 문법을 사용하여 데이터를 읽을 수 있습니다.

**List 읽기**
```java
List list = new ArrayList<>();

for(int i = 65; i < 70; i++) {
    list.add(String.valueOf((char)i));
}

Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String str = iterator.next();
    System.out.println(str);
}
```
**HashSet 읽기**
```java
Set list = new HashSet<>();

for(int i = 65; i < 70; i++) {
    list.add(String.valueOf((char)i));
}

Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String str = iterator.next();
    System.out.println(str);
}
```

<a href="./10_Comparable.md">다음 장</a>