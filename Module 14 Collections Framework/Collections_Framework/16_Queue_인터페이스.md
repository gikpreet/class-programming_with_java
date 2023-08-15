### Queue 인터페이스
***
* Stack과 반대로 FIFO(First In First Out) 형태를 가지는 자료구조
* 데이터가 입력되는 순서대로 처리되어야 하는 상황에서 사용
* LinkedList는 Queue의 구현체

```java
Queue queue = new LinkedList();
queue.add("white");
queue.offer("green");
queue.element();
queue.peek()
queue.remove();
queue.poll();
queue.forEach(item->{
    System.out.println(item);
});
```
***

Queue는 Stack과 반대로 FIFO(First In First Out) 형태를 가지는 자료구조이며, 데이터가 입력되는 순서대로 처리되어야 하는 상황에서 사용됩니다. 

Java Collection Framework의 Queue는 인터페이스이며, LinkedList는 Queue 인터페이스의 구현체입니다.

<img src="../images/image06.png" width="600" />

**주요 메소드**
|Method|설명|
|-|-|
|public boolean add(E e)|element를 Queue에 추가합니다. 성공하면 true를 반환 합니다.저장공간이 부족하다면 IllegalStateException 발생합니다.|
|public boolean remove(Object o)|Queue에서 Object를 제거합니다.|
|public E element()|삭제없이 요소를 반환합니다. peek과는 달리 Queue가 비어있다면 NoSuchElementException 발생합니다.|
|public boolean offer(E e)|Queue에 객체를 저장 합니다. 성공하면 true, 실패하면 false를 반환합니다.|
|public E poll()|Queue에 객체를 꺼내서 반환합니다. 비어있다면 null을 반환합니다.|
|public E peek()|Queue에서 객체를 꺼내서 반환 합니다. 비어있으면 null을 반환합니다.|

**생성 및 데이터 삽입**
```java
Queue queue = new LinkedList();
queue.add("white");
queue.offer("green");
```
**데이터 조회 (꺼냄)**
```java
queue.peek();
queue.poll();
```
**데이터 조회 (삭제 없음)**
```java
queue.element()
```
**데이터 삭제**
```java
queue.remove();
queue.remove(“White”);
```
**데이터 순회**
```java
for(String color : list){
    System.out.println("color:" + color);
}

Iterator<String> iterator = list.iterator();
while(iterator.hasNext()){
    System.out.println("color:" + iterator.next());
}
```

<a href="./17_Vector.md">다음 장</a>

