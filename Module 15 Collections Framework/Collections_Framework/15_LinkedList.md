### LinkedList
***
* 노드라고 불리는 요소가 포인터와 주소를 사용하여 연결되는 자료구조
    * 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되는 방식
    * 해당 노드의 포인터가 이전 노드, 다음 노드의 연결을 할 수 있도록 저장
* 삽입 삭제가 쉽고 동적
    * 배열과 달리 데이터가 연속적으로 존재하지 않음
    * 모든 요소가 데이터를 연결(Link)한 형태의 자료 구조
* 직접적으로 노드에 접근할 수 없으며, 순회 방식의 접근

```java
LinkedList<String> list = new LinkedList<>();
list.add("red");list.addLast("pink");list.addFirst("yellow");
list.removeFirst(); list.removeLast();
for(String color : list){
    System.out.println("color:" + color);
}
```
***
LinkedList는 배열과 같이 데이터가 연속적으로 존재하지 않고 노드라 불리는 각 요소가 데이터와 포인터를 가지고 한 줄로 연결되는 방식의 자료구조입니다. 삽입 삭제가 쉽고 동적이기 때문에 선형으로 저장되고 중간 노드의 삽입 삭제가 없는 방식에 유리합니다.

LinkedList는 노드에 인덱스를 사용하는 방식으로 직접 접근할 수 없으며 Head 노드에서 시작하여 링크를 따라서 접근하는 순회 방식으로 데이터를 탐색합니다.

Serializable 인터페이스를 구현하여 쓰레드에 안전하며, Cloneable 인터페이스를 구현하여 복제 가능하고, Deque 인터페이스를 구현하여 처음과 끝 양쪽에서 데이터의 삽입과 삭제를 수행할 수 있습니다.

<img src="../images/image05.png" width="600" />

LinkedList는 배열과 같이 데이터가 연속적으로 존재하지 않고 노드라 불리는 각 요소가 데이터와 포인터를 가지고 한 줄로 연결되는 방식의 자료구조입니다. 삽입 삭제가 쉽고 동적이기 때문에 선형으로 저장되고 중간 노드의 삽입 삭제가 없는 방식에 유리합니다.

LinkedList는 노드에 인덱스를 사용하는 방식으로 직접 접근할 수 없으며 Head 노드에서 시작하여 링크를 따라서 접근하는 순회 방식으로 데이터를 탐색합니다.

Serializable 인터페이스를 구현하여 쓰레드에 안전하며, Cloneable 인터페이스를 구현하여 복제 가능하고, Deque 인터페이스를 구현하여 처음과 끝 양쪽에서 데이터의 삽입과 삭제를 수행할 수 있습니다.

**주요 메소드**
|Method|설명|
|-|-|
|public void addFirst(E e)|첫번째 요소로 추가 합니다.|
|public void addLast(E e)|마지막 요소로 추가 합니다.|
|public E removeFirst()|첫번째 요소를 제거 합니다.|
|public E removeLast()|마지막 요소를 제거 합니다.|
|public E getFirst()|첫번째 요소를 반환 합니다.|
|public E getLast()<br />ListIterator<E> listIterator(int index)|마지막 요소를 반환 합니다.|

**생성 및 데이터 삽입**
```java
LinkedList<String> list = new LinkedList<>();
list.add("red");
list.add("green");
list.add("white");
```
**처음과 끝 위치에 데이터 삽입**
```java
list.addLast("pink");
list.addFirst("yellow");
```
**데이터 삭제**
```java
list.removeFirst();
list.removeLast();
```
**데이터 접근**
```java
for(String color : list){
    System.out.println("color:" + color);
}

Iterator<String> iterator = list.iterator();
while(iterator.hasNext()){
    System.out.println("color:" + iterator.next());
```

<br />

