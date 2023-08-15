### Java Collections Framework
***
* Java Collection Framework는 java.util 패키지에 포함된 관련 인터페이스와 클래스의 모음
* 광범위하게 적용할 수 있는 여러 Collection 프레임워크를 제공함
* 타입 파라미터를 사용한 Generics 클래스 구현
* Framework의 클래스들은 Collection의 동작을 위한 공통적인 메소드를 가지고 있음
***

소프트웨어 프레임워크는 복잡한 문제를 해결하거나 서술하는데 사용되는 기본 개념 구조입니다. 프레임워크는 버즈워드로서 명확한 합의와 정의가 없는 용어로 불리지만, “Design Patterns: Elements of Reusable Object-Oriented Software”의 저자 중 한명인 랄프 존슨은 “소프트웨어의 구체적인 부분이 해당하는 설계와 구현을 재사용이 가능하게끔 협업화된 형태로 클래스들을 제공하는 것”이라고 정의했습니다.

Java Collections Framework는 java.util 패키지에 포함된 Collection 관련 인터페이스와 클래스의 모임입니다. Collections Framework는 광범위하게 사용될 수 있는 Collection 클래스들을 포함합니다. 

모든 Collections 프레임워크의 클래스들은 공통의 메소드를 가지고 있습니다. 
```Java
/**
 * Determines if this collection has no elements.
 *
 * @return true – if this collection has no elements
 *
 * /
public boolean isEmpty()
```
만약 myList라는 ArrayList 클래스의 인스턴스가 생성되고 myList에 요소가 포함되지 않았다면, 다음 코드는 true를 반환합니다.

```java
ArrayList<Integer> myList = new ArrayList<>();
System.out.println(myList.isEmpty());
```

아래와 같이 myList에 add 메소드를 통해 요소를 추가했다면, isEmpty 메소드는 false를 반환합니다.

```java
myList.add(1);
System.out.println(myList.isEmpty());
```

<a href="./04_Collection_클래스의_저장구조.md">다음 장</a>