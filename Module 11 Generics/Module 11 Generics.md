# Module 13 Generics
이 모듈에서는 Java에서 파라미터를 이용한 다형성을 구현할 수 이는 Generics에 대해 알아보고, Generics를 이용해 메소드 또는 클래스를 사용하여 보다 폭 넓은 방식의 객체를 구현하여 얻을 수 있는 이점에 대해 학습합니다.

이 모듈을 마치면, 다음과 같은 것들을 할 수 있게 됩니다:
* Generics에 대해 이해하고, 설명할 수 있습니다.
* Generics를 이용해 타입과 메소드를 정의할 수 있습니다.
* Generics를 이용해 런타임에서 발생할 오류를 컴파일 타임에 찾아 수정할 수 있습니다.
* Generics를 이용해 이전에 작성한 코드를 보다 다양하게 사용할 수 있는 코드로 수정할 수 있습니다.

#### Table of Contents
1. Generics 개요
2. Generic 타입
3. Generic 메소드
4. 타입 파라미터
5. 타입 삭제
6. 제한 사항

<br />
<br />
<br />
<br />
<br />

## Generics 개요
Generics는 Generic이라는 단어가 주는 의미처럼, 다양한 타입에 적용할 수 있는 객체를 만들수 있도록 지원합니다. 이 장에서는 Java 언어의 Generics 개요에 대해 알아봅니다.

#### Table of Contents
1. Generics 개요
2. 강력한 타입 검사
3. 형 변환 감소
4. 일반 알고리즘의 구현

<br />

