### Collections 동시성 처리
***
* 멀티스레드 환경에서는 동시성 처리가 필요함
    * 하나의 Collection 객체에 여러 스레드가 접근할 때
    * 데이터 일관성을 위한 Synchronize 처리가 필요
* Vector와 Hashtable은 동시성을 처리하도록 설계됨
    * 동시성 처리는 느리므로, 비 멀티스레드 환경을 위해 ArrayList, HashMap등을 사용
* ArrayList, HashMap등에 동시성 제어가 필요할 때 Collections 클래스를 사용

```java
List<String> list  = Collections.synchronizedList(new ArrayList());
```
***
Collection Framework의 Vector와 Hashtable 객체에는 멀티스레드 환경에서 데이터 일관성을 위한 처리가 되어있지만, Synchronize 처리를 위한 비용을 줄이기 위해 비 멀티스레드 환경에서는 ArrayList, HashMap등 Synchronize가 없는 객체를 사용합니다.

ArrayList, HashMap등 동시성 처리가 되어 있지 않은 객체에 동시성 처리가 필요할 때, Collections 클래스의 synchronizeList, SynchronizedSet, SynchronizedMap등의 동시성 지원 메소드를 사용할 수 있습니다.

<a href="./30_읽기전용_Collection.md">다음 장</a>

