### ArrayList
***
* Java에서 가장 많이 사용되는 Collection 클래스
* 배열과 동일하게 연속된 메모리 공간을 사용
    * index를 사용하여 액세스 가능
    * 기본 크기 10개로 할당된 후 가변적으로 크기가 변함
    * 생성된 크기 이상이 저장되면 메모리에 추가로 할당됨
```java
ArrayList<String> list = new ArrayList<>();

for (int i = 0; i < list.size(); i++) {
    System.out.print(list.get(i) + " ");
}

for (String s: list) {
    System.out.print(s + " ");
}
```
***
ArrayList는 Java 프로그래밍에서 가장 많이 사용되는 Collection 클래스입니다. RandomAccess 인터페이스를 구현하여 index를 이용해서 비 순서로 액세스할 수 있으며, Cloneable 인터페이스를 구현하여 복제본을 만들어 낼 수 있습니다.

<img src="../images/image04.png" width="600" />

**ArrayList 생성**
*  기본 생성: 기본 크기가 10으로 설정됨
```java
ArrayList list = new ArrayList();
```
* 기본 크기를 20으로 생성
```java
ArrayList list = new ArrayList(20);
```
* 기본 크기가 20이면서 10씩 증가하는 ArrayList 생성
```java
ArrayList list = new ArrayList(20, 10);
```
**생성 및 데이터 삽입**
```java
List<String> list  = new ArrayList();
list.add("red");
list.add("green");
list.add("blue");
```
**처음 위치에 데이터 삽입**
```java
list.set(0,"white");
```
**데이터 삭제**
```java
list.remove("white");
```
**데이터 존재 확인**
```java
list.contains("green")
```

<a href="./15_LinkedList.md">다음 장</a>