### Generics 개요
***
* 객체 생성시 부여되는 타입을 이용한 파라미터 다형성(Parametric Polymorphism) 구현
* 타입(Class, Interface) 또는 메소드에 정의
```java
class Box<T> {
    T item;
    ...
}
Box<String> stringBox = new Box<>(“String”);
Box<Integer> integerBox = new Box<>(100);

class Box<T> {
    T item;
    
    public T simpleFunction(T item) { ... }
}
```
***
Generics는 Generic이라는 단어가 주는 의미<sup id="a1">[1](#footnote1)</sup>처럼 다양한 타입에 적용할 수 있도록 지원합니다. 지네릭스는 타입(클래스, 인터페이스)에 정의 가능하며 메소드 정의에도 사용할 수 있습니다.
```java
class Box<T> {
    T item;

    public Box(T string) {
        this.item = string;
    }

    public T getItem() {
        return this.item;
    }
}
```
지네릭스는 객체 생성시 명확한 타입 적용을 통해 컴파일러에서 타입 사용에 대한 안정성 검사를 지원합니다. 또한, 객체 생성시 주어지는 타입 정보는 불필요한 타입 변환을 줄여 간결한 코드 작성을 도와줍니다. 

클래스나 메소드의 작성시 타입 파라미터를 통해 타입 지정이 가능하도록 하여, 특정 타입에 국한되지 않는 코드 작성으로 특정 타입에 제한되지 않는 일반적인(Generic 한) 알고리즘 구현이 가능하도록 합니다.

<sup id="footnote1">1</sup> 형용사, 포괄적인, 총칭(통칭)의. 

<br />

### 강력한 타입 검사
***
* Generics는 타입 안정성(Type Safety)를 지원
    * 타입 파라미터를 통해 전달된 타입 정보를 이용하여 컴파일 타임에 검사
* java.lang.Object 타입으로 변환되는 객체 형 변환은 런타임에 검사됨
    * 컴파일시에 오류를 발견할 수 없음
    * java.lang.ClassCastException 예외 발생
* Generics는 타입이 명확히 명시되므로 컴파일 타임에 오류를 검출할 수 있음
***

Generic이 적용되면 타임 파라미터를 기준으로 타입 안정성을 검사합니다. 이는 코드 작성 중 빈번히 발생될 수 있는 타입 검사 오류를 컴파일시에 확인해 줌으로써, 코드 작성 중 검출할 수 없고 런타임에 발생하는 오류 처리에서 발생하는 손실 비용을 최소화할 수 있도록 해 줍니다.

Generoc이 적용되지 않은 코드에서 일반적인 데이터를 처리하기 위해서는 데이터를 최상위 타입인 java.lang.Object로 처리합니다. 

```java
public class TypeSafetyExample {
    public static class Box {
        Object item;

        public void set(Object item) {
            this.item = item;
        }

        public Object get() {
            return this.item;
        }
    }
    public static void main(String [] args) {
        Box box = new Box();
        box.set("Hello");
        Integer value = (Integer) box.get();
        System.out.println("Value is " + value);
    }
}
```
위 코드는 전역변수 item이 일반적인 데이터를 처리하도록 하기 위해 Object 타입을 사용합니다. item의 setter 메소드에서 item에 Hello 문자열을 저장할 경우, String 타입은 Object의 서브타입이므로 item의 값을 가져오기 위해서는 Object 타입을 String 타입으로 타입 변환해야 합니다. 이 경우 컴파일러는 특정 타입을 Object로 타입 변환하는 것에 대해 오류를 발생하지 않습니다.

오류는 프로그램을 실행할 때 발생합니다. 프로그램은 타입 사이의 변환 실패로 오류를 출력하고 실행을 종료합니다. 
```bash
$ java TypeSafetyExample    
Exception in thread "main" java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
        at TypeSafetyExample.main(TypeSafetyExample.java:16)
```
해당 코드에 Generic을 적용하면 이런 종류의 런타임 오류를 회피할 수 있습니다.
```java
public class TypeSafetyGenericsExample {
    public static class Box<T> {
        T item;

        public void set(T item) {
            this.item = item;
        }

        public T get() {
            return this.item;
        }
    }
    public static void main(String [] args) {
        Box<String> box = new Box<>();
        box.set("Hello");
        Integer value = box.get();
        System.out.println("Value is " + value);
    }
}
```

Generic을 사용하여 수정한 위 코드는 컴파일 타임에 오류를 검출합니다.

```java
> javac TypeSafetyGenericsExample.java
TypeSafetyGenericsExample.java:16: error: incompatible types: String cannot be converted to Integer
        Integer value = box.get();
```
Generic의 적용은 타입 검사를 통해 런타임에 발생할 수 있는 타입 오류를 컴파일시에 찾아 줌으로써 오류 발생 지연을 방지하는 기능을 수행할 수 있습니다.

<br />

### 타입 변환 감소
***
* 수퍼 타입을 서브 타입으로 변환하기 위해서는 타입 변환이 필요함
```java
public class TypeSafetyExample {
    public static class Box {
        Object item;
        …
    }
    public static void main(String [] args) {
        …
        Integer value = (Integer) box.get();
        …
    }
}
```
* Generic을 적용할 경우 별도의 타입 변환 과정을 필요로 하지 않음
```java
public class TypeSafetyGenericsExample {
    public static class Box<T> {
        T item;
        …
    }
    public static void main(String [] args) {
        …
        Integer value = box.get();
        …
    }
}
```
***

Generic이 적용되지 않은 경우, Box 클래스의 전역 변수 item이 다양한 타입을 처리할 수 있도록 정의되어야 하는 경우 java.lang.Object로 선언됩니다. Java에서 기본 데이터 타입(Primitive Data Type)을 제외한 모든 타입은 Object의 서브 타입이므로 데이터의 설정에는 별다른 작업이 필요하지 않습니다.

하지만 데이터를 사용해야 하는 경우에 Box에 저장되어 있는 데이터는 클래스 인스턴스 타입으로 변환되어야 합니다. 이 과정을 수행할 때 마다 타입 변환이 요구됩니다.

이에 비해 Generic을 적용할 경우 클래스의 전역 변수 타입이 타입 인자를 통해 명확하게 설명되므로 컴파일러에서 확인이 가능하여, 이를 통해 데이터 간 호환 타입에 대한 부가적인 설명이 필요 없게 되어 타입 변환이 없는 간결한 코드 작성이 가능합니다.

<br />

### 알고리즘 일반화 구현
***
* Generics는 알고리즘 일반화를 구현할 수 있도록 함
    * 다양한 타입의 객체들을 다루는 메소드나 컬렉션 클래스에 컴파일 시 타입 체크를 가능하도록 함
```java 
public static <T extends Comparable<T>> void bubbleSort(T[] items) {
    for(int i = items.length - 1 ; i > 0 ; i--) {
        for(int j = 0 ; j < i ; j++)  {
            if (items[j].compareTo(items[j+1]) > 0) {
                T item = items[j];
                items[j] = items[j+1];
                items[j+1] = item;
            }
        }
    }
}
```
* 타입 파라미터가 Compatable의 서브 타입이면 정렬 가능하도록 정의
* 비교 가능한 아이템의 경우 정렬이 가능하도록 선언하며, 특정 데이터 타입에 국한되지 않는 일반적인 알고리즘의 구현이 가능
***

Generics는 모듈이나 알고리즘을 구현한 후 다양한 타입에 적용할 수 있도록 지원합니다. 

버블 정렬은 각 항목의 비교를 통해 항목의 순서를 정렬하는 잘 알려진 알고리즘입니다. 일반적인 버블 정렬 알고리즘은 하나의 타입에 대한 정렬을 수행하지만, 지네릭스는 항목간 비교가 가능한 Comparable 항목이라면 정렬 가능한 일반적인 알고리즘 작성을 가능하게 합니다. 또한, 알고리즘 구현 단계에서 특정 타입을 이용한 검증을 통해 알고리즘의 신뢰성이 확보되었다면 다른 타입에 대해서도 신뢰성이 보장되었다고 할 수 있습니다.

```java
public class BubbleSortExample {
    public static <T extends Comparable<T>> void bubbleSort(T[] items) {
        for(int i = items.length - 1 ; i > 0 ; i--) {
            for(int j = 0 ; j < i; j++)  {
                if (items[j].compareTo(items[j+1]) > 0) {
                    T item = items[j];
                    items[j] = items[j+1];
                    items[j+1] = item;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integerList =  {1, 10, 7, 2, 5, 4, 9, 8, 3, 6};
        String[] stringList =  {"James", "Robert", "John", "Michael", "William", "Noah", "Liam", "Jacob"};

        System.out.println("정렬 전 : " + Arrays.toString(integerList));
        bubbleSort(integerList);
        System.out.println("정렬 후 : " + Arrays.toString(integerList));

        System.out.println("정렬 전 : " + Arrays.toString(stringList));
        bubbleSort(stringList);
        System.out.println("정렬 후 : " + Arrays.toString(stringList));
    }
}
```
실행 결과는 아래와 같습니다.
```
정렬 전 : [1, 10, 7, 2, 5, 4, 9, 8, 3, 6] 
정렬 후 : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 
정렬 전 : [James, Robert, John, Michael, William, Noah, Liam, Jacob] 
정렬 후 : [Jacob, James, John, Liam, Michael, Noah, Robert, William]
```