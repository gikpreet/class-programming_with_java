### Collections 클래스 개요
***
* Collection 개체를 위한 여러 메소드를 제공하는 유틸리티 클래스
    * List, Set, Map등 모든 Collection 클래스에 사용
    * Collection 객체에 대한 생성, 정렬, 섞기, 병합, 검색등의 메소드를 제공
* static 메소드로 제공
```java
List numbers = Arrays.asList(1, 3, 10, 5, 8, 9, 7, 2, 6, 4);
Collections.max(numbers);
Collections.min(numbers);

Collections.sort(numbers);
Collections.binarySearch(numbers,3);
Collections.reverse(numbers);
Collections.shuffle(numbers);
```
***

java.util 패키지에 포함된 Collections 클래스는 Collection 객체를 위한 여러 메소드를 제공합니다. Collections 클래스는 List, Set, Map등 대부분의 Collection 클래스에 사용할 수 있으며 Collection 객체에 대한 정렬, 섞기, 병합, 검색 등의 기능을 static 메소드로 제공합니다.

**주요 메소드**
|Method|설명|
|-|-|
|static T min(Collection<? extends T> coll)|지정된 Collection의 가장 작은 요소를 반환합니다.|
|Static T max(Collection<? extends T> coll)|지정된 Collection의 가장 큰 요소를 반환합니다.|
|void sort(Comparator<? super E> c)|지정된 Collection을 오름차순으로 정렬합니다.|
|static void shuffle(List<?> list)|지정된 Collection을 랜덤으로 썩어줌니다.|
|binarySearch(List<? extends Comparable<? super T>> list, T key)|지정된 Collection에서 값을 찾아서 index를 반환합니다. |
|static boolean disjoint(Collection<?> c1, Collection<?> c2)|Collection c1, c2를 비교해서 일치하는 값이 하나도 없으면 true, 하나라도 있으면 false를 반환 합니다.|
|static <T> void copy(List<? super T> dest, List<? extends T> src)|지정된 collection의 모든 요소를 새로운 Collection으로 복사해서 반환 합니다.|
|static void reverse(List<?> list)|지정된 Collection을 역순으로 정렬합니다.|

**생성 (복사)**
```java
List<Integer> list = Arrays.asList(1, 3, 10, 5, 8, 9, 7, 2, 6, 4);
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
Collections.copy(numbers, list);
```
**최대값과 최소값**
```java
Collections.max(numbers);
Collections.min(numbers);
```
**정렬**
```java
Collection.sort(numbers);
```
**검색**
```java
Collections.binarySearch(numbers, 3);
```
**반전**
```java
Collections.reverse(numbers);
```
**섞기**
```java
Collections.shuffle(numbers);
```

<a href="./29_Collections_동시성_처리.md">다음 장</a>

