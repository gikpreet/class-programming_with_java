### List 인터페이스
***
* List는 중복을 허용하면서 저장 순서가 유지되는 자료구조
* 길이가 가변적이고 데이터 사이의 빈 공간을 허용하지 않음
* 배열의 인덱스와 같은 유일 식별자가 없음
* Collection 인터페이스의 서브 타입
* Vector, LinkedList, ArrayList등이 List 인터페이스의 서브 타입

<img src="../images/image03.png" width="400" />

***
List 인터페이스는 저장되는 데이터의 중복을 허용하면서 저장 순서가 유지되는 자료 구조입니다. List 인터페이스를 구현하는 Collection 개체들은 길이가 고정되어 있지 않고, 데이터 사이의 빈 공간을 허용하지 않습니다.

List 인터페이스는 아래와 같은 장점들을 가집니다.

* 데이터의 크기에 따른 동적 할당
* 빈 공간을 허용하지 않음
* 데이터의 삽입 삭제가 용이함

**주요 메소드**

|Method|설명|
|-|-|
|void add(int index, E element)|해당 index 위치에 요소를 추가 합니다.|
|boolean add(E e)|해당 요소를 추가 합니다.|
|E get(int index)|해당 위치의 요소를 반환 합니다.|
|int indexOf(Object o)|순방향 0번 위치부터 object 의 위치를 반환 합니다.|
|int lastIndexOf(Object o)|object의 위치를 반환 합니다.(역방향 마지막 위치부터 역으로 찾습니다.)|
|ListIterator<E> listIterator()<br />ListIterator<E> listIterator(int index)|Interator를 확장한 ListIterator를 반환합니다.|
|boolean remove(Object o)|object를 삭제 합니다. 성공하면 true를 반환 합니다.|
|E remove(int index)|index 위치의 객체를 삭제 후 삭제된 객체를 반환 합니다.|
|E set(int index, E element)|지정된 index 위치에 객체를 저장합니다.|
|sort(Comparator<? super E> c)|비교자(Comparator)에 의해서 List를 정렬합니다.|
|List<E> subList(int fromIndex, int toIndex)|지정된 범위 ( formIndex, toIndex)에 있는 객체를 반환 합니다.|
|static <E> List<E> of()|수정이 불가능한 emptyList 를 반환 합니다. java 9 추가 되었습니다.|
|static <E> List<E> of(E e1)|e1 <-- list 를  수정 불가능한  list ( ImmutableCollections) 반환 합니다. java 9에서 추가되었습니다.|

<a href="./14_ArrayList.md">다음 장</a>