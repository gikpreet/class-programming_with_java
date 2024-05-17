### Java Collections Framework 구성
* * *
* Java Collections Framework는 철저히 테스트된 다양한 인터페이스와 클래스로 구성
    * 클래스는 널리 사용되는 데이터 구조 및 알고리즘을 나타냄
        * Collection이 필요한 대부분의 응용 프로그램에 대해 프레임워크는 적절한 클래스를 제공
    * 추상 클래스
        * AbstractCollection, AbstractList, AbstractSet등의 추상 클래스 제공
        * 정의가 하위 클래스의 필드에 의존하는 모든 메소드를 추상으로 제공하고 해당 필드에 의지하지 않는 메소드를 정의
    * 타입 파라미터
        * 타입 파라미터를 사용하는 지네릭스 타입으로 선언됨
* * *
Java Collections Framework는 철저히 테스트된 다양한 인터페이스와 클래스로 구성됩니다. 클래스는 널리 사용되는 데이터 구조 및 알고리즘을 나타냅니다. Collection이 필요한 거의 모든 응용 프로그램 대해 적절한 클래스를 제공합니다. Java Collections Framework를 사용하면 “바퀴를 새로 발명할 필요 없이” 만들어진 클래스들을 사용할 수 있게 하여 생산성을 향상시킵니다.

Java Collections Framework는 AbstractCollection, AbstractList, AbstractSet 등 몇 개의 추상 클래스를 제공합니다. 이들 추상 클래스는 정의하 하위 클래스에 의존하는 모든 메소드를 추상으로 제공하고 해당 필드에 의존하지 않는 메소드를 정의합니다. 아래 그림은 ArrayList 클래스의 계층 구조를 보여줍니다.

<img src="../images/image01.png" />

또한 Java Collections Framework의 대부분의 클래스들은 타입 파라미터를 가지는 지네릭스 타입으로 되어 있습니다. Java Collections Framework에 포함된 ArrayList 클래스의 클래스 정의는 아래와 같습니다.

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
```
ArrayList 클래스의 인스턴스는 아래와 같은 방법으로 생성할 수 있습니다.

```java
AbstractList<String> list = new ArrayList<>();
```

<a href="./06_Collection_인터페이스.md">다음 장</a>