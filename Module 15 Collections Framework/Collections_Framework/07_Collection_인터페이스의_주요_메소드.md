### Collection 인터페이스의 주요 메소드
* * *
* Collection 인터페이스는 List, Set등 Java의 Collection 구현제들이 공통적으로 가지는 메소드를 정의
* Collection 인터페이스는 Iterable 인터페이스를 확장
    * Iterable 인터페이스는 반복을 위한 공통된 메소드를 가진 Iterator 인터페이스를 반환
    * 메소드를 통해 동일한 방식으로 Collection을 사용할 수 있음
* * *
Collection 인터페이스는 List, Set등 Java의 Collection 구현체들이 공통적으로 가지는 메소드를 정의합니다. Collection 인터페이스는 Iterable 인터페이스의 서브타입이며, Iterable 인터페이스를 Iterator() 메소드를 통해 반복을 위한 공통된 동작을 가진 Iterator 인터페이스를 반환합니다.

Java에서 Collection 구현체들은 이런 메소드를 통해 동일한 방법으로 사용될 수 있습니다. Collection 인터페이스는 아래의 메소드 구현을 강제하고, Collection의 서브 타입은 List, Set등의 구현체는 아래의 메소드들을 동일한 방법으로 사용할 수 있습니다.

|Method|설명|
|------|----|
|boolean add(E e) <br />boolean addAll(Collection<? extends E> c)|지정된 객체  e  또는 Collection(c) 객체들을 collection에 추가합니다. 작업을 성공하면 true반환 합니다.|
|void clear();|Collection의 모든 객체를 삭제합니다.|
|boolean contains(Object o)<br/>boolean containsAll(Collection<?> c)|Collection에 o 또는 Collection(c) 객체들이 Collection에 포함되었는지 체크 합니다. 존재하면 true , 존재하지 않는다면 |false를 반환합니다.|
|boolean equals(Object o)|동일한 객체(Collection) 인지 비교합니다. 같으면 true를 반환 합니다.|
|int hashCode()|Collection의 hash코드를 반환 합니다.|
|boolean isEmpty()|Collection이 비어있는지 확인합니다. 비어있다면 true를 반환 합니다.|
|Iterator<E> iterator()|Collection객체에서 Iterator를 반환 합니다.|
|boolean remove(Object o);<br />boolean removeAll(Collection<?> c)|객체를 삭제하거나  지정된 Collection에 포함된 객체를 삭제합니다. 삭제되면 true를 반환 합니다.|
|boolean retainAll(Collection<?> c)|remove 반대, 지정된 Collection에 포함된 객체가 있다면 해당 객체를 제외한 나머지 객체를 삭제 합니다. 삭제후 Collection의 변화가 있다면 true를 반환 합니다.|
|int size()|Collection의 저장된 객체의 Size를 반환 합니다.|
|Object[] toArray();|Collection에 저장된 객체를 Object[] 형태의 배열로 반환 합니다|
|<T> T[] toArray(T[] a)|지정된 배열에 T[] a 형태의 Collection의 객체를 저장해서 반환합니다.|
|default<br /> boolean removeIf(Predicate<? super E> filter)|Collection에서 Predicate<? super E> filter 조건에 해당하는 객체를 삭제합니다. java 1.8에 추가되었습니다.|

<a href="./08_Iterator_Comparable_Comparator.md">다음 장</a>
