### Comparator
***
* Comparable 인터페이스를 구현한 클래스의 기본 정렬 기준과 다르게 정렬할 때 사용
* 기본적인 정렬 기준(오름차순)을 기본 정렬 기준과 다르게 정렬하고 싶을 때 사용

```java
class DescendingOrder implements Comparator<User> {
    public int compare(User o1, User o2) {
        if(o1.getUserAge() > o2.getUserAge()){
            return -1;
        } else if(o1.getUserAge() < o2.getUserAge()){
            return 1;
        } else {
            return 0;
        }
    }
}
```
***
Comparator 인터페이스를 구현하는 클래스는 compare 메소드를 가지고 있고, 이 메소드는 기본적으로 제공되는 정렬 기준과 다른 정렬 기준을 사용하고 싶을 때 구현합니다.

|Method|설명|
|-|-|
|Int compare(T o1, T o2)|전달된 객체의 순서를 반환합니다.|

DecencingOrder 클래스는 Comparator 인터페이스를 구현합니다. DesendingOrder 클래스의 compare 메소드는 User의 나이를 기준으로 나이가 많으면 1을 반환합니다. 따라서 오름차순 정렬합니다.

<br />

```java
class DescendingOrder implements Comparator<User> {
    public int compare(User o1, User o2) {
        if(o1.getUserAge() > o2.getUserAge()){
            return -1;
        } else if(o1.getUserAge() < o2.getUserAge()){
            return 1;
        } else {
            return 0;
        }
    }
}
```

<a href="../Lab_15-1 Collection 인터페이스를 구현하는 클래스 구현.md">실습: Lab 15-1 Collection 인터페이스를 구현하는 클래스 구현</a> 


